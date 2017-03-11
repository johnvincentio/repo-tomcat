
package com.hertz.herc.franchise.info;

import java.io.Serializable;

import com.hertz.herc.franchise.util.UtilHelper;

/**
 * Describe a Country RentalMan object.
 * 
 * @author John Vincent
 */
public class HercCountryRentalManItemInfo implements Serializable {
	private static final long serialVersionUID = -7826445196700273251L;

	private boolean rmCapable = false;				// true is rentalman capable
	private String rmCountryCode;					// Rentalman country code
	private String rmDataSource;					// Rentalman data source
	private String rmRatesDataSource;				// Rentalman rates data source
	private boolean rmContractLocations = false;	// true if rentalman supports contract locations
	private boolean payInvoices = false;			// true if can pay invoices through etrieve
	private String ratesLookupNSB;					// NSB String containing true if rates lookup is allowed
	private String etrieveCountryCode;				// Etrieve country code

	public boolean isRmCapable() {return rmCapable;}
	public String getRmCountryCode() {return rmCountryCode;}
	public String getRmDataSource() {return rmDataSource;}
	public String getRmRatesDataSource() {return rmRatesDataSource;}
	public boolean isRmContractLocations() {return rmContractLocations;}
	public boolean isPayInvoices() {return payInvoices;}
	public String getRatesLookupNSB() {return ratesLookupNSB;}
	public String getEtrieveCountryCode() {return etrieveCountryCode;}

	public boolean isRmRatesLookupCapable() {
		if (! isRmCapable()) return false;
		if (! UtilHelper.isSet (getRmRatesDataSource())) return false;
		if (! UtilHelper.isSet (getRatesLookupNSB())) return false;
		return true;
	}

	public void setRmCapable (boolean rmCapable) {this.rmCapable = rmCapable;}
	public void setRmCountryCode (String rmCountryCode) {this.rmCountryCode = rmCountryCode;}
	public void setRmDataSource (String rmDataSource) {this.rmDataSource = rmDataSource;}
	public void setRmRatesDataSource (String rmRatesDataSource) {this.rmRatesDataSource = rmRatesDataSource;}
	public void setRmContractLocations (boolean rmContractLocations) {this.rmContractLocations = rmContractLocations;}
	public void setPayInvoices (boolean payInvoices) {this.payInvoices = payInvoices;}
	public void setRatesLookupNSB (String ratesLookupNSB) {this.ratesLookupNSB = ratesLookupNSB;}
	public void setEtrieveCountryCode (String etrieveCountryCode) {this.etrieveCountryCode = etrieveCountryCode;}

	public String toString() {
		return "("+getRatesLookupNSB()+","+getEtrieveCountryCode()+","+getRmCountryCode()+","+
				getRmDataSource()+","+getRmRatesDataSource()+","+isRmContractLocations()+","+isPayInvoices()+","+
				isRmCapable()+")";
	}
}
