/**
 * CollectionValue.java
 *
 * Created on 10/ago/06, 14:28:16
 *
 */
package org.asmeta.interpreter.value;


/**
 * A collection of values.
 * 
 */
public abstract class CollectionValue extends Value implements Iterable<Value> {
	
	public abstract Object getValue();
	
}
