
package com.hertz.herc.franchise.info;

import java.io.Serializable;

import com.hertz.herc.franchise.util.HercCountryHelper;

public class PosItemInfo implements Serializable {
	private static final long serialVersionUID = -8491698402876201902L;

	private int countryCode;
	public PosItemInfo() {
		this.countryCode = HercCountryHelper.getDefaultCountryCode();
	}
	public PosItemInfo (String pos) {
		this.countryCode = HercCountryHelper.getCountryCodeFromTwoDigitCountryCode (pos);
	}
	public PosItemInfo (int countryCode) {
		this.countryCode = countryCode;
		if (! HercCountryHelper.isValidCountryCode (countryCode))
			this.countryCode = HercCountryHelper.getDefaultCountryCode();
	}

	public int getCountryCode() {return countryCode;}
	public String getPos() {return HercCountryHelper.getTwoDigitCountryCode (countryCode);}
	public String getCountryCodeString() {return HercCountryHelper.getTwoDigitIntCountryCode (countryCode);}

	public String toString() {return "("+getPos()+")";}
}
