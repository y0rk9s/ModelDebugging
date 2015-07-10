package org.gemoc.gemoc_language_workbench.api.extensions.languages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.gemoc.gemoc_language_workbench.api.core.IModelLoader;
import org.gemoc.gemoc_language_workbench.api.dsa.ICodeExecutor;
import org.gemoc.gemoc_language_workbench.api.dse.IMSEStateController;
import org.gemoc.gemoc_language_workbench.api.engine_addon.IEngineAddon;
import org.gemoc.gemoc_language_workbench.api.extensions.Extension;
import org.gemoc.gemoc_language_workbench.api.moc.ISolver;
import org.gemoc.gemoc_language_workbench.conf.LanguageDefinition;

public class LanguageDefinitionExtension extends Extension {

	final public ICodeExecutor instanciateCodeExecutor() throws CoreException {
		Object instance = instanciate(LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_CODEEXECUTOR_ATT);
		if (instance instanceof ICodeExecutor) {
			return (ICodeExecutor) instance;
		}
		throwInstanciationCoreException();
		return null;
	}

	final public ISolver instanciateSolver() throws CoreException {
		Object instance = instanciate(LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_SOLVER_ATT);
		if (instance instanceof ISolver) {
			return (ISolver) instance;
		}
		throwInstanciationCoreException();
		return null;
	}

	final public IModelLoader instanciateModelLoader() throws CoreException {
		Object instance = instanciate(LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_LOADMODEL_ATT);
		if (instance instanceof IModelLoader) {
			return (IModelLoader) instance;
		}
		throwInstanciationCoreException();
		return null;
	}

	final public String getQVTOPath() {
		return _configurationElement
				.getAttribute(LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_TO_CCSL_QVTO_FILE_PATH_ATT);
	}

	final public Collection<IEngineAddon> instanciateEngineAddons() throws CoreException {
		ArrayList<IEngineAddon> addons = new ArrayList<IEngineAddon>();
		for (IConfigurationElement childConfElement : _configurationElement
				.getChildren(LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT_ENGINE_ADDON_DEF)) {
			childConfElement.getName();
			final Object addon = childConfElement
					.createExecutableExtension(LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT_ENGINE_ADDON_DEF_ENGINE_ADDON_ATT);
			if (addon instanceof IEngineAddon) {
				addons.add((IEngineAddon) addon);
			}
		}
		return addons;
	}

	final public Collection<IMSEStateController> instanciateMSEStateControllers() throws CoreException {
		ArrayList<IMSEStateController> controllers = new ArrayList<IMSEStateController>();
		for (IConfigurationElement childConfElement : _configurationElement
				.getChildren(LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT_MSE_STATE_CONTROLLER_DEFINITION)) {
			childConfElement.getName();
			final Object c = childConfElement
					.createExecutableExtension(LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT_MSE_STATE_CONTROLLER_CLASS_DEFINITION);
			if (c instanceof IMSEStateController) {
				controllers.add((IMSEStateController) c);
			}
		}
		return controllers;
	}

	public String getName() {
		return getAttribute(LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_NAME_ATT);
	}

	public String getXDSMLFilePath() {
		return getAttribute(LanguageDefinitionExtensionPoint.GEMOC_LANGUAGE_EXTENSION_POINT_XDSML_DEF_XDSML_FILE_PATH_ATT);
	}

	private LanguageDefinition _languageDefinitionCache;

	public LanguageDefinition getLanguageDefinition() {
		if (_languageDefinitionCache == null) {

			// Loading languagedef model
			ResourceSet rs = new ResourceSetImpl();
			URI uri = URI.createPlatformResourceURI(getXDSMLFilePath(), true);

			Resource res = rs.createResource(uri);
			try {
				res.load(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			EcoreUtil.resolveAll(rs);// IMPORTANT

			if (res != null) {
				EObject first = res.getContents().get(0);

				// Follow-up in other operation...
				if (first instanceof LanguageDefinition) {
					_languageDefinitionCache = (LanguageDefinition) first;
				}
			}
		}
		return _languageDefinitionCache;
	}

}
