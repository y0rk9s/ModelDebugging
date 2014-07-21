package org.gemoc.execution.engine.capabilitites;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceState;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.internal.spec.AttributeChangeSpec;
import org.eclipse.emf.compare.match.IMatchEngine;
import org.eclipse.emf.compare.postprocessor.IPostProcessor;
import org.eclipse.emf.compare.rcp.EMFCompareRCPPlugin;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.gemoc.execution.engine.commons.Activator;
import org.gemoc.execution.engine.core.LogicalStepHelper;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.Choice;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.ContextState;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.ExecutionTraceModel;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.GemocExecutionEngineTraceFactory;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.ModelState;
import org.gemoc.execution.engine.trace.gemoc_execution_trace.SolverState;
import org.gemoc.gemoc_language_workbench.api.core.GemocExecutionEngine;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionContext;
import org.gemoc.gemoc_language_workbench.api.core.IExecutionEngineCapability;
import org.gemoc.gemoc_language_workbench.api.dsa.CodeExecutor;
import org.gemoc.gemoc_language_workbench.api.moc.Solver;

import fr.inria.aoste.trace.EventOccurrence;
import fr.inria.aoste.trace.LogicalStep;

public class ModelExecutionTracingCapability implements IExecutionEngineCapability {

	private GemocExecutionEngine _engine;
	
	@Override
	public void initialize(GemocExecutionEngine engine) {
		_engine = engine;
		_editingDomain = _engine.getExecutionContext().getEditingDomain();
	}

	private boolean _backToPastHappened = false;
	public void backToPast(Choice choice) throws ModelExecutionTracingException {
		int index = _executionTraceModel.getChoices().indexOf(choice);
		if (index == (_executionTraceModel.getChoices().size()-1))
			return;
		backInTraceModelTo(choice);
		_backToPastHappened = true;
		if (_engine.getLogicalStepDecider() != null) 
		{
			_engine.getLogicalStepDecider().preempt();
		}
	}

	private void backInTraceModelTo(final Choice choice) {
		final int index = _executionTraceModel.getChoices().indexOf(choice);
		if (index != -1
			&& index != _executionTraceModel.getChoices().size()) {
			final CommandStack commandStack = _editingDomain.getCommandStack();
			commandStack.execute(new RecordingCommand(_editingDomain) {
				@Override
				protected void doExecute() {
					_executionTraceModel.getChoices().subList(index, _executionTraceModel.getChoices().size()).clear();
					if (_executionTraceModel.getChoices().size() > 0)
						_executionTraceModel.getChoices().get(_executionTraceModel.getChoices().size()-1).setNextChoice(null);
					try {
						restoreModelState(choice);
						restoreSolverState(choice);
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

	private void restoreModelState(Choice choice) {
		// Configure EMF Compare
		IMatchEngine.Factory.Registry matchEngineRegistry = EMFCompareRCPPlugin.getDefault().getMatchEngineFactoryRegistry();
	    IPostProcessor.Descriptor.Registry<String> postProcessorRegistry = EMFCompareRCPPlugin.getDefault().getPostProcessorRegistry();
		EMFCompare comparator = EMFCompare.builder()
	                                           .setMatchEngineFactoryRegistry(matchEngineRegistry)
	                                           .setPostProcessorRegistry(postProcessorRegistry)
	                                           .build();
		// Compare the two models
		IComparisonScope scope1 = EMFCompare.createDefaultScope(choice.getContextState().getModelState().getModel(), _executionContext.getResourceModel().getContents().get(0));
		Comparison otherComparison = comparator.compare(scope1);
		otherComparison.getDifferences();
		
		Merger merger = new Merger();
		BasicMonitor monitor = new BasicMonitor();
		for (Diff diff : otherComparison.getDifferences()) {
			
			if (diff instanceof AttributeChangeSpec) 
			{
				// if attribute, modify value on the aspect side that will modify the model in return.
				AttributeChangeSpec asc = (AttributeChangeSpec)diff;
				CodeExecutor codeExecutor = _engine.getExecutionContext().getCodeExecutor();
				EObject target = diff.getMatch().getRight();
				String methodName = asc.getAttribute().getName();
				ArrayList parameters = new ArrayList();
				parameters.add(asc.getValue());
				try {
					System.out.println("Begin setting " + target.toString() + "." + methodName + " = " + asc.getValue());
					codeExecutor.invoke(target, methodName, parameters);
					System.out.println("End setting " + target.toString() + "." + methodName + " = " + asc.getValue());
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				// if reference, use the merger.
				merger.copyLeftToRight(
						diff,
						monitor);			
				diff.setState(DifferenceState.UNRESOLVED);				
			}
		}			
	}
	
	byte[] _lastRestoredSolverState;
	private void restoreSolverState(Choice choice) 
	{
		Solver solver = _engine.getExecutionContext().getSolver();
		Activator.getDefault().debug("restoring solver state: " + choice.getContextState().getSolverState().getSerializableModel());
		solver.setState(choice.getContextState().getSolverState().getSerializableModel());
		boolean b = Arrays.equals(solver.getState(), choice.getContextState().getSolverState().getSerializableModel());
		if (b)
			Activator.getDefault().debug("new state does equal the restored state");
		else
			Activator.getDefault().debug("new state does NOT equal the restored state");
	}

	public boolean hasRewindHappened(boolean resetFlag) {
		boolean result = _backToPastHappened;
		if (resetFlag)
			_backToPastHappened = false;
		return result;
	}

	private TransactionalEditingDomain _editingDomain;
	
	public void saveTraceModel(long stepNumber) throws CoreException, IOException {
		Resource traceResource = _executionTraceModel.eResource();
		if (traceResource.getContents().size() > 0) 
		{			
		    Copier copier = new GCopier();		    
		    EObject result = copier.copy(_executionContext.getResourceModel().getContents().get(0));
		    copier.copyReferences();
			
			ExecutionTraceModel traceModel = (ExecutionTraceModel)traceResource.getContents().get(0);				
			if (traceModel.getChoices().size() > 0) 
			{
				// link it to the trace model
				ModelState modelState = GemocExecutionEngineTraceFactory.eINSTANCE.createModelState();					
				traceResource.getContents().add(result);
				modelState.setModel(result);
				
				SolverState solverState = GemocExecutionEngineTraceFactory.eINSTANCE.createSolverState();									
				solverState.setSerializableModel(_engine.getExecutionContext().getSolver().getState());
				Activator.getDefault().debug("step" + stepNumber + ", saving solver state: " 
						 + solverState.getSerializableModel());
				
				ContextState contextState = GemocExecutionEngineTraceFactory.eINSTANCE.createContextState();
				contextState.setModelState(modelState);
				contextState.setSolverState(solverState);
				traceModel.getChoices().get(traceModel.getChoices().size()-1).setContextState(contextState);
			}
		}
	}

	private ExecutionTraceModel _executionTraceModel = GemocExecutionEngineTraceFactory.eINSTANCE.createExecutionTraceModel();

	private IExecutionContext _executionContext;
	public void setModelExecutionContext(IExecutionContext executionContext) {
		_executionContext = executionContext;
		ResourceSet rs = _executionContext.getResourceModel().getResourceSet();
		URI traceModelURI = URI.createPlatformResourceURI(_executionContext.getWorkspace().getExecutionPath().toString() + "/trace.xmi", false);
		final Resource modelResource = rs.createResource(traceModelURI);
		final CommandStack commandStack = _editingDomain.getCommandStack();
		commandStack.execute(new RecordingCommand(_editingDomain) {
			@Override
			protected void doExecute() {
				modelResource.getContents().add(_executionTraceModel);
			}
		});
	}

	public Choice getLastChoice() {
		if (_executionTraceModel.getChoices().size() > 0)
			return _executionTraceModel.getChoices().get(_executionTraceModel.getChoices().size()-1);
		else 
			return null;
	}


	private Choice _lastChoice;

	public void updateTraceModelBeforeAskingSolver(final long count) {
		final CommandStack commandStack = _editingDomain.getCommandStack();
		commandStack.execute(new RecordingCommand(_editingDomain) {

			@Override
			protected void doExecute() {
				Choice newChoice = createChoice();
				if (_lastChoice != null) {
					_lastChoice.setNextChoice(newChoice);
				}
				_lastChoice = newChoice;
				_executionTraceModel.getChoices().add(_lastChoice);
				try {
					saveTraceModel(count);
				} catch (CoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
	private Choice createChoice() {
		Choice choice = GemocExecutionEngineTraceFactory.eINSTANCE.createChoice();
		return choice;
	}

	public void updateTraceModelBeforeDeciding(final List<LogicalStep> possibleLogicalSteps) {
		final CommandStack commandStack = _editingDomain.getCommandStack();
		commandStack.execute(new RecordingCommand(_editingDomain) {

			@Override
			protected void doExecute() {
				_lastChoice.getPossibleLogicalSteps().addAll(possibleLogicalSteps);
				for (LogicalStep ls : possibleLogicalSteps) {
					LogicalStepHelper.removeNotTickedEvents(ls);
				}
				_executionTraceModel.getChoices().add(_lastChoice);
				for (LogicalStep step : _lastChoice.getPossibleLogicalSteps()) {
					for (EventOccurrence occurence : step.getEventOccurrences()) {
						_executionTraceModel.eResource().getContents().add(occurence.getReferedElement());
					}
				}
			}
		});
	}
	
	public void updateTraceModelAfterDeciding(final int selectedLogicalStepIndex) {
		final CommandStack commandStack = _editingDomain.getCommandStack();
		commandStack.execute(new RecordingCommand(_editingDomain) {

			@Override
			protected void doExecute() {
				if (_lastChoice.getPossibleLogicalSteps().size() == 0)
					return;
				_lastChoice.setChosenLogicalStep(_lastChoice.getPossibleLogicalSteps().get(selectedLogicalStepIndex));
			}
		});
	}

	public ExecutionTraceModel getExecutionTrace() {
		return _executionTraceModel;
	}
}
