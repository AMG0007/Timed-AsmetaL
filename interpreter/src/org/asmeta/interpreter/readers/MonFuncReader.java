/**
 * 
 */
package org.asmeta.interpreter.readers;

import org.asmeta.interpreter.Location;
import org.asmeta.interpreter.State;
import org.asmeta.interpreter.TermEvaluator;
import org.asmeta.interpreter.value.EnumValue;
import org.asmeta.interpreter.value.ReserveValue;
import org.asmeta.interpreter.value.SetValue;
import org.asmeta.interpreter.value.Value;
import org.asmeta.parser.util.ReflectiveVisitor;

import asmeta.definitions.domains.AbstractTd;
import asmeta.definitions.domains.ConcreteDomain;
import asmeta.definitions.domains.EnumElement;
import asmeta.definitions.domains.EnumTd;
import asmeta.structure.DomainDefinition;

/**
 * Questa classe astratta si interpone fra l'ambiente <i>Environment</i> e
 * l'utente leggendo la rappresentazione in formato stringa di una costante e
 * convertendola nell'oggetto <i>Value</i> approprito in base al dominio 
 * di appartenenza.
 * 
 * @see <i>InteractiveMFReader</i>, <i>FileMonFuncReader</i>
 * 
 */
public abstract class MonFuncReader extends ReflectiveVisitor {
	
	
	protected State state;
	
	/**
	 * Legge il contenuto di una location.
	 * @param location location da leggere
	 * @param state stato corrente (serve per effettuare alcuni controlli di
	 * consistenza sui valori letti)
	 * @return contenuto di <i>location</i>
	 */
	public final Value read(Location location, State state) {
		this.state = state;
		//System.out.println("location = " + location + " state = " + state.getMonLocsState());
		return readValue(location, state);
	}
	
	/**
	 * Legge il contenuto di una location.
	 * @param location location da leggere
	 * @param state stato corrente (serve per effettuare alcuni controlli di
	 * consistenza sui valori letti)
	 * @return contenuto di <i>location</i>
	 */
	public abstract Value readValue(Location location, State state);
		
	/**
	 * Controlla che un valore appartenga al dominio astratto associato.
	 * 
	 * @param domain dominio astratto
	 * @param value valore da controllare
	 * @return True se <i>value</i> appartiene a <i>domain</i>
	 */
	protected boolean checkAbstract(AbstractTd domain, ReserveValue value) {
		SetValue set = state.read(domain);
		return set.getValue().contains(value);
	}
	
	/**
	 * Controlla che un valore appartenga al dominio enumerativo associato.
	 * 
	 * @param domain dominio enumerativo
	 * @param value valore da controllare
	 * @return True se <i>value</i> appartiene a <i>domain</i>
	 */
	protected boolean checkEnum(EnumTd domain, EnumValue value) {
		for (Object	o : domain.getElement()) {
			EnumElement element = (EnumElement) o;
			if (element.getSymbol().equals(value.getValue())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Controlla che un valore appartenga al dominio concreto associato.
	 * 
	 * @param domain dominio concreto
	 * @param value valore da controllare
	 * @return True se <i>value</i> appartiene a <i>domain</i>
	 */
	protected boolean checkConcrete(ConcreteDomain domain, Value value) {
		DomainDefinition def = domain.getDefinition();
		if (def != null) {
			// NOTA: i parametri <i>environment</i> e <i>assignment</i> sono null 
			// poiche' una definizione di un dominio non contiene occorrenze di 
			// funzioni monitorate o di variabili libere
			TermEvaluator eval = new TermEvaluator(state, null, null);
			SetValue set = (SetValue) eval.visit(def.getBody());
			return set.getValue().contains(value);
		}
		return true;
	}

}
