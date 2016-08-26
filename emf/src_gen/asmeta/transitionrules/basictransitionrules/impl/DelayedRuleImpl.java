/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package asmeta.transitionrules.basictransitionrules.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import asmeta.terms.basicterms.Term;
import asmeta.transitionrules.basictransitionrules.BasictransitionrulesPackage;
import asmeta.transitionrules.basictransitionrules.DelayedRule;
import asmeta.transitionrules.basictransitionrules.Rule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditional Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link asmeta.transitionrules.basictransitionrules.impl.DelayedRuleImpl#getGuard <em>Guard</em>}</li>
 *   <li>{@link asmeta.transitionrules.basictransitionrules.impl.DelayedRuleImpl#getElseRule <em>Else Rule</em>}</li>
 *   <li>{@link asmeta.transitionrules.basictransitionrules.impl.DelayedRuleImpl#getThenRule <em>Then Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DelayedRuleImpl extends BasicRuleImpl implements DelayedRule {
	/**
	 * The cached value of the '{@link #getGuard() <em>Guard</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuard()
	 * @generated
	 * @ordered
	 */
	protected long guard;

	/**
	 * The cached value of the '{@link #getElseRule() <em>Else Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElseRule()
	 * @generated
	 * @ordered
	 */
	protected long min = 0;
	
	/**
	 * The cached value of the '{@link #getElseRule() <em>Else Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElseRule()
	 * @generated
	 * @ordered
	 */
	protected long delay;

	/**
	 * The cached value of the '{@link #getThenRule() <em>Then Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThenRule()
	 * @generated
	 * @ordered
	 */
	protected Rule thenRule;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DelayedRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BasictransitionrulesPackage.Literals.DELAYED_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getGuard() {
		return guard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long basicGetGuard() {
		return guard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGuard(long newGuard) {
		long oldGuard = guard;
		guard = newGuard;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BasictransitionrulesPackage.DELAYED_RULE__GUARD, oldGuard, guard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getMin() {
		return min;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long basicGetMin() {
		return min;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMin(long newMin) {
		long oldMin = min;
		min = newMin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BasictransitionrulesPackage.DELAYED_RULE__MIN, oldMin, min));
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getDelay() {
		return delay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long basicGetDelay() {
		return delay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDelay(long newDelay) {
		long oldDelay = delay;
		delay = newDelay;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BasictransitionrulesPackage.DELAYED_RULE__DELAY, oldDelay, delay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rule getThenRule() {
		return thenRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThenRule(Rule newThenRule, NotificationChain msgs) {
		Rule oldThenRule = thenRule;
		thenRule = newThenRule;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BasictransitionrulesPackage.DELAYED_RULE__THEN_RULE, oldThenRule, newThenRule);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThenRule(Rule newThenRule) {
		if (newThenRule != thenRule) {
			NotificationChain msgs = null;
			if (thenRule != null)
				msgs = ((InternalEObject)thenRule).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BasictransitionrulesPackage.DELAYED_RULE__THEN_RULE, null, msgs);
			if (newThenRule != null)
				msgs = ((InternalEObject)newThenRule).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BasictransitionrulesPackage.DELAYED_RULE__THEN_RULE, null, msgs);
			msgs = basicSetThenRule(newThenRule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BasictransitionrulesPackage.DELAYED_RULE__THEN_RULE, newThenRule, newThenRule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BasictransitionrulesPackage.DELAYED_RULE__THEN_RULE:
				return basicSetThenRule(null, msgs);
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
			case BasictransitionrulesPackage.DELAYED_RULE__GUARD:
				if (resolve) return getGuard();
				return basicGetGuard();
			case BasictransitionrulesPackage.DELAYED_RULE__MIN:
				return basicGetMin();
			case BasictransitionrulesPackage.DELAYED_RULE__THEN_RULE:
				return getThenRule();
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
			case BasictransitionrulesPackage.DELAYED_RULE__GUARD:
				setGuard((long)newValue);
				return;
			case BasictransitionrulesPackage.DELAYED_RULE__MIN:
				setMin((long)newValue);
				return;
			case BasictransitionrulesPackage.DELAYED_RULE__THEN_RULE:
				setThenRule((Rule)newValue);
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
			case BasictransitionrulesPackage.DELAYED_RULE__GUARD:
				setGuard(0);
				return;
			case BasictransitionrulesPackage.DELAYED_RULE__MIN:
				setMin(0);
				return;
			case BasictransitionrulesPackage.DELAYED_RULE__THEN_RULE:
				setThenRule((Rule)null);
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
			case BasictransitionrulesPackage.CONDITIONAL_RULE__GUARD:
				return guard != 0;
			case BasictransitionrulesPackage.DELAYED_RULE__MIN:
				return min != 0;
			case BasictransitionrulesPackage.DELAYED_RULE__THEN_RULE:
				return thenRule != null;
		}
		return super.eIsSet(featureID);
	}

} //ConditionalRuleImpl
