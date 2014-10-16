/**
 */
package org.gemoc.gemoc_language_workbench.conf.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.gemoc.gemoc_language_workbench.conf.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.gemoc.gemoc_language_workbench.conf.confPackage
 * @generated
 */
public class confSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static confPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public confSwitch() {
		if (modelPackage == null) {
			modelPackage = confPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case confPackage.LANGUAGE_DEFINITION: {
				LanguageDefinition languageDefinition = (LanguageDefinition)theEObject;
				T result = caseLanguageDefinition(languageDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case confPackage.PROJECT_RESOURCE: {
				ProjectResource projectResource = (ProjectResource)theEObject;
				T result = caseProjectResource(projectResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case confPackage.DSA_PROJECT: {
				DSAProject dsaProject = (DSAProject)theEObject;
				T result = caseDSAProject(dsaProject);
				if (result == null) result = caseProjectResource(dsaProject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case confPackage.EDITOR_PROJECT: {
				EditorProject editorProject = (EditorProject)theEObject;
				T result = caseEditorProject(editorProject);
				if (result == null) result = caseProjectResource(editorProject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case confPackage.DOMAIN_MODEL_PROJECT: {
				DomainModelProject domainModelProject = (DomainModelProject)theEObject;
				T result = caseDomainModelProject(domainModelProject);
				if (result == null) result = caseProjectResource(domainModelProject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case confPackage.MO_CC_PROJECT: {
				MoCCProject moCCProject = (MoCCProject)theEObject;
				T result = caseMoCCProject(moCCProject);
				if (result == null) result = caseProjectResource(moCCProject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case confPackage.ANIMATOR_PROJECT: {
				AnimatorProject animatorProject = (AnimatorProject)theEObject;
				T result = caseAnimatorProject(animatorProject);
				if (result == null) result = caseProjectResource(animatorProject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case confPackage.DSE_PROJECT: {
				DSEProject dseProject = (DSEProject)theEObject;
				T result = caseDSEProject(dseProject);
				if (result == null) result = caseProjectResource(dseProject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case confPackage.SIRIUS_EDITOR_PROJECT: {
				SiriusEditorProject siriusEditorProject = (SiriusEditorProject)theEObject;
				T result = caseSiriusEditorProject(siriusEditorProject);
				if (result == null) result = caseEditorProject(siriusEditorProject);
				if (result == null) result = caseProjectResource(siriusEditorProject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case confPackage.SIRIUS_ANIMATOR_PROJECT: {
				SiriusAnimatorProject siriusAnimatorProject = (SiriusAnimatorProject)theEObject;
				T result = caseSiriusAnimatorProject(siriusAnimatorProject);
				if (result == null) result = caseAnimatorProject(siriusAnimatorProject);
				if (result == null) result = caseProjectResource(siriusAnimatorProject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case confPackage.XTEXT_EDITOR_PROJECT: {
				XTextEditorProject xTextEditorProject = (XTextEditorProject)theEObject;
				T result = caseXTextEditorProject(xTextEditorProject);
				if (result == null) result = caseEditorProject(xTextEditorProject);
				if (result == null) result = caseProjectResource(xTextEditorProject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case confPackage.TREE_EDITOR_PROJECT: {
				TreeEditorProject treeEditorProject = (TreeEditorProject)theEObject;
				T result = caseTreeEditorProject(treeEditorProject);
				if (result == null) result = caseEditorProject(treeEditorProject);
				if (result == null) result = caseProjectResource(treeEditorProject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Project Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Project Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProjectResource(ProjectResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DSA Project</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DSA Project</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDSAProject(DSAProject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Language Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Language Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLanguageDefinition(LanguageDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Editor Project</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Editor Project</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEditorProject(EditorProject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Domain Model Project</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Domain Model Project</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDomainModelProject(DomainModelProject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mo CC Project</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mo CC Project</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMoCCProject(MoCCProject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Animator Project</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Animator Project</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnimatorProject(AnimatorProject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sirius Animator Project</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sirius Animator Project</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSiriusAnimatorProject(SiriusAnimatorProject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DSE Project</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DSE Project</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDSEProject(DSEProject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sirius Editor Project</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sirius Editor Project</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSiriusEditorProject(SiriusEditorProject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XText Editor Project</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XText Editor Project</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXTextEditorProject(XTextEditorProject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tree Editor Project</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tree Editor Project</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTreeEditorProject(TreeEditorProject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //confSwitch
