
package com.hertz.herc.franchise.info;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Describe a Country object.
 * 
 * @author John Vincent
 */

public class HercCountryItemInfo implements Serializable {
	private static final long serialVersionUID = -3465786771760850339L;
	private int code;								// example 1 = US, 2 = CA
	private boolean active = false;					// true is active
	private String twoDigitStringCode = "";			// example US
	private String twoDigitIntCode = "";			// example; 01 is US
	private boolean rouseSales = false;				// if true, use Rouse Sales Section. Otherwise, Sales section with only one page
	private boolean toolSupplySales = false;		// if true, S1.7 is active
	private boolean useMiles = false;				// if true use miles, else kilometers	
	private int catalogCountryCode;          		 // which country's catalog is being used,  example; 1 is US

	private boolean memberCapable = false;			// if true, member capable
	private boolean releaseCapable = false;			// if true, release capable
	private boolean extendCapable = false;			// if true, extend capable
	private boolean fleetCapable = false;			// if true, fleet capable
	private boolean overdueRentalsCapable = false;	// if true, can perform overdue rentals
	private boolean govProgramsCapable = false;		// if true, government programs capable
	private String branchPrefix = "";				// for example 8 = CA, 9 = US
	private String rouseCountryCode = "";			// rouse country code

	private boolean numericZipCode = false;			// true if zip/postal code is numeric

	private boolean overdueRentalsOption = false;	// true if use alternate branch

	private boolean helpCapable = false;             // true is help capable
	private HashMap<String, String> rouseCategories = new HashMap<String, String>();		// rouse categories
	private ArrayList<NameValuePair> subjectList = new ArrayList<NameValuePair>();			// subject list
	private CentralResItemInfo centralResItemInfo;	// central reservation information
	private HercCountryDialectsInfo hercCountryDialectsInfo;
	private boolean mapQuestEnabled = false;		// MapQuest data available
	private boolean bingMapsEnabled = false;		// Bing maps data available
	private boolean googleMapsEnabled = false;		// Google maps data available
	private boolean mobileEnabled = false;			// Mobile Enabled

	private HercCountryRentalManItemInfo hercCountryRentalManItemInfo = new HercCountryRentalManItemInfo();	// rentalman properties
	private ArrayList<NameValuePair> priceRangeList; // Price Range list

	public HercCountryItemInfo (int code) {this.code = code;}

	public int getCode() {return code;}
	public boolean isActive() {return active;}
	public String getTwoDigitStringCode() {return twoDigitStringCode;}
	public String getTwoDigitIntCode() {return twoDigitIntCode;}
	public boolean isRouseSales() {return rouseSales;}
	public boolean isToolSupplySales() {return toolSupplySales;}
	public boolean isUseMiles() {return useMiles;}
	public boolean isMemberCapable() {return memberCapable;}
	public int getCatalogCountryCode() {return catalogCountryCode;}

	public boolean isExtendCapable() {return extendCapable;}
	public boolean isFleetCapable() {return fleetCapable;}
	public boolean isReleaseCapable() {return releaseCapable;}
	public boolean isOverdueRentalsCapable() {return overdueRentalsCapable;}
	public boolean isGovProgramsCapable() {return govProgramsCapable;}
	
	public String getBranchPrefix() {return branchPrefix;}
	public String getRouseCountryCode() {return rouseCountryCode;}
	public boolean isNumericZipCode() {return numericZipCode;}
	public HashMap<String, String> getRouseCategories() {return rouseCategories;}
	public ArrayList<NameValuePair> getSubjectList() {return subjectList;}
	
	public boolean isOverdueRentalsOption() {return overdueRentalsOption;}
	public boolean isHelpCapable() {return helpCapable;}
	public CentralResItemInfo getCentralResItemInfo() {return centralResItemInfo;}
	
	public String getDefaultDialect() {return hercCountryDialectsInfo.getDefaultDialect();}
	public String[] getDialects() {return hercCountryDialectsInfo.getDialects();}

	public String getCountryText (String dialect) {return hercCountryDialectsInfo.getCountryText (dialect);}
	public String getCountryAbbreviation (String dialect) {return hercCountryDialectsInfo.getCountryAbbreviation (dialect);}

	public boolean isMapQuestEnabled() {return mapQuestEnabled;}
	public boolean isBingMapsEnabled() {return bingMapsEnabled;}
	public boolean isGoogleMapsEnabled() {return googleMapsEnabled;}	
	public boolean isMobileEnabled() {return mobileEnabled;}
	
	public ArrayList<NameValuePair> getPriceRangeList() {return priceRangeList;}
	public HercCountryRentalManItemInfo getHercCountryRentalManItemInfo() {return hercCountryRentalManItemInfo;}


	public void setActive (boolean active) {this.active = active;}
	public void setTwoDigitStringCode (String twoDigitStringCode) {this.twoDigitStringCode = twoDigitStringCode;}
	public void setTwoDigitIntCode (String twoDigitIntCode) {this.twoDigitIntCode = twoDigitIntCode;}
	public void setRouseSales (boolean rouseSales) {this.rouseSales = rouseSales;}
	public void setToolSupplySales (boolean toolSupplySales) {this.toolSupplySales = toolSupplySales;}
	public void setUseMiles (boolean useMiles) {this.useMiles = useMiles;}
	public void setCatalogCountryCode(int catalogCountryCode) {this.catalogCountryCode = catalogCountryCode;}
	public void setMemberCapable (boolean memberCapable) {this.memberCapable = memberCapable;}
	public void setReleaseCapable (boolean releaseCapable) {this.releaseCapable = releaseCapable;}
	public void setExtendCapable (boolean extendCapable) {this.extendCapable = extendCapable;}
	public void setFleetCapable (boolean fleetCapable) {this.fleetCapable = fleetCapable;}
	public void setOverdueRentalsCapable (boolean overdueRentalsCapable) {this.overdueRentalsCapable = overdueRentalsCapable;}
	public void setGovProgramsCapable (boolean govProgramsCapable) {this.govProgramsCapable = govProgramsCapable;}
	public void setBranchPrefix (String branchPrefix) {this.branchPrefix = branchPrefix;}
	public void setRouseCountryCode (String rouseCountryCode) {this.rouseCountryCode = rouseCountryCode;}
	public void setNumericZipCode (boolean numericZipCode) {this.numericZipCode = numericZipCode;}
	public void setOverdueRentalsOption (boolean overdueRentalsOption) {this.overdueRentalsOption = overdueRentalsOption;}
	public void setHelpCapable (boolean helpCapable) {this.helpCapable = helpCapable;}
	public void setSubjectList (ArrayList<NameValuePair> subjectList) {this.subjectList = subjectList;}
	public void setRouseCategories (HashMap<String, String> rouseCategories) {this.rouseCategories = rouseCategories;}

	public void setCentralResItemInfo (CentralResItemInfo centralResItemInfo) {this.centralResItemInfo = centralResItemInfo;}
	public void setHercCountryDialectsInfo (HercCountryDialectsInfo hercCountryDialectsInfo) {this.hercCountryDialectsInfo = hercCountryDialectsInfo;}
	public void setMapQuestEnabled (boolean mapQuestEnabled) {this.mapQuestEnabled = mapQuestEnabled;}
	public void setBingMapsEnabled (boolean bingMapsEnabled) {this.bingMapsEnabled = bingMapsEnabled;}
	public void setGoogleMapsEnabled (boolean googleMapsEnabled) {this.googleMapsEnabled = googleMapsEnabled;}
	public void setMobileEnabled (boolean mobileEnabled) {this.mobileEnabled = mobileEnabled;}

	public void setPriceRangeList (ArrayList<NameValuePair> priceRangeList) {this.priceRangeList = priceRangeList;}
	public void setHercCountryRentalManItemInfo (HercCountryRentalManItemInfo hercCountryRentalManItemInfo) {this.hercCountryRentalManItemInfo = hercCountryRentalManItemInfo;}

	public String toString() {
		return "("+getCode()+","+isActive()+","+getTwoDigitStringCode()+","+getTwoDigitIntCode()+","+isRouseSales()+","+
				isToolSupplySales()+","+isUseMiles()+","+getCatalogCountryCode()+","+isMemberCapable()+	","+isReleaseCapable()+","+isExtendCapable()+","+isFleetCapable()+","+
				isOverdueRentalsCapable()+","+isGovProgramsCapable()+","+getBranchPrefix()+","+getRouseCountryCode()+","+
				isNumericZipCode()+","+getDefaultDialect()+","+isOverdueRentalsOption()+","+
				isHelpCapable()+","+getCentralResItemInfo()+","+isBingMapsEnabled()+","+isGoogleMapsEnabled()+","+isMapQuestEnabled()+","+
				isMobileEnabled()+","+hercCountryDialectsInfo+","+getHercCountryRentalManItemInfo()+")";
	}
}
