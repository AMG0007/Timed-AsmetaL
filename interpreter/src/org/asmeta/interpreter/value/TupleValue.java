/**
 * 
 */
package org.asmeta.interpreter.value;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * A tuple value.
 * 
 */
public class TupleValue extends CollectionValue {

	private Value[] values;

	/**
	 * Creates a tuple.
	 * 
	 * @param list a list of values
	 */
	public TupleValue(List<Value> list) {
		values = list.toArray(new Value[0]);
	}

	/**
	 * Creates a tuple.
	 * 
	 * @param values values
	 */
	public TupleValue(Value... values) {
		this(Arrays.asList(values));
	}

	/**
	 * Gets the value. 
	 * 
	 * @return the value
	 */
	@Override
	public Value[] getValue() {
		return values;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("(");
		int i = 0;
		s.append(values[i++]);
		while (i < values.length) {
			s.append("," + values[i++]);
		}
		s.append(")");
		return s.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof TupleValue))
			return false;
		TupleValue another = (TupleValue) o;
		if (this.values.length != another.values.length)
			return false;
		for (int j = 0; j < values.length; j++) {
			if (!values[j].equals(another.values[j]))
				return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = Arrays.hashCode(values);
		return hash;
	}

	@Override
	public Iterator<Value> iterator() {
		return Arrays.asList(values).iterator();
	}

	//PA: 14 giugno 10
	@Override
	public Value clone() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
