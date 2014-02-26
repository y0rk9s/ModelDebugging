/**
 * Copyright (c) 2012-2016 GEMOC consortium.
 * 
 * http://www.gemoc.org
 * 
 * Contributors:
 *   Stephen Creff - ENSTA Bretagne [stephen.creff@ensta-bretagne.fr]
 *   
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * $Id$
 */
package org.gemoc.mocc.cometafsm.model.cometafsm;


import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Machine Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.gemoc.mocc.cometafsm.model.cometafsm.StateMachineDefinition#getDeclarationBlock <em>Declaration Block</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometafsm.model.cometafsm.StateMachineDefinition#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometafsm.model.cometafsm.StateMachineDefinition#getStates <em>States</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometafsm.model.cometafsm.StateMachineDefinition#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link org.gemoc.mocc.cometafsm.model.cometafsm.StateMachineDefinition#getFinalStates <em>Final States</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.gemoc.mocc.cometafsm.model.cometafsm.CometafsmPackage#getStateMachineDefinition()
 * @model
 * @generated
 */
public interface StateMachineDefinition extends CometaElement {
	/**
	 * Returns the value of the '<em><b>Declaration Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declaration Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declaration Block</em>' containment reference.
	 * @see #setDeclarationBlock(DeclarationBlock)
	 * @see org.gemoc.mocc.cometafsm.model.cometafsm.CometafsmPackage#getStateMachineDefinition_DeclarationBlock()
	 * @model containment="true"
	 * @generated
	 */
	DeclarationBlock getDeclarationBlock();

	/**
	 * Sets the value of the '{@link org.gemoc.mocc.cometafsm.model.cometafsm.StateMachineDefinition#getDeclarationBlock <em>Declaration Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declaration Block</em>' containment reference.
	 * @see #getDeclarationBlock()
	 * @generated
	 */
	void setDeclarationBlock(DeclarationBlock value);

	/**
	 * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometafsm.model.cometafsm.Transition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' containment reference list.
	 * @see org.gemoc.mocc.cometafsm.model.cometafsm.CometafsmPackage#getStateMachineDefinition_Transitions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Transition> getTransitions();

	/**
	 * Returns the value of the '<em><b>States</b></em>' containment reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometafsm.model.cometafsm.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' containment reference list.
	 * @see org.gemoc.mocc.cometafsm.model.cometafsm.CometafsmPackage#getStateMachineDefinition_States()
	 * @model containment="true"
	 * @generated
	 */
	EList<State> getStates();

	/**
	 * Returns the value of the '<em><b>Initial State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial State</em>' reference.
	 * @see #setInitialState(State)
	 * @see org.gemoc.mocc.cometafsm.model.cometafsm.CometafsmPackage#getStateMachineDefinition_InitialState()
	 * @model required="true"
	 * @generated
	 */
	State getInitialState();

	/**
	 * Sets the value of the '{@link org.gemoc.mocc.cometafsm.model.cometafsm.StateMachineDefinition#getInitialState <em>Initial State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial State</em>' reference.
	 * @see #getInitialState()
	 * @generated
	 */
	void setInitialState(State value);

	/**
	 * Returns the value of the '<em><b>Final States</b></em>' reference list.
	 * The list contents are of type {@link org.gemoc.mocc.cometafsm.model.cometafsm.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Final States</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Final States</em>' reference list.
	 * @see org.gemoc.mocc.cometafsm.model.cometafsm.CometafsmPackage#getStateMachineDefinition_FinalStates()
	 * @model
	 * @generated
	 */
	EList<State> getFinalStates();

} // StateMachineDefinition
