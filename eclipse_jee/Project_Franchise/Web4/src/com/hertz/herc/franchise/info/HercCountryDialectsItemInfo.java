
package com.hertz.herc.franchise.info;

import java.io.Serializable;

/**
 *	Describe a HercCountryDialectsItemInfo
 *
 * @author John Vincent
 */
 
public class HercCountryDialectsItemInfo implements Serializable {
	private static final long serialVersionUID = -7873970153799212505L;

	private String dialect;
	private String countryText;
	private String countryAbbreviation;

	public HercCountryDialectsItemInfo (String dialect, String countryText, String countryAbbreviation) {
		this.dialect = dialect;
		this.countryText = countryText;
		this.countryAbbreviation = countryAbbreviation;
	}

	public String getDialect() {return dialect;}
	public String getCountryText() {return countryText;}
	public String getCountryAbbreviation() {return countryAbbreviation;}

	public String toString() {
		return "("+getDialect()+","+getCountryText()+","+getCountryAbbreviation()+")";
	}
}
