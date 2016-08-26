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
package org.asmeta.interpreter.readers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Map.Entry;

import org.asmeta.interpreter.Location;
import org.asmeta.interpreter.State;
import org.asmeta.interpreter.UpdateSet;
import org.asmeta.interpreter.util.DomainPrinter;
import org.asmeta.interpreter.util.InputMismatchException;
import org.asmeta.interpreter.util.Parser;
import org.asmeta.interpreter.value.BooleanValue;
import org.asmeta.interpreter.value.EnumValue;
import org.asmeta.interpreter.value.IntegerValue;
import org.asmeta.interpreter.value.RealValue;
import org.asmeta.interpreter.value.ReserveValue;
import org.asmeta.interpreter.value.SequenceValue;
import org.asmeta.interpreter.value.SetValue;
import org.asmeta.interpreter.value.StringValue;
import org.asmeta.interpreter.value.TupleValue;
import org.asmeta.interpreter.value.UndefValue;
import org.asmeta.interpreter.value.Value;
import org.asmeta.parser.Defs;

import asmeta.definitions.Function;
import asmeta.definitions.domains.AbstractTd;
import asmeta.definitions.domains.BooleanDomain;
import asmeta.definitions.domains.ConcreteDomain;
import asmeta.definitions.domains.Domain;
import asmeta.definitions.domains.EnumTd;
import asmeta.definitions.domains.IntegerDomain;
import asmeta.definitions.domains.NaturalDomain;
import asmeta.definitions.domains.PowersetDomain;
import asmeta.definitions.domains.ProductDomain;
import asmeta.definitions.domains.RealDomain;
import asmeta.definitions.domains.SequenceDomain;
import asmeta.definitions.domains.StringDomain;
import asmeta.definitions.domains.UndefDomain;

/**
 * La classe legge e converte le rappresentazioni in formato stringa delle 
 * costanti acquisite da un input stream. La classe inoltre stampa alcuni
 * messaggi diagnostici per facilitare l'inserimento dei dati da parte 
 * dell'utente. 
 * 
 * @author Alessandro Carioni [acarioni@tele2.it]
 *
 */
public class InteractiveMFReader extends MonFuncReader {
	
	/**
	 * Keeps the association between a monitored location and the value.
	 */
	//Map<Location, Value> monOldMap = new HashMap<Location, Value>();

	
	
	/**
	 * Input stream
	 */
	private BufferedReader in;

	/**
	 * Output stream 
	 */
	private PrintStream out;
	
	private String line;
	private DomainPrinter domainPrinter;
	
	/**
	 * Costruisce un nuovo oggetto.
	 * 
	 * @param in input stream
	 * @param out output stream
	 */
	public InteractiveMFReader(InputStream in, PrintStream out) {
		this.out = out;
		this.in = new BufferedReader(new InputStreamReader(in));
		domainPrinter = new DomainPrinter();
	}
	
	@Override
	public Value readValue(Location location, State state) {
		Function func = location.getSignature();
		// get the old value of location if any
		// TODO
		out.println(
				"Insert a " + domainPrinter.visit(func.getCodomain()) + 
				" for " + location.toString() + ":");
		return visit(func.getCodomain());
	}
	
	// FIXME : to put into read Location
	public UpdateSet readAll(State state) {
		UpdateSet updates = new UpdateSet();
		for (Entry<Location, Value> entry : state) {
			Location loc = entry.getKey();
			Value value = entry.getValue();
			Function sig = loc.getSignature();
			if (Defs.isMonitored(sig) || Defs.isShared(sig)) {
				out.println(loc + " [" + value + "]?");
				readLine();
				if (!line.isEmpty()) {
					Value newValue = read(loc, state);
					updates.putUpdate(loc, newValue);
				}
			}
		}
		return updates;
	}
		
	/**
	 * Legge una linea di testo.
	 */
	private void readLine() {
		try {
			line = in.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Value visit(Domain domain) {
		return (Value) visit((Object) domain);
	}

	public IntegerValue visit(IntegerDomain domain) {
		IntegerValue value = null;
		for (;;) {
			try {
				readLine();
				value = new Parser(line).visit(domain);
			} catch (InputMismatchException e) {
				out.println(e.getMessage());
				continue;
			}
			break;
		}
		return value;
	}
			
	public IntegerValue visit(NaturalDomain domain) {
		return visit((IntegerDomain) domain);
	}
	
	public RealValue visit(RealDomain domain) {
		RealValue value = null;
		for (;;) {
			try {
				readLine();
				value = new Parser(line).visit(domain);
			} catch (InputMismatchException e) {
				out.println(e.getMessage());
				continue;
			}
			break;
		}
		return value;
	}
	
	public BooleanValue visit(BooleanDomain domain) {
		BooleanValue value = null;
		for (;;) {
			try {
				readLine();
				value = new Parser(line).visit(domain);
			} catch (InputMismatchException e) {
				out.println(e.getMessage());
				continue;
			}
			break;
		}
		return value;
	}
		
	public UndefValue visit(UndefDomain domain) {
		UndefValue value = null;
		out.println("Insert an undef constant:");
		for (;;) {
			try {
				readLine();
				value = new Parser(line).visit(domain);
			} catch (InputMismatchException e) {
				out.println(e.getMessage());
				continue;
			}
			break;
		}
		return value;
	}
	
	public StringValue visit(StringDomain domain) {
		StringValue value = null;
		for (;;) {
			try {
				readLine();
				value = new Parser(line).visit(domain);
			} catch (InputMismatchException e) {
				out.println(e.getMessage());
				continue;
			}
			break;
		}
		return value;
	}
		
	public TupleValue visit(ProductDomain domain) {
		TupleValue value = null;
		for (;;) {
			try {
				readLine();
				value = new Parser(line).visit(domain);
			} catch (InputMismatchException e) {
				out.println(e.getMessage());
				continue;
			}
			break;
		}
		return value;
	}

	public SetValue visit(PowersetDomain domain) {	
		SetValue value = null;
		out.println("Insert a set:");
		for (;;) {
			try {
				readLine();
				value = new Parser(line).visit(domain);
			} catch (InputMismatchException e) {
				out.println(e.getMessage());
				continue;
			}
			break;
		}
		return value;
	}

	public SequenceValue visit(SequenceDomain domain) {
		SequenceValue value = null;
		for (;;) {
			try {
				readLine();
				value = new Parser(line).visit(domain);
			} catch (InputMismatchException e) {
				out.println(e.getMessage());
				continue;
			}
			break;
		}
		return value;
	}

	public ReserveValue visit(AbstractTd domain) {
		ReserveValue value = null;
		for (;;) {
			try {
				readLine();
				value = new Parser(line).visit(domain);
			} catch (InputMismatchException e) {
				out.println(e.getMessage());
				continue;
			}
			if (!checkAbstract(domain, value)) {
				out.println(
						"The costant " + value.getValue() + 
						" doesn't belong to abstract domain " + domain.getName());
				continue;
			}
			break;
		}
		return value;
	}
	
	public EnumValue visit(EnumTd domain) {
		EnumValue value = null;
		for (;;) {
			try {
				readLine();
				value = new Parser(line).visit(domain);
			} catch (InputMismatchException e) {
				out.println(e.getMessage());
				continue;
			}
			if (!checkEnum(domain, value)) {
				out.println(
						"The costant " + value.getValue() + 
						" doesn't belong to enum domain " + domain.getName());
				continue;
			}
			break;
		}
		return value;
	}
		
	public Value visit(ConcreteDomain domain) {
		Value value = null;
		for (;;) {
			try {
				readLine();
				value = new Parser(line).visit(domain);
			} catch (InputMismatchException e) {
				out.println(e.getMessage());
				continue;
			}
			if (!checkConcrete(domain, value)) {
				out.println(
						"The costant " + value + 
						" doesn't belong to concrete domain " + domain.getName());
				continue;
			}
			break;
		}
		return value;
	}

}
