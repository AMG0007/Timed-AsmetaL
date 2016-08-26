/*******************************************************************************
 * Copyright (c) 2009 .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      - initial API and implementation
 ******************************************************************************/
package org.asmeta.interpreter.value;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * A bag of values.
 * 
 */
public class BagValue extends CollectionValue {
		
	/**
	 * The bag.
	 *  
	 */
	private List<Value> bag;
		
	/**
	 * Creates a bag.
	 * 
	 * @param list a list of values
	 */
	public BagValue(List<Value> list) {
		bag = list;
	}
	
	/**
     * Gets the bag's content.
     * 
     * @return the content
     */
	@Override
	public List<Value> getValue() {
		return bag;
	}
	
	@Override
	public int hashCode() {
		return bag.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof BagValue) {
			return bag.equals(((BagValue)o).getValue());
		}
		throw new IllegalArgumentException();
	}
		
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("<");
		String[] elements = new String[bag.size()];
		int i = 0;
		for (Value e : bag) {
			elements[i++] = e.toString();
		}
		Arrays.sort(elements);
		if (elements.length > 0) {
			s.append(elements[0]);
			for (i = 1; i < elements.length; i++) {
				s.append("," + elements[i]);
			}
		}
		s.append(">");
		return s.toString();
	}

	@Override
	public Iterator<Value> iterator() {
		return bag.iterator();
	}

	//PA: 14 giugno 10
	@Override
	public Value clone() {
		// TODO Auto-generated method stub
		return null;
	}

}
