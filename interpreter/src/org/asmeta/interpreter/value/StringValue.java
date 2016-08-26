/**
 * 
 */
package org.asmeta.interpreter.value;

import asmeta.terms.furtherterms.StringTerm;

/**
 * A string value.
 *
 */
public class StringValue extends Value {
	
	private String value;

	/**
	 * Creates a string.
	 * 
	 * @param s a string
	 */
	public StringValue(String s) {
		//PA: bisogna decidere se mettere sempre le virgolette...
		if(s.startsWith("\"") && s.endsWith("\"")) {
			value = s;
		}
		else {
			value = "\"" + s + "\"";
		}
	}
	
	/**
	 * Creates a string.
	 * 
	 * @param term a string term
	 */
	public StringValue(StringTerm term) {
		value = term.getSymbol();
		//TODO: suggerimento di modifica.
		//con l'istruzione qui sopra value = term.getSymbol(); la stringa viene
		//ritornata tra virgolette.
		//Un possibile modo per eliminare le virgolette e' farlo direttamente
		//dal parser. La modifica al parser e' suggerito alla riga 3205
		//di ASMParser.jj.

		//con la seguente modifica le virgolette sono eliminate
		//value = term.getSymbol().substring(1, term.getSymbol().length() - 1);
	}

    /**
     * Gets the value.
     * 
     * @return the value
     */
	public String getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof StringValue) {
			return getValue().equals(((StringValue) o).getValue());
		}
		//PA 19/02/10
		else if (o instanceof UndefValue) {
        	return false;
        }
		throw new IllegalArgumentException();
	}
	
	@Override
	public String toString() {
		return value;
	}

	//PA: 14 giugno 10
	@Override
	public Value clone() {
		// TODO Auto-generated method stub
		return null;
	}

}
