package fr.inria.diverse.trace.gemoc.ui.contextmenu

import java.io.PrintWriter
import java.io.StringWriter
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.resources.IFile
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.Status
import org.eclipse.core.runtime.jobs.Job
import org.eclipse.jface.viewers.ISelection
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.ui.handlers.HandlerUtil
import fr.inria.diverse.trace.gemoc.generator.GenericEngineTraceAddonGeneratorHelper


/**
 * Handler that allows to get an XDSML project (containing a melange file) 
 * and will ask for selection of the language (if necessary) and launch the generation
 */
class XDSMLProject2TraceAddonHandler extends AbstractHandler {

	val static String pluginId = "fr.inria.diverse.trace.gemoc.ui"

	override execute(ExecutionEvent event) throws ExecutionException {
//
//		// Getting selection
//		val ISelection selection = HandlerUtil.getActiveWorkbenchWindow(event).getActivePage().getSelection();
//
//		// Should be a structured selection
//		if (selection instanceof IStructuredSelection) {
//
//			// Should be a unique file			
//			val selectedFile = selection?.toList?.filter(IFile)?.get(0)
//
//			if (selectedFile != null) {
//
//				// We prepare a nice job to do that out of the UI thread
//				val Job j = new Job("Generating trace addoc for " + selectedFile.toString) {
//					override protected run(IProgressMonitor monitor) {
//						try {
//							GenericEngineTraceAddonGeneratorHelper.generateAddon(selectedFile, monitor)
//						} catch (Exception e) {
//							val StringWriter sw = new StringWriter();
//							e.printStackTrace(new PrintWriter(sw));
//							val String exceptionAsString = sw.toString();
//							return new Status(Status.ERROR, pluginId, exceptionAsString)
//						}
//						return new Status(Status.OK, pluginId, "Trace addon generated.")
//					}
//				}
//
//				// And we start the job
//				j.schedule
//
//			}
//		}
		return null;
	}

}
