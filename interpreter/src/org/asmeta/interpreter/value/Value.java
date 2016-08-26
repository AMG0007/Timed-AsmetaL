/**
 * Value.java
 *
 * Created on 22/ago/06, 10:44:37
 *
 */
package org.asmeta.interpreter.value;


/**
 * The super class of all values.
 * The subclasses act as wrappers for the corresponding Java implementations.
 * 
 */
public abstract class Value {

	@Override
	public abstract Value clone();

}
