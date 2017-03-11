
package com.hertz.herc.franchise.info;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Describe Country container object
 * 
 * @author John Vincent
 */

public class HercCountryInfo implements Serializable {
	private static final long serialVersionUID = -1126385982729560319L;
	private ArrayList<HercCountryItemInfo> m_collection = new ArrayList<HercCountryItemInfo>();

	public Iterator<HercCountryItemInfo> getItems() {return m_collection.iterator();}
	public void add (HercCountryItemInfo item) {if (item != null) m_collection.add(item);}
	public int getSize() {return m_collection.size();}
	public boolean isNone() {return getSize() < 1;}

	/**
	 * Get number of countries that have been implemented and are active.
	 * 
	 * @return		number of countries
	 */
	public int getNumberOfCountries() {
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
	 * Get HercCountryItemInfo object from an int Country Code. If the country code
	 * was not found or is not active, the returned object will be null.
	 * 
	 * @param countryCode		country code
	 * @return					HercCountryItemInfo object
	 */
	public HercCountryItemInfo getItem (int countryCode) {
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
	 * Get HercCountryItemInfo object from a 2 digit Country Code. If the country code
	 * was not found or is not active, the returned object will be null.
	 * 
	 * @param countryCode		2 digit country code
	 * @return					HercCountryItemInfo object
	 */
	public HercCountryItemInfo getItemByCountry (String country) {
		if (country == null) return null;
		Iterator<HercCountryItemInfo> iter = getItems();
		while (iter.hasNext()) {
			HercCountryItemInfo item = iter.next();
			if (item == null) continue;
			if (! item.isActive()) continue;
			if (item.getTwoDigitStringCode().equalsIgnoreCase (country)) return item;
		}
		return null;
	}

	/**
	 * Get HercCountryItemInfo object from a branch prefix. If the country code
	 * was not found or is not active, the returned object will be null.
	 * 
	 * @param countryCode		country code
	 * @return					HercCountryItemInfo object
	 */
	public HercCountryItemInfo getItemByBranchPrefix (String branch) {
		if (branch == null) return null;
		if (branch.length() < 1) return null;
		String branchPrefix = branch.substring(0, 1);
		Iterator<HercCountryItemInfo> iter = getItems();
		while (iter.hasNext()) {
			HercCountryItemInfo item = iter.next();
			if (item == null) continue;
			if (! item.isActive()) continue;
			if (branchPrefix.equals (item.getBranchPrefix())) return item;
		}
		return null;
	}

	/**
	 * Determine whether the country code is valid.
	 * 
	 * @param countryCode		country code
	 * @return					true if country code exists and is active.
	 */
	public boolean isValidCountryCode (int countryCode) {return getItem (countryCode) != null;}

	/**
	 * Determine whether the 2 digit country code is valid.
	 * 
	 * @param twoDigitCountryCode		2 digit country code
	 * @return							true if 2 digit country code exists and is active.
	 */
	public boolean isValidTwoDigitCountry (String twoDigitCountryCode) {return getItemByCountry (twoDigitCountryCode) != null;}

	/**
	 * Determine whether to use Rouse Sales for a given country code.
	 * 
	 * @param countryCode		country code.
	 * @return					true implies use Rouse Sales, else use Herc Sales.
	 */
	public boolean isRouseSales (int countryCode) {
		HercCountryItemInfo hercCountryItemInfo = getItem (countryCode); 
		if (hercCountryItemInfo == null) return false;
		if (! hercCountryItemInfo.isActive()) return false;
		return hercCountryItemInfo.isRouseSales();
	}

	/**
	 * Determine whether to use Tool Supply Sales for a given country code.
	 * 
	 * @param countryCode		country code.
	 * @return					true implies use Rouse Sales, else use Herc Sales.
	 */
	public boolean isToolSupplySales (int countryCode) {
		HercCountryItemInfo hercCountryItemInfo = getItem (countryCode); 
		if (hercCountryItemInfo == null) return false;
		if (! hercCountryItemInfo.isActive()) return false;
		return hercCountryItemInfo.isToolSupplySales();
	}

	/**
	 * Determine whether to use miles or kilometres for a given country code.
	 * 
	 * @param countryCode		country code.
	 * @return					true implies use miles, else use kilometres.
	 */
	public boolean isUseMiles (int countryCode) {
		HercCountryItemInfo hercCountryItemInfo = getItem (countryCode); 
		if (hercCountryItemInfo == null) return false;
		if (! hercCountryItemInfo.isActive()) return false;
		return hercCountryItemInfo.isUseMiles();
	}

	/**
	 * Determine whether country supports release functionality.
	 * 
	 * @param countryCode		country code.
	 * @return					true implies country supports release functionality, else false.
	 */
	public boolean isReleaseCapable (String countryCode) {
		HercCountryItemInfo hercCountryItemInfo = getItemByCountry (countryCode); 
		if (hercCountryItemInfo == null) return false;
		if (! hercCountryItemInfo.isActive()) return false;
		return hercCountryItemInfo.isReleaseCapable();
	}

	/**
	 * Determine whether country supports release functionality.
	 * 
	 * @param countryCode		country code.
	 * @return					true implies country supports release functionality, else false.
	 */
	public boolean isReleaseCapable (int countryCode) {
		HercCountryItemInfo hercCountryItemInfo = getItem (countryCode); 
		if (hercCountryItemInfo == null) return false;
		if (! hercCountryItemInfo.isActive()) return false;
		return hercCountryItemInfo.isReleaseCapable();
	}

	/**
	 * Determine whether country supports extend functionality.
	 * 
	 * @param countryCode		country code.
	 * @return					true implies country supports extend functionality, else false.
	 */
	public boolean isExtendCapable (String countryCode) {
		HercCountryItemInfo hercCountryItemInfo = getItemByCountry (countryCode); 
		if (hercCountryItemInfo == null) return false;
		if (! hercCountryItemInfo.isActive()) return false;
		return hercCountryItemInfo.isExtendCapable();
	}

	/**
	 * Determine whether country supports extend functionality.
	 * 
	 * @param countryCode		country code.
	 * @return					true implies country supports extend functionality, else false.
	 */
	public boolean isExtendCapable (int countryCode) {
		HercCountryItemInfo hercCountryItemInfo = getItem (countryCode); 
		if (hercCountryItemInfo == null) return false;
		if (! hercCountryItemInfo.isActive()) return false;
		return hercCountryItemInfo.isExtendCapable();
	}

	/**
	 * Determine whether country supports fleet functionality.
	 * 
	 * @param countryCode		country code.
	 * @return					true implies country supports fleet functionality, else false.
	 */
	public boolean isFleetCapable (int countryCode) {
		HercCountryItemInfo hercCountryItemInfo = getItem (countryCode); 
		if (hercCountryItemInfo == null) return false;
		if (! hercCountryItemInfo.isActive()) return false;
		return hercCountryItemInfo.isFleetCapable();
	}

	/**
	 * Determine whether country supports overdue rentals functionality.
	 * 
	 * @param countryCode		country code.
	 * @return					true implies country supports overdue rentals functionality, else false.
	 */
	public boolean isOverdueRentalsCapable (int countryCode) {
		HercCountryItemInfo hercCountryItemInfo = getItem (countryCode); 
		if (hercCountryItemInfo == null) return false;
		if (! hercCountryItemInfo.isActive()) return false;
		return hercCountryItemInfo.isOverdueRentalsCapable();
	}

	/**
	 * Determine whether country supports member functionality.
	 * 
	 * @param countryCode		country code.
	 * @return					true implies country supports member functionality, else false.
	 */
	public boolean isMemberCapable (int countryCode) {
		HercCountryItemInfo hercCountryItemInfo = getItem (countryCode); 
		if (hercCountryItemInfo == null) return false;
		if (! hercCountryItemInfo.isActive()) return false;
		return hercCountryItemInfo.isMemberCapable();
	}
	
	/**
	 * Get a list of numeric country codes of all implemented countries
	 * 
	 * @return		list of country codes
	 */
	public List<Integer> getListIntCountryCodes() {
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
	 * @return		list of country codes
	 */
	public List<String> getListCountryCodes() {
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

	public Collection<NameValuePair> getPosList (String dialect) {
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

	public List<NameValuePair> getNumericCountryCodeList (String dialect) {
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
	 * Get String
	 */
	public String toString() {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < m_collection.size(); i++)
			buf.append((m_collection.get(i)).toString());
		return "("+buf.toString()+")";
	}
}
