package com.hertz.herc.franchise.info;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class CountryStateInfo implements Serializable {
	private static final long serialVersionUID = 6470283684301174173L;

	private HashMap<String, LinkedHashMap<String, String>> m_countryList = new HashMap<String, LinkedHashMap<String, String>> ();
	public HashMap<String, LinkedHashMap<String, String>> getCountryList() {return m_countryList;}

	public CountryStateInfo() {
		m_countryList.put ("United States", makeUSCountryStateList());
		m_countryList.put ("Canada", makeCACountryStateList());
		m_countryList.put ("Afghanistan", makeAFCountryStateList());
	}

/*
	private LinkedHashMap<String, String> m_countryList = new LinkedHashMap<String, String>();
	public LinkedHashMap<String, String> getCountryList() {return m_countryList;}

	private HashMap<String, LinkedHashMap<String, String>> m_stateList = new HashMap<String, LinkedHashMap<String, String>> ();
	public HashMap<String, LinkedHashMap<String, String>> getStateList() {return m_stateList;}

	public CountryStateInfo() {
		m_countryList.put ("US", "United States");
		m_countryList.put ("CA", "Canada");
		m_countryList.put ("AF", "Afghanistan");
		m_stateList = makeCountryStateList ();
	}

	List<NameValuePair> m_countryList = new ArrayList<NameValuePair> (3);
	List<NameValuePair> m_stateList = new ArrayList<NameValuePair> (3);

	public List<NameValuePair> getCountryList() {return m_countryList;}
	public List<NameValuePair> getStateList() {return m_stateList;}

	public CountryStateInfo() {
		m_countryList.add (new NameValuePair ("US", "United States"));
		m_countryList.add (new NameValuePair ("AF", "Afghanistan"));
		m_countryList.add (new NameValuePair ("CA", "Canada"));

		m_stateList.add (new NameValuePair ("US",  makeUSList()));
		m_stateList.add (new NameValuePair ("AF",  makeAFList()));
		m_stateList.add (new NameValuePair ("CA",  makeCAList()));

	}
*/
	public static LinkedHashMap<String, String> makeAFCountryStateList () {
		LinkedHashMap<String, String> states = new LinkedHashMap<String, String>();
		states.put ("AFBD", "Badakhshan");
		states.put ("AFBG", "Badghis");
		states.put ("AFBK", "Balkh");
		states.put ("AFBL", "Baghlan");
		states.put ("AFBM", "Bamyan");
		states.put ("AFDK", "Daykundi");
		states.put ("AFFB", "Faryab");
		states.put ("AFFH", "Farah");
		states.put ("AFGR", "Ghor");
		states.put ("AFGZ", "Ghazni");
		states.put ("AFHM", "Helmand");
		states.put ("AFHR", "Herat");
		states.put ("AFJW", "Jowzjan");
		states.put ("AFKB", "Kabul");
		states.put ("AFKD", "Kandahar");
		states.put ("AFKP", "Kapisa");
		states.put ("AFKR", "Kunar");
		states.put ("AFKT", "Khost");
		states.put ("AFKZ", "Kunduz");
		states.put ("AFLA", "Laghman");
		states.put ("AFLW", "Logar");
		states.put ("AFNG", "Nangarhar");
		states.put ("AFNM", "Nimruz");
		states.put ("AFNR", "Nuristan");
		states.put ("AFOZ", "Oru-zga-n");
		states.put ("AFPJ", "Panjshir");
		states.put ("AFPK", "Paktika");
		states.put ("AFPT", "Paktia");
		states.put ("AFPV", "Parwan");
		states.put ("AFSM", "Samangan");
		states.put ("AFSP", "Sar-e Pol");
		states.put ("AFTK", "Takhar");
		states.put ("AFVR", "Wardak");
		states.put ("AFZB", "Zabul");
		return states;
	}

	public static LinkedHashMap<String, String> makeCACountryStateList () {
		LinkedHashMap<String, String> states = new LinkedHashMap<String, String>();
		states = new LinkedHashMap<String, String>();
		states.put ("CAAB", "Alberta");
		states.put ("CABC", "British Columbia");
		states.put ("CAMB", "Manitoba");
		states.put ("CANB", "New Brunswick");
		states.put ("CANL", "Newfoundland");
		states.put ("CANS", "Nova Scotia");
		states.put ("CANT", "Northwest Territories");
		states.put ("CANU", "Nunavut");
		states.put ("CAON", "Ontario");
		states.put ("CAPE", "Prince Edward Island");
		states.put ("CAQC", "Quebec");
		states.put ("CASK", "Saskatchewan");
		states.put ("CAYT", "Yukon");
		return states;
	}

	public static LinkedHashMap<String, String> makeUSCountryStateList () {
		LinkedHashMap<String, String> states = new LinkedHashMap<String, String>();
		states = new LinkedHashMap<String, String>();
		states.put ("USAK", "Alaska");
		states.put ("USAL", "Alabama");
		states.put ("USAR", "Arkansas");
		states.put ("USAZ", "Arizona");
		states.put ("USCA", "California");
		states.put ("USCO", "Colorado");
		states.put ("USCT", "Connecticut");
		states.put ("USDC", "District Of Columbia");
		states.put ("USDE", "Delaware");
		states.put ("USFL", "Florida");
		states.put ("USGA", "Georgia");
		states.put ("USHI", "Hawaii");
		states.put ("USIA", "Iowa");
		states.put ("USID", "Idaho");
		states.put ("USIL", "Illinois");
		states.put ("USIN", "Indiana");
		states.put ("USKS", "Kansas");
		states.put ("USKY", "Kentucky");
		states.put ("USLA", "Louisiana");
		states.put ("USMA", "Massachusetts");
		states.put ("USMD", "Maryland");
		states.put ("USME", "Maine");
		states.put ("USMI", "Michigan");
		states.put ("USMN", "Minnesota");
		states.put ("USMO", "Missouri");
		states.put ("USMS", "Mississippi");
		states.put ("USMT", "Montana");
		states.put ("USNC", "North Carolina");
		states.put ("USND", "North Dakota");
		states.put ("USNE", "Nebraska");
		states.put ("USNH", "New Hampshire");
		states.put ("USNJ", "New Jersey");
		states.put ("USNM", "New Mexico");
		states.put ("USNV", "Nevada");
		states.put ("USNY", "New York");
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
		states.put ("USWI", "Wisconsin");
		states.put ("USWV", "West Virginia");
		states.put ("USWY", "Wyoming");
		return states;
	}
	private List<NameValuePair> makeCAList() {
		List<NameValuePair> list = new ArrayList<NameValuePair> (13);
		list.add (new NameValuePair ("CAAB", "Alberta"));
		list.add (new NameValuePair ("CABC", "British Columbia"));
		list.add (new NameValuePair ("CAMB", "Manitoba"));
		list.add (new NameValuePair ("CANB", "New Brunswick"));
		list.add (new NameValuePair ("CANL", "Newfoundland"));
		list.add (new NameValuePair ("CANS", "Nova Scotia"));
		list.add (new NameValuePair ("CANT", "Northwest Territories"));
		list.add (new NameValuePair ("CANU", "Nunavut"));
		list.add (new NameValuePair ("CAON", "Ontario"));
		list.add (new NameValuePair ("CAPE", "Prince Edward Island"));
		list.add (new NameValuePair ("CAQC", "Quebec"));
		list.add (new NameValuePair ("CASK", "Saskatchewan"));
		list.add (new NameValuePair ("CAYT", "Yukon"));
		return list;
	}

	private List<NameValuePair> makeUSList() {
		List<NameValuePair> list = new ArrayList<NameValuePair> (51);
		list.add (new NameValuePair ("USAK", "Alaska"));
		list.add (new NameValuePair ("USAL", "Alabama"));
		list.add (new NameValuePair ("USAR", "Arkansas"));
		list.add (new NameValuePair ("USAZ", "Arizona"));
		list.add (new NameValuePair ("USCA", "California"));
		list.add (new NameValuePair ("USCO", "Colorado"));
		list.add (new NameValuePair ("USCT", "Connecticut"));
		list.add (new NameValuePair ("USDC", "District Of Columbia"));
		list.add (new NameValuePair ("USDE", "Delaware"));
		list.add (new NameValuePair ("USFL", "Florida"));
		list.add (new NameValuePair ("USGA", "Georgia"));
		list.add (new NameValuePair ("USHI", "Hawaii"));
		list.add (new NameValuePair ("USIA", "Iowa"));
		list.add (new NameValuePair ("USID", "Idaho"));
		list.add (new NameValuePair ("USIL", "Illinois"));
		list.add (new NameValuePair ("USIN", "Indiana"));
		list.add (new NameValuePair ("USKS", "Kansas"));
		list.add (new NameValuePair ("USKY", "Kentucky"));
		list.add (new NameValuePair ("USLA", "Louisiana"));
		list.add (new NameValuePair ("USMA", "Massachusetts"));
		list.add (new NameValuePair ("USMD", "Maryland"));
		list.add (new NameValuePair ("USME", "Maine"));
		list.add (new NameValuePair ("USMI", "Michigan"));
		list.add (new NameValuePair ("USMN", "Minnesota"));
		list.add (new NameValuePair ("USMO", "Missouri"));
		list.add (new NameValuePair ("USMS", "Mississippi"));
		list.add (new NameValuePair ("USMT", "Montana"));
		list.add (new NameValuePair ("USNC", "North Carolina"));
		list.add (new NameValuePair ("USND", "North Dakota"));
		list.add (new NameValuePair ("USNE", "Nebraska"));
		list.add (new NameValuePair ("USNH", "New Hampshire"));
		list.add (new NameValuePair ("USNJ", "New Jersey"));
		list.add (new NameValuePair ("USNM", "New Mexico"));
		list.add (new NameValuePair ("USNV", "Nevada"));
		list.add (new NameValuePair ("USNY", "New York"));
		list.add (new NameValuePair ("USOH", "Ohio"));
		list.add (new NameValuePair ("USOK", "Oklahoma"));
		list.add (new NameValuePair ("USOR", "Oregon"));
		list.add (new NameValuePair ("USPA", "Pennsylvania"));
		list.add (new NameValuePair ("USRI", "Rhode Island"));
		list.add (new NameValuePair ("USSC", "South Carolina"));
		list.add (new NameValuePair ("USSD", "South Dakota"));
		list.add (new NameValuePair ("USTN", "Tennessee"));
		list.add (new NameValuePair ("USTX", "Texas"));
		list.add (new NameValuePair ("USUT", "Utah"));
		list.add (new NameValuePair ("USVA", "Virginia"));
		list.add (new NameValuePair ("USVT", "Vermont"));
		list.add (new NameValuePair ("USWA", "Washington"));
		list.add (new NameValuePair ("USWI", "Wisconsin"));
		list.add (new NameValuePair ("USWV", "West Virginia"));
		list.add (new NameValuePair ("USWY", "Wyoming"));
		return list;
	}

	private List<NameValuePair> makeAFList() {
		List<NameValuePair> list = new ArrayList<NameValuePair> (34);
		list.add (new NameValuePair ("AFBD", "Afghanistan - Badakhshan"));
		list.add (new NameValuePair ("AFBG", "Afghanistan - Badghis"));
		list.add (new NameValuePair ("AFBK", "Afghanistan - Balkh"));
		list.add (new NameValuePair ("AFBL", "Afghanistan - Baghlan"));
		list.add (new NameValuePair ("AFBM", "Afghanistan - Bamyan"));
		list.add (new NameValuePair ("AFDK", "Afghanistan - Daykundi"));
		list.add (new NameValuePair ("AFFB", "Afghanistan - Faryab"));
		list.add (new NameValuePair ("AFFH", "Afghanistan - Farah"));
		list.add (new NameValuePair ("AFGR", "Afghanistan - Ghor"));
		list.add (new NameValuePair ("AFGZ", "Afghanistan - Ghazni"));
		list.add (new NameValuePair ("AFHM", "Afghanistan - Helmand"));
		list.add (new NameValuePair ("AFHR", "Afghanistan - Herat"));
		list.add (new NameValuePair ("AFJW", "Afghanistan - Jowzjan"));
		list.add (new NameValuePair ("AFKB", "Afghanistan - Kabul"));
		list.add (new NameValuePair ("AFKD", "Afghanistan - Kandahar"));
		list.add (new NameValuePair ("AFKP", "Afghanistan - Kapisa"));
		list.add (new NameValuePair ("AFKR", "Afghanistan - Kunar"));
		list.add (new NameValuePair ("AFKT", "Afghanistan - Khost"));
		list.add (new NameValuePair ("AFKZ", "Afghanistan - Kunduz"));
		list.add (new NameValuePair ("AFLA", "Afghanistan - Laghman"));
		list.add (new NameValuePair ("AFLW", "Afghanistan - Logar"));
		list.add (new NameValuePair ("AFNG", "Afghanistan - Nangarhar"));
		list.add (new NameValuePair ("AFNM", "Afghanistan - Nimruz"));
		list.add (new NameValuePair ("AFNR", "Afghanistan - Nuristan"));
		list.add (new NameValuePair ("AFOZ", "Afghanistan - Oru-zga-n"));
		list.add (new NameValuePair ("AFPJ", "Afghanistan - Panjshir"));
		list.add (new NameValuePair ("AFPK", "Afghanistan - Paktika"));
		list.add (new NameValuePair ("AFPT", "Afghanistan - Paktia"));
		list.add (new NameValuePair ("AFPV", "Afghanistan - Parwan"));
		list.add (new NameValuePair ("AFSM", "Afghanistan - Samangan"));
		list.add (new NameValuePair ("AFSP", "Afghanistan - Sar-e Pol"));
		list.add (new NameValuePair ("AFTK", "Afghanistan - Takhar"));
		list.add (new NameValuePair ("AFVR", "Afghanistan - Wardak"));
		list.add (new NameValuePair ("AFZB", "Afghanistan - Zabul"));
		return list;
	}
}
/*
	public static HashMap<String, LinkedHashMap<String, String>> makeCountryStateList () {
		HashMap<String, LinkedHashMap<String, String>> map = new HashMap<String, LinkedHashMap<String, String>>();
		LinkedHashMap<String, String> states = new LinkedHashMap<String, String>();
		states.put ("AFBD", "Badakhshan");
		states.put ("AFBG", "Badghis");
		states.put ("AFBK", "Balkh");
		states.put ("AFBL", "Baghlan");
		states.put ("AFBM", "Bamyan");
		states.put ("AFDK", "Daykundi");
		states.put ("AFFB", "Faryab");
		states.put ("AFFH", "Farah");
		states.put ("AFGR", "Ghor");
		states.put ("AFGZ", "Ghazni");
		states.put ("AFHM", "Helmand");
		states.put ("AFHR", "Herat");
		states.put ("AFJW", "Jowzjan");
		states.put ("AFKB", "Kabul");
		states.put ("AFKD", "Kandahar");
		states.put ("AFKP", "Kapisa");
		states.put ("AFKR", "Kunar");
		states.put ("AFKT", "Khost");
		states.put ("AFKZ", "Kunduz");
		states.put ("AFLA", "Laghman");
		states.put ("AFLW", "Logar");
		states.put ("AFNG", "Nangarhar");
		states.put ("AFNM", "Nimruz");
		states.put ("AFNR", "Nuristan");
		states.put ("AFOZ", "Oru-zga-n");
		states.put ("AFPJ", "Panjshir");
		states.put ("AFPK", "Paktika");
		states.put ("AFPT", "Paktia");
		states.put ("AFPV", "Parwan");
		states.put ("AFSM", "Samangan");
		states.put ("AFSP", "Sar-e Pol");
		states.put ("AFTK", "Takhar");
		states.put ("AFVR", "Wardak");
		states.put ("AFZB", "Zabul");
		map.put ("AF", states);
		
		states = new LinkedHashMap<String, String>();
		states.put ("CAAB", "Alberta");
		states.put ("CABC", "British Columbia");
		states.put ("CAMB", "Manitoba");
		states.put ("CANB", "New Brunswick");
		states.put ("CANL", "Newfoundland");
		states.put ("CANS", "Nova Scotia");
		states.put ("CANT", "Northwest Territories");
		states.put ("CANU", "Nunavut");
		states.put ("CAON", "Ontario");
		states.put ("CAPE", "Prince Edward Island");
		states.put ("CAQC", "Quebec");
		states.put ("CASK", "Saskatchewan");
		states.put ("CAYT", "Yukon");
		map.put ("CA", states);
		
		states = new LinkedHashMap<String, String>();
		states.put ("USAK", "Alaska");
		states.put ("USAL", "Alabama");
		states.put ("USAR", "Arkansas");
		states.put ("USAZ", "Arizona");
		states.put ("USCA", "California");
		states.put ("USCO", "Colorado");
		states.put ("USCT", "Connecticut");
		states.put ("USDC", "District Of Columbia");
		states.put ("USDE", "Delaware");
		states.put ("USFL", "Florida");
		states.put ("USGA", "Georgia");
		states.put ("USHI", "Hawaii");
		states.put ("USIA", "Iowa");
		states.put ("USID", "Idaho");
		states.put ("USIL", "Illinois");
		states.put ("USIN", "Indiana");
		states.put ("USKS", "Kansas");
		states.put ("USKY", "Kentucky");
		states.put ("USLA", "Louisiana");
		states.put ("USMA", "Massachusetts");
		states.put ("USMD", "Maryland");
		states.put ("USME", "Maine");
		states.put ("USMI", "Michigan");
		states.put ("USMN", "Minnesota");
		states.put ("USMO", "Missouri");
		states.put ("USMS", "Mississippi");
		states.put ("USMT", "Montana");
		states.put ("USNC", "North Carolina");
		states.put ("USND", "North Dakota");
		states.put ("USNE", "Nebraska");
		states.put ("USNH", "New Hampshire");
		states.put ("USNJ", "New Jersey");
		states.put ("USNM", "New Mexico");
		states.put ("USNV", "Nevada");
		states.put ("USNY", "New York");
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
		states.put ("USWI", "Wisconsin");
		states.put ("USWV", "West Virginia");
		states.put ("USWY", "Wyoming");
		map.put ("US", states);
		return map;
	}
*/
