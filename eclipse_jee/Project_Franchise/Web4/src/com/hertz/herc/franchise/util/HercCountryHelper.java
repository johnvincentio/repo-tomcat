
package com.hertz.herc.franchise.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.hertz.herc.franchise.info.CentralResItemInfo;
import com.hertz.herc.franchise.info.DialectItemInfo;
import com.hertz.herc.franchise.info.HercCountryDialectsInfo;
import com.hertz.herc.franchise.info.HercCountryDialectsItemInfo;
import com.hertz.herc.franchise.info.HercCountryItemInfo;
import com.hertz.herc.franchise.info.HercCountryRentalManItemInfo;
import com.hertz.herc.franchise.info.NameValuePair;
import com.hertz.herc.franchise.info.PosItemInfo;

/**
 * Handle Country related tasks for Herc
 * 
 * @author John Vincent
 */
public class HercCountryHelper {

	private static ArrayList<HercCountryItemInfo> m_collection = new ArrayList<HercCountryItemInfo>();
	public static Iterator<HercCountryItemInfo> getItems() {return m_collection.iterator();}

	private static final String HERC_DEMODATA_DATASOURCE_SQL = "jdbc/com/hertz/irac/HercDemoDataDB";

	/**
	 * Initialise country data dictionary
	 */
	static {
		m_collection = new ArrayList<HercCountryItemInfo>();

		{
			HashMap<String, String> rouseCategoriesMap = new HashMap<String, String>();
			rouseCategoriesMap.put("Aerial Equipment", "31");
			rouseCategoriesMap.put("Air Equipment", "32");
			rouseCategoriesMap.put("Compaction & Paving Equipment", "33");
			rouseCategoriesMap.put("Concrete & Masonry Equipment", "34");
			rouseCategoriesMap.put("Earthmoving Equipment", "35");
			rouseCategoriesMap.put("Electrical Tools & Equipment", "36");
			rouseCategoriesMap.put("General Equipment", "37");
			rouseCategoriesMap.put("Lawn & Garden Equipment", "38");
			rouseCategoriesMap.put("Material Handling Equipment", "39");
			rouseCategoriesMap.put("Pumping Equipment", "40");
			rouseCategoriesMap.put("Safety Equipment", "41");
			rouseCategoriesMap.put("Trucks & Trailers", "43");

			ArrayList<NameValuePair> subjectList = new ArrayList<NameValuePair>();
			subjectList.add(new NameValuePair("Customer Feedback", "3"));
			subjectList.add(new NameValuePair("Customer Programs", "1"));
			subjectList.add(new NameValuePair("Equipment Rental Inquiry", "7"));
			subjectList.add(new NameValuePair("Equipment Sales Inquiry", "6"));
			subjectList.add(new NameValuePair("Export Sales Inquiry", "4"));
			subjectList.add(new NameValuePair("Franchise Opportunities", "28"));
			subjectList.add(new NameValuePair("General Questions", "8"));
			subjectList.add(new NameValuePair("Hertz Entertainment Services", "27"));
			subjectList.add(new NameValuePair("Service Pump & Compressor Inquiry", "19"));
			// subjectList.add(new NameValuePair("Tool & Supply Sales", "24")); Jira 1890 3/19/2014
			subjectList.add(new NameValuePair("Training and Safety", "16"));
			subjectList.add(new NameValuePair("US Communities Inquiry", "26"));
			subjectList.add(new NameValuePair("Affiliate Program", "29"));
			subjectList.add(new NameValuePair("Online Account Inquiry", "13"));
			subjectList.add(new NameValuePair("National Account Program", "12"));

			HercCountryDialectsInfo hercCountryDialectsInfo = new HercCountryDialectsInfo();
			hercCountryDialectsInfo.add (new HercCountryDialectsItemInfo ("enUS", "United States", "USA"));

			CentralResItemInfo centralResItemInfo = new CentralResItemInfo ("1-888-777-2700", "Centralres@hertz.com", "hercsales@hertz.com");

			ArrayList<NameValuePair> priceRangeList = new ArrayList<NameValuePair>();
			priceRangeList.add(new NameValuePair("0-999 USD", "1"));
			priceRangeList.add(new NameValuePair("1,000-4,999 USD", "2"));
			priceRangeList.add(new NameValuePair("5,000-9,999 USD", "3"));
			priceRangeList.add(new NameValuePair("10,000-24,999 USD", "4"));
			priceRangeList.add(new NameValuePair("25,000-49,999 USD", "5"));
			priceRangeList.add(new NameValuePair("Greater Than 50,000 USD", "6"));

			HercCountryRentalManItemInfo hercCountryRentalManItemInfo = new HercCountryRentalManItemInfo();
			hercCountryRentalManItemInfo.setRmCapable (true);
			hercCountryRentalManItemInfo.setRmCountryCode ("HG");
			hercCountryRentalManItemInfo.setRmDataSource ("jdbc/com/hertz/herc/RentalmanSQL");
			hercCountryRentalManItemInfo.setRmRatesDataSource ("jdbc/com/hertz/herc/RentalmanSP");
			hercCountryRentalManItemInfo.setRmContractLocations (true);
			hercCountryRentalManItemInfo.setPayInvoices (true);
			hercCountryRentalManItemInfo.setRatesLookupNSB ("string/com/hertz/herc/CountryCodeUS");
			hercCountryRentalManItemInfo.setEtrieveCountryCode ("USA");

			HercCountryItemInfo hercCountryItemInfo = new HercCountryItemInfo (1);
			hercCountryItemInfo.setActive (true);
			hercCountryItemInfo.setTwoDigitStringCode ("US");
			hercCountryItemInfo.setTwoDigitIntCode ("01");
			hercCountryItemInfo.setSubjectList (subjectList);
			hercCountryItemInfo.setRouseCategories (rouseCategoriesMap);
			hercCountryItemInfo.setCentralResItemInfo (centralResItemInfo);
			hercCountryItemInfo.setHercCountryDialectsInfo (hercCountryDialectsInfo);
			hercCountryItemInfo.setPriceRangeList (priceRangeList);
			hercCountryItemInfo.setOverdueRentalsOption (true);
			hercCountryItemInfo.setRouseSales (true);
			hercCountryItemInfo.setToolSupplySales (false);
			hercCountryItemInfo.setUseMiles (true);		
			hercCountryItemInfo.setMemberCapable (true);
			hercCountryItemInfo.setReleaseCapable (true);
			hercCountryItemInfo.setExtendCapable (true);
			hercCountryItemInfo.setFleetCapable (true);
			hercCountryItemInfo.setOverdueRentalsCapable (true);
			hercCountryItemInfo.setGovProgramsCapable (true);
			hercCountryItemInfo.setBranchPrefix ("9");
			hercCountryItemInfo.setRouseCountryCode ("us");
			hercCountryItemInfo.setNumericZipCode (true);
			hercCountryItemInfo.setHelpCapable (true);
			hercCountryItemInfo.setMapQuestEnabled (true);
			hercCountryItemInfo.setBingMapsEnabled (true);
			hercCountryItemInfo.setGoogleMapsEnabled (true);
			hercCountryItemInfo.setMobileEnabled (true);
			hercCountryItemInfo.setHercCountryRentalManItemInfo (hercCountryRentalManItemInfo);
			m_collection.add (hercCountryItemInfo);
		}

		{
			HashMap<String, String> rouseCategoriesMap = new HashMap<String, String>();
			rouseCategoriesMap = new HashMap<String, String>();
			rouseCategoriesMap.put("Aerial Equipment", "44");
			rouseCategoriesMap.put("Air Equipment", "45");
			rouseCategoriesMap.put("Compaction & Paving Equipment", "46");
			rouseCategoriesMap.put("Concrete & Masonry Equipment", "47");
			rouseCategoriesMap.put("Earthmoving Equipment", "48");
			rouseCategoriesMap.put("Electrical Tools & Equipment", "49");
			rouseCategoriesMap.put("General Equipment", "50");
			rouseCategoriesMap.put("Lawn & Garden Equipment", "51");
			rouseCategoriesMap.put("Material Handling Equipment", "52");
			rouseCategoriesMap.put("Pumping Equipment", "53");
			rouseCategoriesMap.put("Safety Equipment", "54");
			rouseCategoriesMap.put("Trucks & Trailers", "56");

			ArrayList<NameValuePair> subjectList = new ArrayList<NameValuePair>();
			subjectList.add(new NameValuePair("Customer Feedback", "3"));
			subjectList.add(new NameValuePair("Customer Programs", "1"));
			subjectList.add(new NameValuePair("Equipment Rental Inquiry", "7"));
			subjectList.add(new NameValuePair("Equipment Sales Inquiry", "6"));
			subjectList.add(new NameValuePair("Export Sales Inquiry", "4"));
			subjectList.add(new NameValuePair("Franchise Opportunities", "28"));
			subjectList.add(new NameValuePair("General Questions", "8"));
			subjectList.add(new NameValuePair("Hertz Entertainment Services", "27"));
			subjectList.add(new NameValuePair("Service Pump & Compressor Inquiry", "19"));
			// subjectList.add(new NameValuePair("Tool & Supply Sales", "24")); Jira 1890 3/19/2014
			subjectList.add(new NameValuePair("Training and Safety", "16"));
			subjectList.add(new NameValuePair("US Communities Inquiry", "26"));
			subjectList.add(new NameValuePair("Affiliate Program", "29"));
			subjectList.add(new NameValuePair("Online Account Inquiry", "13"));
			subjectList.add(new NameValuePair("National Account Program", "12"));

			HercCountryDialectsInfo hercCountryDialectsInfo = new HercCountryDialectsInfo();
			hercCountryDialectsInfo.add (new HercCountryDialectsItemInfo ("enUS", "Canada", "CA"));

			CentralResItemInfo centralResItemInfo = new CentralResItemInfo ("1-888-777-2700", "Centralres@hertz.com", "hercsales@hertz.com");

			ArrayList<NameValuePair> priceRangeList = new ArrayList<NameValuePair>();
			priceRangeList.add(new NameValuePair("0-999 CAD", "1"));
			priceRangeList.add(new NameValuePair("1,000-4,999 CAD", "2"));
			priceRangeList.add(new NameValuePair("5,000-9,999 CAD", "3"));
			priceRangeList.add(new NameValuePair("10,000-24,999 CAD", "4"));
			priceRangeList.add(new NameValuePair("25,000-49,999 CAD", "5"));
			priceRangeList.add(new NameValuePair("Greater Than 50,000 CAD", "6"));

			HercCountryRentalManItemInfo hercCountryRentalManItemInfo = new HercCountryRentalManItemInfo();
			hercCountryRentalManItemInfo.setRmCapable (true);
			hercCountryRentalManItemInfo.setRmCountryCode ("CR");
			hercCountryRentalManItemInfo.setRmDataSource ("jdbc/com/hertz/herc/CARentalmanSQL");
			hercCountryRentalManItemInfo.setRmRatesDataSource ("jdbc/com/hertz/herc/CARentalmanSP");
			hercCountryRentalManItemInfo.setRmContractLocations (false);
			hercCountryRentalManItemInfo.setPayInvoices (false);
			hercCountryRentalManItemInfo.setRatesLookupNSB ("string/com/hertz/herc/CountryCodeCA");
			hercCountryRentalManItemInfo.setEtrieveCountryCode ("CAN");

			HercCountryItemInfo hercCountryItemInfo = new HercCountryItemInfo (2);
			hercCountryItemInfo.setActive (true);
			hercCountryItemInfo.setTwoDigitStringCode ("CA");
			hercCountryItemInfo.setTwoDigitIntCode ("02");
			hercCountryItemInfo.setSubjectList (subjectList);
			hercCountryItemInfo.setRouseCategories (rouseCategoriesMap);
			hercCountryItemInfo.setCentralResItemInfo (centralResItemInfo);
			hercCountryItemInfo.setHercCountryDialectsInfo (hercCountryDialectsInfo);
			hercCountryItemInfo.setPriceRangeList (priceRangeList);
			hercCountryItemInfo.setRouseSales (true);		
			hercCountryItemInfo.setMemberCapable (true);
			hercCountryItemInfo.setReleaseCapable (true);
			hercCountryItemInfo.setExtendCapable (true);
			hercCountryItemInfo.setFleetCapable (true);
			hercCountryItemInfo.setOverdueRentalsCapable (true);
			hercCountryItemInfo.setBranchPrefix ("8");
			hercCountryItemInfo.setRouseCountryCode ("cn");
			hercCountryItemInfo.setOverdueRentalsOption (true);
			hercCountryItemInfo.setHelpCapable (true);
			hercCountryItemInfo.setMapQuestEnabled (true);
			hercCountryItemInfo.setBingMapsEnabled (true);
			hercCountryItemInfo.setGoogleMapsEnabled (true);
			hercCountryItemInfo.setMobileEnabled (true);
			hercCountryItemInfo.setHercCountryRentalManItemInfo (hercCountryRentalManItemInfo);
			m_collection.add (hercCountryItemInfo);
		}

		{
			HercCountryDialectsInfo hercCountryDialectsInfo = new HercCountryDialectsInfo();
			hercCountryDialectsInfo.add(new HercCountryDialectsItemInfo ("enUS", "China", "CN"));

			CentralResItemInfo centralResItemInfo = new CentralResItemInfo ("1-888-777-2700", "Centralres@hertz.com", "hercsales@hertz.com");

			HercCountryItemInfo hercCountryItemInfo = new HercCountryItemInfo (3);
			hercCountryItemInfo.setActive (false);
			hercCountryItemInfo.setTwoDigitStringCode ("CN");
			hercCountryItemInfo.setTwoDigitIntCode ("03");
			hercCountryItemInfo.setCentralResItemInfo (centralResItemInfo);
			hercCountryItemInfo.setHercCountryDialectsInfo (hercCountryDialectsInfo);
			hercCountryItemInfo.setCatalogCountryCode(1);
			hercCountryItemInfo.setBranchPrefix ("3");
			hercCountryItemInfo.setGoogleMapsEnabled (true);
			m_collection.add (hercCountryItemInfo);
		}

		{
			ArrayList<NameValuePair> subjectList = new ArrayList<NameValuePair>();
			subjectList.add(new NameValuePair("Customer Feedback", "3"));
			subjectList.add(new NameValuePair("Customer Programs", "1"));
			subjectList.add(new NameValuePair("Equipment Rental Inquiry", "7"));
			subjectList.add(new NameValuePair("Equipment Sales Inquiry", "6"));
			subjectList.add(new NameValuePair("Export Sales Inquiry", "4"));
			subjectList.add(new NameValuePair("Franchise Opportunities", "28"));
			subjectList.add(new NameValuePair("General Questions", "8"));
			subjectList.add(new NameValuePair("Hertz Entertainment Services", "27"));
			subjectList.add(new NameValuePair("Service Pump & Compressor Inquiry", "19"));
			// subjectList.add(new NameValuePair("Tool & Supply Sales", "24"));  Jira 1890 3/19/2014
			subjectList.add(new NameValuePair("Training and Safety", "16"));

			
			HercCountryDialectsInfo hercCountryDialectsInfo = new HercCountryDialectsInfo();
			hercCountryDialectsInfo.add (new HercCountryDialectsItemInfo ("enUS", "Saudi Arabia", "SA"));

			CentralResItemInfo centralResItemInfo = new CentralResItemInfo ("800-116-1006", "Centralres@hertz.com", "hercsales@hertz.com");

			ArrayList<NameValuePair> priceRangeList = new ArrayList<NameValuePair>();
			priceRangeList.add(new NameValuePair("0-999 USD", "1"));
			priceRangeList.add(new NameValuePair("1,000-4,999 USD", "2"));
			priceRangeList.add(new NameValuePair("5,000-9,999 USD", "3"));
			priceRangeList.add(new NameValuePair("10,000-24,999 USD", "4"));
			priceRangeList.add(new NameValuePair("25,000-49,999 USD", "5"));
			priceRangeList.add(new NameValuePair("Greater Than 50,000 USD", "6"));

			HercCountryRentalManItemInfo hercCountryRentalManItemInfo = new HercCountryRentalManItemInfo();
			hercCountryRentalManItemInfo.setRmCapable (true);
			hercCountryRentalManItemInfo.setRmCountryCode ("SA");
			hercCountryRentalManItemInfo.setRmDataSource ("jdbc/com/hertz/herc/SARentalmanSQL");
			hercCountryRentalManItemInfo.setRmRatesDataSource ("jdbc/com/hertz/herc/SARentalmanSP");
			hercCountryRentalManItemInfo.setRmContractLocations (false);
			hercCountryRentalManItemInfo.setPayInvoices (false);
			hercCountryRentalManItemInfo.setRatesLookupNSB ("string/com/hertz/herc/CountryCodeSA");
			hercCountryRentalManItemInfo.setEtrieveCountryCode ("SA");

			HercCountryItemInfo hercCountryItemInfo = new HercCountryItemInfo (6);
			hercCountryItemInfo.setActive (false);
			hercCountryItemInfo.setTwoDigitStringCode ("SA");
			hercCountryItemInfo.setTwoDigitIntCode ("06");
			hercCountryItemInfo.setSubjectList (subjectList);
			hercCountryItemInfo.setCentralResItemInfo (centralResItemInfo);
			hercCountryItemInfo.setHercCountryDialectsInfo (hercCountryDialectsInfo);
			hercCountryItemInfo.setPriceRangeList (priceRangeList);
			hercCountryItemInfo.setMemberCapable (true);
			hercCountryItemInfo.setReleaseCapable (true);
			hercCountryItemInfo.setExtendCapable (true);
			hercCountryItemInfo.setOverdueRentalsCapable (true);
			hercCountryItemInfo.setBranchPrefix ("6");
			hercCountryItemInfo.setOverdueRentalsOption (true);
			hercCountryItemInfo.setGoogleMapsEnabled (true);
			hercCountryItemInfo.setMobileEnabled (true);
			hercCountryItemInfo.setHercCountryRentalManItemInfo (hercCountryRentalManItemInfo);
			m_collection.add (hercCountryItemInfo);
		}

		{
			ArrayList<NameValuePair> subjectList = new ArrayList<NameValuePair>();
			subjectList.add(new NameValuePair("Customer Feedback", "3"));
			subjectList.add(new NameValuePair("Customer Programs", "1"));
			subjectList.add(new NameValuePair("Equipment Rental Inquiry", "7"));
			subjectList.add(new NameValuePair("Equipment Sales Inquiry", "6"));
			subjectList.add(new NameValuePair("Export Sales Inquiry", "4"));
			subjectList.add(new NameValuePair("Franchise Opportunities", "28"));
			subjectList.add(new NameValuePair("General Questions", "8"));
			subjectList.add(new NameValuePair("Hertz Entertainment Services", "27"));
			subjectList.add(new NameValuePair("Service Pump & Compressor Inquiry", "19"));
			// subjectList.add(new NameValuePair("Tool & Supply Sales", "24"));  Jira 1890 3/19/2014
			subjectList.add(new NameValuePair("Training and Safety", "16"));

			HercCountryDialectsInfo hercCountryDialectsInfo = new HercCountryDialectsInfo();
			hercCountryDialectsInfo.add (new HercCountryDialectsItemInfo ("enUS", "Afghanistan", "AF"));

			CentralResItemInfo centralResItemInfo = new CentralResItemInfo ("+971 4-304-7851", "info_af@hertz.com", "info_af@hertz.com");

			ArrayList<NameValuePair> priceRangeList = new ArrayList<NameValuePair>();
			priceRangeList.add(new NameValuePair("0-999 AFA", "1"));
			priceRangeList.add(new NameValuePair("1,000-4,999 AFA", "2"));
			priceRangeList.add(new NameValuePair("5,000-9,999 AFA", "3"));
			priceRangeList.add(new NameValuePair("10,000-24,999 AFA", "4"));
			priceRangeList.add(new NameValuePair("25,000-49,999 AFA", "5"));
			priceRangeList.add(new NameValuePair("Greater Than 50,000 AFA", "6"));

			HercCountryItemInfo hercCountryItemInfo = new HercCountryItemInfo (5);
			hercCountryItemInfo.setActive (true);
			hercCountryItemInfo.setTwoDigitStringCode ("AF");
			hercCountryItemInfo.setTwoDigitIntCode ("05");
			hercCountryItemInfo.setSubjectList (subjectList);
			hercCountryItemInfo.setCentralResItemInfo (centralResItemInfo);
			hercCountryItemInfo.setHercCountryDialectsInfo (hercCountryDialectsInfo);
			hercCountryItemInfo.setPriceRangeList (priceRangeList);
			hercCountryItemInfo.setUseMiles (true);
			hercCountryItemInfo.setBranchPrefix ("5");
			hercCountryItemInfo.setGoogleMapsEnabled (true);
			m_collection.add (hercCountryItemInfo);
		}
	}

	/**
	 * Get number of countries that have been implemented and are active.
	 * 
	 * @return number of countries
	 */
	public static int getNumberOfCountries() {
		int count = 0;
		Iterator<HercCountryItemInfo> iter = getItems();
		while (iter.hasNext()) {
			HercCountryItemInfo item = iter.next();
			if (item == null) continue;
			if (! item.isActive()) continue;
			count++;
		}
		return count;
	}

	/**
	 * Get HercCountryItemInfo object from an int Country Code. If the country
	 * code was not found or is not active, the returned object will be null.
	 * 
	 * @param countryCode			country code
	 * @return HercCountryItemInfo object
	 */
	private static HercCountryItemInfo getItem (int countryCode) {
		Iterator<HercCountryItemInfo> iter = getItems();
		while (iter.hasNext()) {
			HercCountryItemInfo item = iter.next();
			if (item == null) continue;
			if (! item.isActive()) continue;
			if (countryCode == item.getCode()) return item;
		}
		return null;
	}

	/**
	 * Get HercCountryItemInfo object from a 2 digit Country Code. If the
	 * country code was not found or is not active, the returned object will be
	 * null.
	 * 
	 * @param countryCode		2 digit country code
	 * @return HercCountryItemInfo object
	 */
	private static HercCountryItemInfo getItemByCountry (String country) {
		if (country == null) return null;
		Iterator<HercCountryItemInfo> iter = getItems();
		while (iter.hasNext()) {
			HercCountryItemInfo item = iter.next();
			if (item == null) continue;
			if (! item.isActive()) continue;
			if (item.getTwoDigitStringCode().equalsIgnoreCase(country)) return item;
		}
		return null;
	}

	/**
	 * Get HercCountryItemInfo object from a branch prefix. If the country code
	 * was not found or is not active, the returned object will be null.
	 * 
	 * @param countryCode		country code
	 * @return HercCountryItemInfo object
	 */
	private static HercCountryItemInfo getItemByBranchPrefix (String branch) {
		if (branch == null) return null;
		if (branch.length() < 1) return null;
		String branchPrefix = branch.substring(0, 1);
		Iterator<HercCountryItemInfo> iter = getItems();
		while (iter.hasNext()) {
			HercCountryItemInfo item = iter.next();
			if (item == null) continue;
			if (! item.isActive()) continue;
			if (branchPrefix.equals(item.getBranchPrefix())) return item;
		}
		return null;
	}

	/**
	 * Determine whether the 2 digit country code is valid.
	 * 
	 * @param twoDigitCountryCode		2 digit country code
	 * @return true if 2 digit country code exists and is active.
	 */
	public static boolean isValidTwoDigitCountry (String twoDigitCountryCode) {
		return getItemByCountry (twoDigitCountryCode) != null;
	}

	/**
	 * Determine whether to use Rouse Sales for a given country code.
	 * 
	 * @param countryCode			country code.
	 * @return true implies use Rouse Sales, else use Herc Sales.
	 */
	public static boolean isRouseSales (int countryCode) {
		HercCountryItemInfo hercCountryItemInfo = getItem (countryCode);
		if (hercCountryItemInfo == null) return false;
		if (! hercCountryItemInfo.isActive()) return false;
		return hercCountryItemInfo.isRouseSales();
	}

	/**
	 * Determine whether to use Tool Supply Sales for a given country code.
	 * 
	 * @param countryCode		country code.
	 * @return true implies allow Tool Supply Sales.
	 */
	public static boolean isToolSupplySales (int countryCode) {
		HercCountryItemInfo hercCountryItemInfo = getItem (countryCode);
		if (hercCountryItemInfo == null) return false;
		if (! hercCountryItemInfo.isActive()) return false;
		return hercCountryItemInfo.isToolSupplySales();
	}

	/**
	 * Determine whether mobile is enabled for given country code
	 * 
	 * @param countryCode		country code
	 * @return true implies allow mobile
	 */
	public static boolean isMobileEnabled (int countryCode) {
		HercCountryItemInfo hercCountryItemInfo = getItem(countryCode);
		if (hercCountryItemInfo == null) return false;
		if (! hercCountryItemInfo.isActive()) return false;
		return hercCountryItemInfo.isMobileEnabled();
	}

	/**
	 * Determine whether to use miles or kilometres for a given country code.
	 * 
	 * @param countryCode			country code.
	 * @return true implies use miles, else use kilometres.
	 */
	public static boolean isUseMiles (int countryCode) {
		HercCountryItemInfo hercCountryItemInfo = getItem (countryCode);
		if (hercCountryItemInfo == null) return false;
		if (! hercCountryItemInfo.isActive()) return false;
		return hercCountryItemInfo.isUseMiles();
	}

	/**
	 * Determine whether country supports release functionality.
	 * 
	 * @param countryCode			country code.
	 * @return true implies country supports release functionality, else false.
	 */
	// TODO; remove this; only use int countryCode
	public static boolean isReleaseCapable (String countryCode) {
		HercCountryItemInfo hercCountryItemInfo = getItemByCountry (countryCode);
		if (hercCountryItemInfo == null) return false;
		if (! hercCountryItemInfo.isActive()) return false;
		return hercCountryItemInfo.isReleaseCapable();
	}

	/**
	 * Determine whether country supports release functionality.
	 * 
	 * @param countryCode		country code.
	 * @return true implies country supports release functionality, else false.
	 */
	public static boolean isReleaseCapable (int countryCode) {
		HercCountryItemInfo hercCountryItemInfo = getItem (countryCode);
		if (hercCountryItemInfo == null) return false;
		if (! hercCountryItemInfo.isActive()) return false;
		return hercCountryItemInfo.isReleaseCapable();
	}

	/**
	 * Determine whether country supports extend functionality.
	 * 
	 * @param countryCode			country code.
	 * @return true implies country supports extend functionality, else false.
	 */
	// TODO; remove this; only use int countryCode
	public static boolean isExtendCapable (String countryCode) {
		HercCountryItemInfo hercCountryItemInfo = getItemByCountry (countryCode);
		if (hercCountryItemInfo == null) return false;
		if (! hercCountryItemInfo.isActive()) return false;
		return hercCountryItemInfo.isExtendCapable();
	}

	/**
	 * Determine whether country supports extend functionality.
	 * 
	 * @param countryCode			country code.
	 * @return true implies country supports extend functionality, else false.
	 */
	public static boolean isExtendCapable (int countryCode) {
		HercCountryItemInfo hercCountryItemInfo = getItem (countryCode);
		if (hercCountryItemInfo == null) return false;
		if (! hercCountryItemInfo.isActive()) return false;
		return hercCountryItemInfo.isExtendCapable();
	}

	/**
	 * Determine whether country supports fleet functionality.
	 * 
	 * @param countryCode			country code.
	 * @return true implies country supports fleet functionality, else false.
	 */
	public static boolean isFleetCapable (int countryCode) {
		HercCountryItemInfo hercCountryItemInfo = getItem (countryCode);
		if (hercCountryItemInfo == null) return false;
		if (! hercCountryItemInfo.isActive()) return false;
		return hercCountryItemInfo.isFleetCapable();
	}

	/**
	 * Determine whether country supports overdue rentals functionality.
	 * 
	 * @param countryCode		country code.
	 * @return true implies country supports overdue rentals functionality, else false.
	 */
	public static boolean isOverdueRentalsCapable (int countryCode) {
		HercCountryItemInfo hercCountryItemInfo = getItem (countryCode);
		if (hercCountryItemInfo == null) return false;
		if (! hercCountryItemInfo.isActive()) return false;
		return hercCountryItemInfo.isOverdueRentalsCapable();
	}

	/**
	 * Determine whether country supports government programs functionality.
	 * 
	 * @param countryCode			country code.
	 * @return true implies country supports government programs functionality, else false.
	 */
	public static boolean isGovProgramsCapable (int countryCode) {
		HercCountryItemInfo hercCountryItemInfo = getItem (countryCode);
		if (hercCountryItemInfo == null) return false;
		if (! hercCountryItemInfo.isActive()) return false;
		return hercCountryItemInfo.isGovProgramsCapable();
	}

	/**
	 * Determine whether country supports member section functionality.
	 * 
	 * @param countryCode		country code.
	 * @return true implies country supports overdue rentals functionality, else false.
	 */
	public static boolean isMemberCapable (int countryCode) {
		HercCountryItemInfo hercCountryItemInfo = getItem (countryCode);
		if (hercCountryItemInfo == null) return false;
		if (! hercCountryItemInfo.isActive()) return false;
		return hercCountryItemInfo.isMemberCapable();
	}

	/**
	 * Determine whether country supports help functionality.
	 * 
	 * @param countryCode			country code.
	 * @return true implies country supports help functionality, else false.
	 */
	public static boolean isHelpCapable (int countryCode) {
		HercCountryItemInfo hercCountryItemInfo = getItem (countryCode);
		if (hercCountryItemInfo == null) return false;
		if (! hercCountryItemInfo.isActive()) return false;
		return hercCountryItemInfo.isHelpCapable();
	}

	/**
	 * Get a list of numeric country codes of all implemented countries
	 * 
	 * @return list of country codes
	 */
	public static List<Integer> getListIntCountryCodes() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Iterator<HercCountryItemInfo> iter = getItems();
		while (iter.hasNext()) {
			HercCountryItemInfo item = iter.next();
			if (item == null) continue;
			if (! item.isActive()) continue;
			list.add (new Integer (item.getCode()));
		}
		return list;
	}

	/**
	 * Get a list of country codes of all implemented countries
	 * 
	 * @return list of country codes
	 */
	public static List<String> getListCountryCodes() {
		ArrayList<String> list = new ArrayList<String>();
		Iterator<HercCountryItemInfo> iter = getItems();
		while (iter.hasNext()) {
			HercCountryItemInfo item = iter.next();
			if (item == null) continue;
			if (! item.isActive()) continue;
			list.add (item.getTwoDigitStringCode());
		}
		return list;
	}

	/**
	 * Get list of supported Point of Sales
	 * 
	 * @param dialect		dialect
	 * @return list of supported Point of Sales
	 */
	public static Collection<NameValuePair> getPosList (String dialect) {
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		Iterator<HercCountryItemInfo> iter = getItems();
		while (iter.hasNext()) {
			HercCountryItemInfo item = iter.next();
			if (item == null) continue;
			if (! item.isActive()) continue;
			list.add (new NameValuePair (item.getCountryText(dialect), item.getTwoDigitStringCode()));
		}
		return list;
	}

	/**
	 * Get list of countries backed by numeric country codes.
	 * 
	 * @param dialect		dialect
	 * @return list of countries backed by numeric country codes.
	 */
	public static List<NameValuePair> getNumericCountryCodeList (String dialect) {
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		Iterator<HercCountryItemInfo> iter = getItems();
		while (iter.hasNext()) {
			HercCountryItemInfo item = iter.next();
			if (item == null) continue;
			if (! item.isActive()) continue;
			list.add (new NameValuePair (item.getCountryText(dialect), new Integer(item.getCode()).toString()));
		}
		return list;
	}

	/**
	 * Get the NameValuePair of Country from country set string codes
	 * 
	 * @param countrySet		Integer country codes - 1,2
	 * @param dialect			DialectItemInfo
	 * @return NameValuePair List for countrySet
	 */
	public static ArrayList<NameValuePair> getCountryList(Set<Integer> countrySet, DialectItemInfo dialect) {
		ArrayList<NameValuePair> list = new ArrayList<NameValuePair>();
		Iterator<HercCountryItemInfo> iter = getItems();
		while (iter.hasNext()) {
			HercCountryItemInfo item = iter.next();
			if (item == null) continue;
			if (! item.isActive()) continue;
			if (! countrySet.contains (item.getCode())) continue;
			list.add (new NameValuePair (item.getCountryText(dialect.getDialect()), new Integer(item.getCode()).toString()));
		}
		return list;
	}

	/**
	 * Get default country code (US)
	 * 
	 * @return US country code
	 */
	public static int getDefaultCountryCode() {
		return 1;
	}

	/**
	 * Get default two digit country code
	 * 
	 * @return default two digit country code (example: US)
	 */
	public static String getDefaultTwoDigitCountryCode() {
		return getTwoDigitCountryCode (getDefaultCountryCode());
	}

	/**
	 * Get default point of sale for the default country
	 * 
	 * @return default point of sale for the default country
	 */
	public static PosItemInfo getDefaultPosItemInfo() {
		return new PosItemInfo (getItem (getDefaultCountryCode()).getCode());
	}

	/**
	 * Get default dialect for the default country
	 * 
	 * @return default dialect for the default country
	 */
	public static DialectItemInfo getDefaultDialectItemInfo() {
		return new DialectItemInfo (getItem (getDefaultCountryCode()).getDefaultDialect());
	}

	/**
	 * Get subject list for country
	 * 
	 * @param countryCode		country code
	 * @return subject list for country
	 */
	public static ArrayList<NameValuePair> getSubjectList (int countryCode) {
		return getItem(countryCode).getSubjectList();
	}

	/**
	 * Get branch prefix
	 * 
	 * @param countryCode		country code
	 * @return branch prefix
	 */
	public static String getBranchPrefix (int countryCode) {
		HercCountryItemInfo item = getItem (countryCode);
		if (item == null) return "";
		return item.getBranchPrefix();
	}

	/**
	 * Get default dialect
	 * 
	 * @param countryCode			country code
	 * @return default dialect
	 */
	public static String getDefaultDialect (int countryCode) {
		HercCountryItemInfo item = getItem (countryCode);
		if (item == null) return "";
		return item.getDefaultDialect();
	}

	/**
	 * Get dialects
	 * 
	 * @param countryCode		country code
	 * @return dialects
	 */
	public static String[] getDialects (int countryCode) {
		HercCountryItemInfo item = getItem (countryCode);
		if (item == null) return null;
		return item.getDialects();
	}

	/**
	 * Get Country name for a country code for a given dialect
	 * 
	 * @param countryCode		country code
	 * @param dialect			dialect
	 * @return country name
	 */
	public static String getCountryNameFromCountryCode (int countryCode, String dialect) {
		HercCountryItemInfo item = getItem (countryCode);
		if (item == null) return null;
		return item.getCountryText (dialect);
	}

	/**
	 * Get Country name from country code.
	 * 
	 * @param countryCode		country code
	 * @return country name
	 */
	public static String getCountryNameFromCountryCode (int countryCode) {
		String defaultDialect = getDefaultDialect (countryCode);
		return getCountryNameFromCountryCode (countryCode, defaultDialect);
	}

	/**
	 * Get Country abbreviation for a Country Code for a given dialect
	 * 
	 * @param countryCode		Country code
	 * @param dialect			dialect
	 * @return Country abbreviation
	 */
	public static String getCountryAbbrevFromCountryCode (int countryCode, String dialect) {
		HercCountryItemInfo item = getItem (countryCode);
		if (item == null) return null;
		return item.getCountryAbbreviation (dialect);
	}

	/**
	 * Get Country abbreviation from the Country Code.
	 * 
	 * @param countryCode		Country code
	 * @return Country abbreviation
	 */
	public static String getCountryAbbrevFromCountryCode (int countryCode) {
		String defaultDialect = getDefaultDialect (countryCode);
		return getCountryAbbrevFromCountryCode (countryCode, defaultDialect);
	}

	/**
	 * Determine whether the country code is valid.
	 * 
	 * @param countryCode		country code
	 * @return true if country code exists and is active.
	 */
	public static boolean isValidCountryCode (int countryCode) {
		return getItem (countryCode) != null;
	}

	/**
	 * Determine whether country code is valid
	 * 
	 * @param countryCode		country code
	 * @return true if valid
	 */
	public static boolean isNumericZipCode (int countryCode) {
		HercCountryItemInfo item = getItem (countryCode);
		if (item == null) return true;
		return item.isNumericZipCode();
	}

	/**
	 * Determine whether country code is valid
	 * 
	 * @param countryCode		country code
	 * @return true if valid
	 */
	public static CentralResItemInfo getCentralResItemInfo (int countryCode) {
		HercCountryItemInfo item = getItem (countryCode);
		if (item == null) return null;
		return item.getCentralResItemInfo();
	}

	/**
	 * Get 2 digit country code from an int country code. Will return null if
	 * the country code is not valid.
	 * 
	 * @param countryCode			country code (example: 1,2)
	 * @return 2 digit country code
	 */
	public static String getTwoDigitCountryCode (int countryCode) {
		HercCountryItemInfo item = getItem (countryCode);
		if (item == null) return null;
		return item.getTwoDigitStringCode();
	}

	/**
	 * Get a 2 digit int representation of a country from the country code.
	 * 
	 * @param countryCode		country code
	 * @return country (example: 01, 02)
	 */
	public static String getTwoDigitIntCountryCode (int countryCode) {
		HercCountryItemInfo item = getItem (countryCode);
		if (item == null) return "01";
		return item.getTwoDigitIntCode();
	}

	/**
	 * Get int country code from a 2 digit country code
	 * 
	 * @param pos			2 digit country code (example: US);
	 * @return country code (example: 1).
	 */
	public static int getCountryCodeFromTwoDigitCountryCode (String pos) {
		HercCountryItemInfo item = getItemByCountry (pos);
		if (item == null) return getDefaultCountryCode();
		return item.getCode();
	}

	/**
	 * Get price Range list for country.
	 * 
	 * @param countryCode		country code
	 * @param dialect			dialect
	 * @return Price Range list for country
	 */
	public static ArrayList<NameValuePair> getPriceRangetList (int countryCode, String dialect) {
		return getItem (countryCode).getPriceRangeList();
	}

	/*
	 * convenience methods
	 */

	/**
	 * Get two digit country code from the branch, example US, CA, etc
	 * 
	 * @param branch		Branch
	 * @return two digit country code
	 */
	public static String getTwoDigitCountryCodeFromBranch (String branch) {
		HercCountryItemInfo hercCountryItemInfo = getItemByBranchPrefix (branch);
		if (hercCountryItemInfo == null) return "";
		return hercCountryItemInfo.getTwoDigitStringCode();
	}

	/**
	 * Get country code from the branch, example 1, 2 etc
	 * 
	 * @param branch		Branch
	 * @return two digit country code
	 */
	public static int getCountryCodeFromBranch (String branch) {
		HercCountryItemInfo hercCountryItemInfo = getItemByBranchPrefix (branch);
		if (hercCountryItemInfo == null) return 0;
		return hercCountryItemInfo.getCode();
	}

	/**
	 * Get Etrieve 3 digit country code from a country code
	 * 
	 * @param countryCode		country code
	 * @return 3 digit country code
	 */
	public static String getEtrieveCountryCode (int countryCode) {
		HercCountryItemInfo item = getItem (countryCode);
		if (item == null) return "";
		return item.getHercCountryRentalManItemInfo().getEtrieveCountryCode();
	}

	/**
	 * Get Rouse country code from a country code
	 * 
	 * @param countryCode		country code
	 * @return Rouse country code
	 */
	public static String getRouseCountryCode (int countryCode) {
		HercCountryItemInfo item = getItem (countryCode);
		if (item == null) return "";
		return item.getRouseCountryCode();
	}

	/**
	 * Get Rouse Category from category name
	 * 
	 * @param countryCode		country code
	 * @param categoryName		category name
	 * @return Rouse category code
	 */
	public static String getRouseCategory (int countryCode, String categoryName) {
		HercCountryItemInfo item = getItem (countryCode);
		if (item == null) return null;
		return item.getRouseCategories().get (categoryName);
	}

	/**
	 * Get Rentalman country code
	 * 
	 * @param countryCode			country code
	 * @return 3 digit country code
	 */
	public static String getRmCountryCode (int countryCode) {
		HercCountryItemInfo item = getItem (countryCode);
		if (item == null) return "";
		return item.getHercCountryRentalManItemInfo().getRmCountryCode();
	}

	/**
	 * Get RentalMan datasource for a country code
	 * 
	 * @param countryCode		country code
	 * @return RentalMan 		datasource
	 */
	public static String getRmDataSource (int countryCode) {
		HercCountryItemInfo item = getItem (countryCode);
		if (item == null) return "";
		return item.getHercCountryRentalManItemInfo().getRmDataSource();
	}

	/**
	 * Get datasource name for the scenario demo vs. production
	 * 
	 * @param demo			true if this is a demo company account
	 * @param countryCode	country code
	 * @return				Datasource name
	 */
	public static String getRmDataSource (boolean demo, int countryCode) {
		if (demo) return HERC_DEMODATA_DATASOURCE_SQL;
		return HercCountryHelper.getRmDataSource (countryCode);
	}

	/**
	 * Get RentalMan rates datasource for a country code
	 * 
	 * @param countryCode		country code
	 * @return RentalMan 		datasource
	 */
	public static String getRmRatesDataSource (int countryCode) {
		HercCountryItemInfo item = getItem (countryCode);
		if (item == null) return "";
		return item.getHercCountryRentalManItemInfo().getRmRatesDataSource();
	}

	/**
	 * Determine whether rentalman support contract locations
	 * 
	 * @param countryCode		country code
	 * @return true if rentalman support contract locations
	 */
	public static boolean isRmContractLocations (int countryCode) {
		HercCountryItemInfo item = getItem (countryCode);
		if (item == null) return false;
		return item.getHercCountryRentalManItemInfo().isRmContractLocations();
	}

	/**
	 * Determine whether support for payment of invoices through etrieve.
	 * 
	 * @param countryCode		country code
	 * @return true if rentalman support contract locations
	 */
	public static boolean isPayInvoices (int countryCode) {
		HercCountryItemInfo item = getItem (countryCode);
		if (item == null) return false;
		return item.getHercCountryRentalManItemInfo().isPayInvoices();
	}

	/**
	 * Determine whether to use alternate branch for overdue rentals
	 * 
	 * @param countryCode		country code
	 * @return true if use alternate branch for overdue rentals
	 */
	public static boolean isOverdueRentalsOption (int countryCode) {
		HercCountryItemInfo item = getItem (countryCode);
		if (item == null) return false;
		return item.isOverdueRentalsOption();
	}

	/**
	 * Determine whether rentalman is available for this country
	 * 
	 * @param countryCode		country code
	 * @return true if rentalman is available for this country
	 */
	public static boolean isRmCapable (int countryCode) {
		HercCountryItemInfo item = getItem (countryCode);
		if (item == null) return false;
		return item.getHercCountryRentalManItemInfo().isRmCapable();
	}

	/**
	 * Determine whether rentalman rates lookup is available for this country
	 * 
	 * @param countryCode		country code
	 * @return true if rentalman is available for this country
	 */
	public static boolean isRmRatesLookupCapable (int countryCode) {
		HercCountryItemInfo item = getItem (countryCode);
		if (item == null) return false;
		return item.getHercCountryRentalManItemInfo().isRmRatesLookupCapable();
	}

	/*
	 * these methods will need some work
	 */

	/**
	 * Get the two digit country code from the country/state code
	 * 
	 * @param countryState			country/state code
	 * @return two digit country code, or an empty String if not found
	 */
	public static String getTwoDigitCountryCodeFromCountryStateCode (String countryState) {
		if (countryState != null && countryState.length() >= 2)
			return countryState.substring(0, 2);
		return "";
	}

	/**
	 * Get the two digit state code from the country/state code
	 * 
	 * @param countryState			country/state code
	 * @return two digit state code, or an empty String if not found
	 */
	public static String getTwoDigitStateCodeFromCountryStateCode (String countryState) {
		if (countryState != null && countryState.length() >= 4)
			return countryState.substring(2, 4);
		return "";
	}

	/**
	 * Get Country Name from the 4 digit Country/State Code.
	 * 
	 * @param countryState			4 digit Country/State Code
	 * @return Country Name or empty String if not found
	 */
	public static String getCountryNameFromCountryStateCode (String countryState) {
		int countryCode = getCountryCodeFromTwoDigitCountryCode (getTwoDigitCountryCodeFromCountryStateCode (countryState));
		HercCountryItemInfo item = getItem (countryCode);
		if (item == null) return "";
		return item.getCountryText("enUS"); // TODO; make dialect aware
	}

	/**
	 * Get Two digit Country Code String from the 4 digit Country/State Code.
	 * 
	 * @param countryState			4 digit Country/State Code
	 * @return Country abbreviation
	 */
	public static String getTwoDigitCountryCodeStringFromCountryStateCode (String countryState) {
		int countryCode = getCountryCodeFromTwoDigitCountryCode (getTwoDigitCountryCodeFromCountryStateCode (countryState));
		HercCountryItemInfo item = getItem (countryCode);
		if (item == null) return "";
		return item.getTwoDigitStringCode();
	}

	/**
	 * Get Country abbreviation from the 4 digit Country/State Code.
	 * 
	 * @param countryState			4 digit Country/State Code
	 * @return Country abbreviation
	 */
	public static String getCountryAbbrevFromCountryStateCode (String countryState) {
		int countryCode = getCountryCodeFromTwoDigitCountryCode (getTwoDigitCountryCodeFromCountryStateCode (countryState));
		HercCountryItemInfo item = getItem (countryCode);
		if (item == null) return "";
		return item.getCountryAbbreviation("enUS"); // TODO; make dialect aware
	}

	/**
	 * Get Country/State abbreviation from the 4 digit Country/State Code.
	 * 
	 * @param countryState			4 digit Country/State Code
	 * @return Country/State abbreviation
	 */
	public static String getCountryStateAbbrevFromCountryStateCode (String countryState) {
		return getTwoDigitStateCodeFromCountryStateCode (countryState) + " "
				+ getCountryAbbrevFromCountryStateCode (countryState);
	}

	/**
	 * Get Herc countryCode from Rentalman country code code
	 * 
	 * @param rmCountryCode			Rentalman country code
	 * @return Herc country code
	 */
	public static int getCountryCodeFromRM (String rmCountryCode) {
		Iterator<HercCountryItemInfo> iterator = getItems();
		HercCountryItemInfo countryItemInfo = null;
		while (iterator.hasNext()) {
			countryItemInfo = iterator.next();
			if (countryItemInfo.getHercCountryRentalManItemInfo().getRmCountryCode().equalsIgnoreCase (rmCountryCode))
				return countryItemInfo.getCode();
		}
		return 0;
	}

	/**
	 * is MapQuest available for this country
	 * 
	 * @param countryCode			Numeric country code
	 * @return Is mapping service enabled
	 */
	public static boolean isMapQuestEnabled (int countryCode) {
		HercCountryItemInfo countryItemInfo = getItem(countryCode);
		if (countryItemInfo != null)
			return countryItemInfo.isMapQuestEnabled();
		return true;
	}

	/**
	 * is Bing Maps available for this country
	 * 
	 * @param countryCode			Numeric country code
	 * @return Is mapping service enabled
	 */
	public static boolean isBingMapsEnabled (int countryCode) {
		HercCountryItemInfo countryItemInfo = getItem(countryCode);
		if (countryItemInfo != null)
			return countryItemInfo.isBingMapsEnabled();
		return true;
	}

	/**
	 * is Google Maps available for this country
	 * 
	 * @param countryCode			Numeric country code
	 * @return Is mapping service enabled
	 */
	public static boolean isGoogleMapsEnabled (int countryCode) {
		HercCountryItemInfo countryItemInfo = getItem(countryCode);
		if (countryItemInfo != null)
			return countryItemInfo.isGoogleMapsEnabled();
		return true;
	}

	/**
	 * Returns the PosItemInfo of for the Catalog.
	 * 
	 * @param countryCode						int
	 * @return									PosItemInfo
	 */
	public static PosItemInfo getCatalogPosItemInfo(int countryCode){			
		HercCountryItemInfo countryItemInfo = getItem (countryCode);
		if (countryItemInfo == null) return null;
		if (countryItemInfo.getCatalogCountryCode() <= 0)
			return new PosItemInfo(countryCode);	
		return new PosItemInfo(countryItemInfo.getCatalogCountryCode());
	}
	
	
	/**
	 * Get String
	 */
	public String toString() {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < m_collection.size(); i++)
			buf.append(m_collection.get(i).toString());
		return "(" + buf.toString() + ")";
	}
}

/*
 * List countryStateList = LocationBroker.getStateProvinceCountryList("ADDR",
 * session, "enUS");
 * 
 * public static ArrayList getCountryStateProvinceList(String dialect) {
 * ArrayList list = new ArrayList();
 * 
 * list.add("USA - New Jersey"); list.add("USA - New York");
 * list.add("Canada - Quebec"); list.add("Canada - Ontario");
 * 
 * return list; }
 */
/*
 * public static int JVgetCodeFromCountry (String country) { if (country ==
 * null) return US_CODE; String str = country.trim().toUpperCase(); if
 * (str.equals("CA")) return CA_CODE; return US_CODE; }
 */
/*

*/
/*
 * public static String JVgetStringCountryCode (int countryCode) { if
 * (countryCode == CA_CODE) return "CA"; return "US"; }
 */
/*
 * Get countrycode from country
 */
/*
 * public static int getCodeFromCountry (String country) { if (country == null)
 * return RMAccountType.US_CODE; String str = country.trim().toUpperCase(); if
 * (str.equals("CA")) return RMAccountType.CA_CODE; return
 * RMAccountType.US_CODE; }
 */
/*
 * public static NameValuePair buildNameValuePair(BranchLocationsDataItemInfo
 * itemInfo) { String countryState = itemInfo.getCountry() + " - " +
 * itemInfo.getSt(); String coSt = itemInfo.getCountryState(); return new
 * NameValuePair(countryState, coSt); }
 */

/**
 * Return true if passed Point of Sale is valid
 * 
 * @param pos
 *            Point of Sale
 * @return true if passed Point of Sale is valid
 */
/*
 * public static boolean isPosValid (String pos) { if (pos == null) return
 * false; if (pos.length() < 1) return false; return isValidTwoDigitCountry
 * (pos); }
 */
/*
 * public static List<NameValuePair> getStringCountryCodeList() {
 * ArrayList<NameValuePair> list = new ArrayList<NameValuePair>(); list.add (new
 * NameValuePair ("United States", "US")); list.add (new NameValuePair
 * ("Canada", "CA")); return list; }
 */
/*
 * public static List<NameValuePair> getNumericCountryCodeList() {
 * ArrayList<NameValuePair> list = new ArrayList<NameValuePair>(); list.add (new
 * NameValuePair ("United States", "1")); list.add (new NameValuePair ("Canada",
 * "2")); return list; }
 */
/*
 * public static String JVbuildDateString(String language, String pos, Calendar
 * eventCalendar) { Locale locale = new Locale(language, pos); String dateFormat
 * = constructDateFormatString(pos); SimpleDateFormat sdf = new
 * SimpleDateFormat(dateFormat, locale); return (eventCalendar != null) ?
 * sdf.format(eventCalendar.getTime()) : ""; } private static String
 * constructDateFormatString(String pos) { String dateFormat =
 * (("US".equalsIgnoreCase(pos)) || ("CA".equalsIgnoreCase(pos)) ||
 * ("KR".equalsIgnoreCase(pos))) ? "EEE, MMM dd, yyyy" : "EEE, dd MMM, yyyy";
 * return dateFormat; }
 */
