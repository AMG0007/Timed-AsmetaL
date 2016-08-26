/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package asmeta.transitionrules.basictransitionrules;

import asmeta.terms.basicterms.Term;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conditional Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link asmeta.transitionrules.basictransitionrules.DelayedRule#getGuard <em>Guard</em>}</li>
 *   <li>{@link asmeta.transitionrules.basictransitionrules.DelayedRule#getElseRule <em>Else Rule</em>}</li>
 *   <li>{@link asmeta.transitionrules.basictransitionrules.DelayedRule#getThenRule <em>Then Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @see asmeta.transitionrules.basictransitionrules.BasictransitionrulesPackage#getConditionalRule()
 * @model
 * @generated
 */
public interface DelayedRule extends BasicRule {
	/**
	 * Returns the value of the '<em><b>Guard</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guard</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guard</em>' reference.
	 * @see #setGuard(Term)
	 * @see asmeta.transitionrules.basictransitionrules.BasictransitionrulesPackage#getConditionalRule_Guard()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	long getGuard();

	/**
	 * Sets the value of the '{@link asmeta.transitionrules.basictransitionrules.DelayedRule#getGuard <em>Guard</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guard</em>' reference.
	 * @see #getGuard()
	 * @generated
	 */
	void setGuard(long value);

	long getMin();
	
	void setMin(long value);
	
	long getDelay();
	
	void setDelay(long value);
	
	Rule getThenRule();

	/**
	 * Sets the value of the '{@link asmeta.transitionrules.basictransitionrules.DelayedRule#getThenRule <em>Then Rule</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Then Rule</em>' containment reference.
	 * @see #getThenRule()
	 * @generated
	 */
	void setThenRule(Rule value);

} // ConditionalRule
