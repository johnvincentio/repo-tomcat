package com.hertz.herc.franchise.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.hertz.herc.franchise.info.NameValuePair;

public class ListsHelper {
	private static HashMap<String, LinkedHashMap<String, String>> m_countryList;
	public static HashMap<String, LinkedHashMap<String, String>> getCountryList() {return m_countryList;}

	private static List<NameValuePair> m_prefixList;
	public static List<NameValuePair> getPrefixList() {return m_prefixList;}
	private static List<NameValuePair> m_suffixList;
	public static List<NameValuePair> getSuffixList() {return m_suffixList;}

	static {
		m_countryList = new HashMap<String, LinkedHashMap<String, String>> ();
		m_countryList.put ("United States", makeUSCountryStateList());
		m_countryList.put ("Canada", makeCACountryStateList());
		m_countryList.put ("Afghanistan", makeAFCountryStateList());
		m_prefixList = makePrefixList();
		m_suffixList = makeSuffixList();
	}

	private static LinkedHashMap<String, String> makeAFCountryStateList () {
		LinkedHashMap<String, String> states = new LinkedHashMap<String, String>();
		states.put ("AFBD", "Badakhshan");
		states.put ("AFBG", "Badghis");
		states.put ("AFBK", "Balkh");
		states.put ("AFBL", "Baghlan");
		states.put ("AFBM", "Bamyan");
		states.put ("AFDK", "Daykundi");
		states.put ("AFFH", "Farah");
		states.put ("AFFB", "Faryab");
		states.put ("AFGR", "Ghor");
		states.put ("AFGZ", "Ghazni");
		states.put ("AFHM", "Helmand");
		states.put ("AFHR", "Herat");
		states.put ("AFJW", "Jowzjan");
		states.put ("AFKB", "Kabul");
		states.put ("AFKD", "Kandahar");
		states.put ("AFKP", "Kapisa");
		states.put ("AFKT", "Khost");
		states.put ("AFKR", "Kunar");
		states.put ("AFKZ", "Kunduz");
		states.put ("AFLA", "Laghman");
		states.put ("AFLW", "Logar");
		states.put ("AFNG", "Nangarhar");
		states.put ("AFNM", "Nimruz");
		states.put ("AFNR", "Nuristan");
		states.put ("AFOZ", "Oru-zga-n");
		states.put ("AFPJ", "Panjshir");
		states.put ("AFPT", "Paktia");
		states.put ("AFPK", "Paktika");
		states.put ("AFPV", "Parwan");
		states.put ("AFSM", "Samangan");
		states.put ("AFSP", "Sar-e Pol");
		states.put ("AFTK", "Takhar");
		states.put ("AFVR", "Wardak");
		states.put ("AFZB", "Zabul");
		return states;
	}

	private static LinkedHashMap<String, String> makeCACountryStateList () {
		LinkedHashMap<String, String> states = new LinkedHashMap<String, String>();
		states = new LinkedHashMap<String, String>();
		states.put ("CAAB", "Alberta");
		states.put ("CABC", "British Columbia");
		states.put ("CAMB", "Manitoba");
		states.put ("CANB", "New Brunswick");
		states.put ("CANL", "Newfoundland");
		states.put ("CANT", "Northwest Territories");
		states.put ("CANS", "Nova Scotia");
		states.put ("CANU", "Nunavut");
		states.put ("CAON", "Ontario");
		states.put ("CAPE", "Prince Edward Island");
		states.put ("CAQC", "Quebec");
		states.put ("CASK", "Saskatchewan");
		states.put ("CAYT", "Yukon");
		return states;
	}

	private static LinkedHashMap<String, String> makeUSCountryStateList () {
		LinkedHashMap<String, String> states = new LinkedHashMap<String, String>();
		states = new LinkedHashMap<String, String>();
		states.put ("USAL", "Alabama");
		states.put ("USAK", "Alaska");
		states.put ("USAZ", "Arizona");
		states.put ("USAR", "Arkansas");
		states.put ("USCA", "California");
		states.put ("USCO", "Colorado");
		states.put ("USCT", "Connecticut");
		states.put ("USDC", "District Of Columbia");
		states.put ("USDE", "Delaware");
		states.put ("USFL", "Florida");
		states.put ("USGA", "Georgia");
		states.put ("USHI", "Hawaii");
		states.put ("USID", "Idaho");
		states.put ("USIL", "Illinois");
		states.put ("USIN", "Indiana");
		states.put ("USIA", "Iowa");
		states.put ("USKS", "Kansas");
		states.put ("USKY", "Kentucky");
		states.put ("USLA", "Louisiana");
		states.put ("USME", "Maine");
		states.put ("USMD", "Maryland");
		states.put ("USMA", "Massachusetts");
		states.put ("USMI", "Michigan");
		states.put ("USMN", "Minnesota");
		states.put ("USMS", "Mississippi");
		states.put ("USMO", "Missouri");
		states.put ("USMT", "Montana");
		states.put ("USNE", "Nebraska");
		states.put ("USNV", "Nevada");
		states.put ("USNH", "New Hampshire");
		states.put ("USNJ", "New Jersey");
		states.put ("USNM", "New Mexico");
		states.put ("USNY", "New York");
		states.put ("USNC", "North Carolina");
		states.put ("USND", "North Dakota");
		states.put ("USOH", "Ohio");
		states.put ("USOK", "Oklahoma");
		states.put ("USOR", "Oregon");
		states.put ("USPA", "Pennsylvania");
		states.put ("USRI", "Rhode Island");
		states.put ("USSC", "South Carolina");
		states.put ("USSD", "South Dakota");
		states.put ("USTN", "Tennessee");
		states.put ("USTX", "Texas");
		states.put ("USUT", "Utah");
		states.put ("USVA", "Virginia");
		states.put ("USVT", "Vermont");
		states.put ("USWA", "Washington");
		states.put ("USWV", "West Virginia");
		states.put ("USWI", "Wisconsin");
		states.put ("USWY", "Wyoming");
		return states;
	}

	private static List<NameValuePair> makePrefixList() {
		List<NameValuePair> prefixList = new ArrayList<NameValuePair> (4);
		prefixList.add (new NameValuePair ("Dr", "Dr"));
		prefixList.add (new NameValuePair ("Mr", "Mr"));
		prefixList.add (new NameValuePair ("Mrs", "Mrs"));
		prefixList.add (new NameValuePair ("Ms", "Ms"));
		return prefixList;
	}

	private static List<NameValuePair> makeSuffixList() {
		List<NameValuePair> suffixList = new ArrayList<NameValuePair> (10);
		suffixList.add (new NameValuePair ("Jr", "Jr"));
		suffixList.add (new NameValuePair ("Sr", "Sr"));
		suffixList.add (new NameValuePair ("II", "II"));
		suffixList.add (new NameValuePair ("III", "III"));
		suffixList.add (new NameValuePair ("IV", "IV"));
		suffixList.add (new NameValuePair ("V", "V"));
		suffixList.add (new NameValuePair ("DDS", "DDS"));
		suffixList.add (new NameValuePair ("LPN", "LPN"));
		suffixList.add (new NameValuePair ("MD", "MD"));
		suffixList.add (new NameValuePair ("RN", "RN"));
		return suffixList;
	}
}
