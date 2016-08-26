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

import java.util.Map;

/**
 * A map. 
 *
 */
public class MapValue extends Value {
	
	Map<Value,Value> map;
	
	/**
	 * Creates a map.
	 * 
	 * @param map a map
	 */
	public MapValue(Map<Value,Value> map){
		this.map = map;
	}
	
	/**
	 * Gets the value.
	 * 
	 * @return the value
	 */
	public Map<Value,Value> getValue() {
		return map;
	}

	//PA: 14 giugno 10
	@Override
	public Value clone() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
