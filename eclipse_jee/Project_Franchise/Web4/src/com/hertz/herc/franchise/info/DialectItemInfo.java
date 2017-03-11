
package com.hertz.herc.franchise.info;

import java.io.Serializable;
import java.util.Locale;

/**
 * @author John Vincent
 * 
 *         describe a dialect
 */

public class DialectItemInfo implements Serializable {

	private static final long serialVersionUID = 1131616308767386276L;
	public static String DEFAULT_DIALECT = "enUS";
	private Locale locale;

	public DialectItemInfo () {
		this (DEFAULT_DIALECT);
	}

	public DialectItemInfo (String dialect) {
		this (dialect.substring (0, 2), dialect.substring (2, 4));
	}

	public DialectItemInfo (String language, String country) {
//		LogBroker.debug (this, "DialectItemInfo:: constructor language :"+language+": country :"+country+":");
		locale = new Locale (language.toLowerCase (), country.toUpperCase ());
	}

	public String getLanguage () {
		return locale.getLanguage ();
	}

	public String getCountry () {
		return locale.getCountry ().toUpperCase ();
	}

	public String getDialect () {
		return getLanguage () + getCountry ();
	}

	public boolean isSame (DialectItemInfo dialectItemInfo) {
		if (dialectItemInfo == null) return false;
		if (getDialect ().equals (dialectItemInfo.getDialect ())) return true;
		return false;
	}

	public String toString () {
		return "(" + getDialect () + ")" + "(" + getLanguage () + "," + getCountry () + ")";
	}
}
