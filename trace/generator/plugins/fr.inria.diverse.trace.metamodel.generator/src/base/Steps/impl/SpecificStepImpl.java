/**
 */
package base.Steps.impl;

import base.States.SpecificState;
import base.States.StatesPackage;

import base.Steps.SpecificStep;
import base.Steps.StepsPackage;

import fr.inria.diverse.trace.commons.model.trace.impl.StepImpl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specific Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link base.Steps.impl.SpecificStepImpl#getStartingStateRef <em>Starting State Ref</em>}</li>
 *   <li>{@link base.Steps.impl.SpecificStepImpl#getEndingStateRef <em>Ending State Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class SpecificStepImpl extends StepImpl<SpecificState> implements SpecificStep {
	/**
	 * The cached value of the '{@link #getStartingStateRef() <em>Starting State Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartingStateRef()
	 * @generated
	 * @ordered
	 */
	protected SpecificState startingStateRef;

	/**
	 * The cached value of the '{@link #getEndingStateRef() <em>Ending State Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndingStateRef()
	 * @generated
	 * @ordered
	 */
	protected SpecificState endingStateRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpecificStepImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StepsPackage.Literals.SPECIFIC_STEP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific type known in this context.
	 * @generated
	 */
	@Override
	public void setStartingState(SpecificState newStartingState) {
		super.setStartingState(newStartingState);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific type known in this context.
	 * @generated
	 */
	@Override
	public void setEndingState(SpecificState newEndingState) {
		super.setEndingState(newEndingState);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecificState getStartingStateRef() {
		if (startingStateRef != null && startingStateRef.eIsProxy()) {
			InternalEObject oldStartingStateRef = (InternalEObject)startingStateRef;
			startingStateRef = (SpecificState)eResolveProxy(oldStartingStateRef);
			if (startingStateRef != oldStartingStateRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StepsPackage.SPECIFIC_STEP__STARTING_STATE_REF, oldStartingStateRef, startingStateRef));
			}
		}
		return startingStateRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecificState basicGetStartingStateRef() {
		return startingStateRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStartingStateRef(SpecificState newStartingStateRef, NotificationChain msgs) {
		SpecificState oldStartingStateRef = startingStateRef;
		startingStateRef = newStartingStateRef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StepsPackage.SPECIFIC_STEP__STARTING_STATE_REF, oldStartingStateRef, newStartingStateRef);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartingStateRef(SpecificState newStartingStateRef) {
		if (newStartingStateRef != startingStateRef) {
			NotificationChain msgs = null;
			if (startingStateRef != null)
				msgs = ((InternalEObject)startingStateRef).eInverseRemove(this, StatesPackage.SPECIFIC_STATE__STARTED_STEPS_REF, SpecificState.class, msgs);
			if (newStartingStateRef != null)
				msgs = ((InternalEObject)newStartingStateRef).eInverseAdd(this, StatesPackage.SPECIFIC_STATE__STARTED_STEPS_REF, SpecificState.class, msgs);
			msgs = basicSetStartingStateRef(newStartingStateRef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StepsPackage.SPECIFIC_STEP__STARTING_STATE_REF, newStartingStateRef, newStartingStateRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecificState getEndingStateRef() {
		if (endingStateRef != null && endingStateRef.eIsProxy()) {
			InternalEObject oldEndingStateRef = (InternalEObject)endingStateRef;
			endingStateRef = (SpecificState)eResolveProxy(oldEndingStateRef);
			if (endingStateRef != oldEndingStateRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StepsPackage.SPECIFIC_STEP__ENDING_STATE_REF, oldEndingStateRef, endingStateRef));
			}
		}
		return endingStateRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecificState basicGetEndingStateRef() {
		return endingStateRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEndingStateRef(SpecificState newEndingStateRef, NotificationChain msgs) {
		SpecificState oldEndingStateRef = endingStateRef;
		endingStateRef = newEndingStateRef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StepsPackage.SPECIFIC_STEP__ENDING_STATE_REF, oldEndingStateRef, newEndingStateRef);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndingStateRef(SpecificState newEndingStateRef) {
		if (newEndingStateRef != endingStateRef) {
			NotificationChain msgs = null;
			if (endingStateRef != null)
				msgs = ((InternalEObject)endingStateRef).eInverseRemove(this, StatesPackage.SPECIFIC_STATE__ENDED_STEPS_REF, SpecificState.class, msgs);
			if (newEndingStateRef != null)
				msgs = ((InternalEObject)newEndingStateRef).eInverseAdd(this, StatesPackage.SPECIFIC_STATE__ENDED_STEPS_REF, SpecificState.class, msgs);
			msgs = basicSetEndingStateRef(newEndingStateRef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StepsPackage.SPECIFIC_STEP__ENDING_STATE_REF, newEndingStateRef, newEndingStateRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecificState getStartingState() {
		return getStartingStateRef();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecificState getEndingState() {
		return getEndingStateRef();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecificState basicGetStartingState() {
		return basicGetStartingStateRef();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecificState basicGetEndingState() {
		return basicGetEndingStateRef();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StepsPackage.SPECIFIC_STEP__STARTING_STATE_REF:
				if (startingStateRef != null)
					msgs = ((InternalEObject)startingStateRef).eInverseRemove(this, StatesPackage.SPECIFIC_STATE__STARTED_STEPS_REF, SpecificState.class, msgs);
				return basicSetStartingStateRef((SpecificState)otherEnd, msgs);
			case StepsPackage.SPECIFIC_STEP__ENDING_STATE_REF:
				if (endingStateRef != null)
					msgs = ((InternalEObject)endingStateRef).eInverseRemove(this, StatesPackage.SPECIFIC_STATE__ENDED_STEPS_REF, SpecificState.class, msgs);
				return basicSetEndingStateRef((SpecificState)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StepsPackage.SPECIFIC_STEP__STARTING_STATE_REF:
				return basicSetStartingStateRef(null, msgs);
			case StepsPackage.SPECIFIC_STEP__ENDING_STATE_REF:
				return basicSetEndingStateRef(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StepsPackage.SPECIFIC_STEP__STARTING_STATE_REF:
				if (resolve) return getStartingStateRef();
				return basicGetStartingStateRef();
			case StepsPackage.SPECIFIC_STEP__ENDING_STATE_REF:
				if (resolve) return getEndingStateRef();
				return basicGetEndingStateRef();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StepsPackage.SPECIFIC_STEP__STARTING_STATE_REF:
				setStartingStateRef((SpecificState)newValue);
				return;
			case StepsPackage.SPECIFIC_STEP__ENDING_STATE_REF:
				setEndingStateRef((SpecificState)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case StepsPackage.SPECIFIC_STEP__STARTING_STATE_REF:
				setStartingStateRef((SpecificState)null);
				return;
			case StepsPackage.SPECIFIC_STEP__ENDING_STATE_REF:
				setEndingStateRef((SpecificState)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StepsPackage.SPECIFIC_STEP__STARTING_STATE_REF:
				return startingStateRef != null;
			case StepsPackage.SPECIFIC_STEP__ENDING_STATE_REF:
				return endingStateRef != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case StepsPackage.SPECIFIC_STEP___GET_STARTING_STATE:
				return getStartingState();
			case StepsPackage.SPECIFIC_STEP___GET_ENDING_STATE:
				return getEndingState();
			case StepsPackage.SPECIFIC_STEP___BASIC_GET_STARTING_STATE:
				return basicGetStartingState();
			case StepsPackage.SPECIFIC_STEP___BASIC_GET_ENDING_STATE:
				return basicGetEndingState();
		}
		return super.eInvoke(operationID, arguments);
	}

} //SpecificStepImpl
