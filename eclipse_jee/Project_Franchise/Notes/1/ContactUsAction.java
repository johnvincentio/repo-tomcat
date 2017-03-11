package com.hertz.herc.franchise.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.hertz.herc.franchise.framework.session.SessionHelper;
import com.hertz.herc.franchise.info.ContactUsInfo;
import com.hertz.herc.franchise.info.CountryStateInfo;
import com.hertz.herc.franchise.info.NameValuePair;
import com.hertz.herc.franchise.util.HercErrorConstants;
import com.hertz.herc.franchise.util.LogBroker;

//TODO; move lists to content

/*
<s:select list="myMap" listKey="key" listValue="value" />
<s:select list="myMap" listValue="getTranslation(value)" />
*/

@Namespace ("/")
public class ContactUsAction extends BaseHeaderAction implements PostExecutable {
	private static final long serialVersionUID = -5116954086599615906L;
	private static Class<?> classRef = ContactUsAction.class;

	private String state;
	private String country;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	private String fruit1 = "apple";
	private String fruit2;
 
//	private String server1;
//	private String server2;
 
	private String language1;
	private String language2;

	private String selectedMonth;
	public String getSelectedMonth () {
		return selectedMonth;
	}
	public void setSelectedMonth (String selectedMonth) {
		this.selectedMonth = selectedMonth;
	}

	private String selectedCountry = "Canada";
	public String getSelectedCountry () {
		return selectedCountry;
	}
	public void setSelectedCountry (String selectedCountry) {
		this.selectedCountry = selectedCountry;
	}
	private String selectedState = "CANL";
	public String getSelectedState () {
		return selectedState;
	}
	public void setSelectedState (String selectedState) {
		this.selectedState = selectedState;
	}

	Map languageMap;
 
	public String getFruit1() {
		return fruit1;
	}
 
	public void setFruit1(String fruit1) {
		this.fruit1 = fruit1;
	}
 
	public String getFruit2() {
		return fruit2;
	}
 
	public void setFruit2(String fruit2) {
		this.fruit2 = fruit2;
	}
 /*
	public String getServer1() {
		return server1;
	}
 
	public void setServer1(String server1) {
		this.server1 = server1;
	}
 
	public String getServer2() {
		return server2;
	}
 
	public void setServer2(String server2) {
		this.server2 = server2;
	}
*/
	public String getLanguage1() {
		return language1;
	}
 
	public void setLanguage1(String language1) {
		this.language1 = language1;
	}
 
	public String getLanguage2() {
		return language2;
	}
 
	public void setLanguage2(String language2) {
		this.language2 = language2;
	}
 
	public Map getLanguageMap() {
		return languageMap;
	}
 
	public void setLanguageMap(Map languageMap) {
		this.languageMap = languageMap;
	}
 
	private ContactUsInfo contactUsInfo = new ContactUsInfo ();

	public ContactUsInfo getContactUsInfo () {
		return contactUsInfo;
	}

	public void setContactUsInfo (ContactUsInfo contactUsInfo) {
		this.contactUsInfo = contactUsInfo;
	}

	private List<NameValuePair> m_prefixList;
	private List<NameValuePair> m_suffixList;
	public List<NameValuePair> getPrefixList() {return m_prefixList;}
	public List<NameValuePair> getSuffixList() {return m_suffixList;}

	private CountryStateInfo m_CountryStateInfo;
	public CountryStateInfo getCountryState() {return m_CountryStateInfo;}

/*
	private HashMap<String, String> m_countryList;
	public HashMap<String, String> getCountryList() {return m_countryList;}

	public static HashMap<String, String> makeCountryList () {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put ("AF", "Afghanistan");
		map.put ("CA", "Canada");
		map.put ("US", "United States");
		return map;
	}


	private HashMap<String, HashMap<String, String>> m_countryStateList;
	public HashMap<String, HashMap<String, String>> getCountryStateList() {return m_countryStateList;}
*/

	/**
	 * Build page lists for the display option
	 * 
	 * @return Action.SUCCESS if successful
	 */
	@Action (value = "contact-us", results = {
			@Result (name = "error", location = "home.contactUs", type = "tiles"), 
			@Result (location = "home.contactUs", type = "tiles")})
	public String display () {
		LogBroker.debug (classRef, ">>> ContactUsAction::display");
		task (6);
		try {
			m_prefixList = makePrefixList (getServletRequest ());
			m_suffixList = makeSuffixList (getServletRequest ());
			m_CountryStateInfo = new CountryStateInfo();

			  languageMap = new HashMap();		
			  languageMap.put("Java", new ArrayList<String>(Arrays.asList("Spring", "Hibernate", "Struts 2")));
		      languageMap.put(".Net", new ArrayList<String>(Arrays.asList("VB.Net", "C#")));
		      languageMap.put("JavaScript", new ArrayList<String>(Arrays.asList("jQuery")));

			//TODO; remove this
			contactUsInfo.setCountry ("CA");
			contactUsInfo.setState ("CANS");

//			m_countryList = makeCountryList();
//			m_countryStateList = makeCountryStateList();
			
			selectedMonth = "02";
		}
		catch (Exception hex) {
			addActionError (getText (HercErrorConstants.FSN_EXCEPTION));
			return ERROR;
		}
/*
 * if contactus information is in session, get it from session
 */
		if (SessionHelper.isContactUsInfo (getServletRequest ())) contactUsInfo = SessionHelper.getContactUsInfo (getServletRequest ());
		LogBroker.debug (classRef, "<<< ContactUsAction::redisplay");
		return SUCCESS;
	}

	/**
	 * Perform execute - send the email
	 * 
	 * @return Action.SUCCESS if successful, else Action.ERROR
	 */
	@Action (value = "contact-us-submit", results = {@Result (name = "input", location = "home.contactUs", type = "tiles"),
			@Result (name = "error", location = "home.contactUs", type = "tiles"),
			@Result (name = "success", location = "/contact-us-confirmation", type = "redirect")})
	public String execute () {
		LogBroker.debug (classRef, ">>> ContactUsAction::execute");
		task (6);
		SessionHelper.updateContactUsInfo (getServletRequest (), contactUsInfo);
		LogBroker.debug (classRef, "<<< ContactUsAction::execute");
		return SUCCESS;
	}

	@Action (value = "contact-us-confirmation", results = {@Result (location = "home.contactUsConfirm", type = "tiles")})
	public String confirm () {
		LogBroker.debug (classRef, ">>> ContactUsAction::confirm");
		task (6);
		LogBroker.debug (classRef, "<<< ContactUsAction::confirm");
		return SUCCESS;
	}

	public void postExecute () {
		LogBroker.debug (classRef, ">>> ContactUsAction::postExecute");
		if (hasErrors ()) {
			LogBroker.debug (classRef, "ContactUsAction::postExecute - hasErrors");
//			redisplay ();
		}
		LogBroker.debug (classRef, "<<< ContactUsAction::postExecute");
	}


	public static HashMap<String, HashMap<String, String>> makeCountryStateList () {
		HashMap<String, HashMap<String, String>> map = new HashMap<String, HashMap<String, String>>();
		HashMap<String, String> states = new HashMap<String, String>();
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
		map.put ("Afghanistan", states);
		
		states = new HashMap<String, String>();
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
		map.put ("Canada", states);
		
		states = new HashMap<String, String>();
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
		map.put ("United States", states);
		return map;
	}


	public static List<NameValuePair> makePrefixList (HttpServletRequest request) {
		List<NameValuePair> prefixList = new ArrayList<NameValuePair> (4);
		prefixList.add (new NameValuePair ("Dr", "Dr"));
		prefixList.add (new NameValuePair ("Mr", "Mr"));
		prefixList.add (new NameValuePair ("Mrs", "Mrs"));
		prefixList.add (new NameValuePair ("Ms", "Ms"));
		return prefixList;
	}

	public static List<NameValuePair> makeSuffixList (HttpServletRequest request) {
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
	
	public static List<NameValuePair> getCountryStateList (HttpServletRequest request) {
		List<NameValuePair> list = new ArrayList<NameValuePair> (98);
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
		list.add (new NameValuePair ("CAAB", "Canada - Alberta"));
		list.add (new NameValuePair ("CABC", "Canada - British Columbia"));
		list.add (new NameValuePair ("CAMB", "Canada - Manitoba"));
		list.add (new NameValuePair ("CANB", "Canada - New Brunswick"));
		list.add (new NameValuePair ("CANL", "Canada - Newfoundland"));
		list.add (new NameValuePair ("CANS", "Canada - Nova Scotia"));
		list.add (new NameValuePair ("CANT", "Canada - Northwest Territories"));
		list.add (new NameValuePair ("CANU", "Canada - Nunavut"));
		list.add (new NameValuePair ("CAON", "Canada - Ontario"));
		list.add (new NameValuePair ("CAPE", "Canada - Prince Edward Island"));
		list.add (new NameValuePair ("CAQC", "Canada - Quebec"));
		list.add (new NameValuePair ("CASK", "Canada - Saskatchewan"));
		list.add (new NameValuePair ("CAYT", "Canada - Yukon"));
		list.add (new NameValuePair ("USAK", "United States - Alaska"));
		list.add (new NameValuePair ("USAL", "United States - Alabama"));
		list.add (new NameValuePair ("USAR", "United States - Arkansas"));
		list.add (new NameValuePair ("USAZ", "United States - Arizona"));
		list.add (new NameValuePair ("USCA", "United States - California"));
		list.add (new NameValuePair ("USCO", "United States - Colorado"));
		list.add (new NameValuePair ("USCT", "United States - Connecticut"));
		list.add (new NameValuePair ("USDC", "United States - District Of Columbia"));
		list.add (new NameValuePair ("USDE", "United States - Delaware"));
		list.add (new NameValuePair ("USFL", "United States - Florida"));
		list.add (new NameValuePair ("USGA", "United States - Georgia"));
		list.add (new NameValuePair ("USHI", "United States - Hawaii"));
		list.add (new NameValuePair ("USIA", "United States - Iowa"));
		list.add (new NameValuePair ("USID", "United States - Idaho"));
		list.add (new NameValuePair ("USIL", "United States - Illinois"));
		list.add (new NameValuePair ("USIN", "United States - Indiana"));
		list.add (new NameValuePair ("USKS", "United States - Kansas"));
		list.add (new NameValuePair ("USKY", "United States - Kentucky"));
		list.add (new NameValuePair ("USLA", "United States - Louisiana"));
		list.add (new NameValuePair ("USMA", "United States - Massachusetts"));
		list.add (new NameValuePair ("USMD", "United States - Maryland"));
		list.add (new NameValuePair ("USME", "United States - Maine"));
		list.add (new NameValuePair ("USMI", "United States - Michigan"));
		list.add (new NameValuePair ("USMN", "United States - Minnesota"));
		list.add (new NameValuePair ("USMO", "United States - Missouri"));
		list.add (new NameValuePair ("USMS", "United States - Mississippi"));
		list.add (new NameValuePair ("USMT", "United States - Montana"));
		list.add (new NameValuePair ("USNC", "United States - North Carolina"));
		list.add (new NameValuePair ("USND", "United States - North Dakota"));
		list.add (new NameValuePair ("USNE", "United States - Nebraska"));
		list.add (new NameValuePair ("USNH", "United States - New Hampshire"));
		list.add (new NameValuePair ("USNJ", "United States - New Jersey"));
		list.add (new NameValuePair ("USNM", "United States - New Mexico"));
		list.add (new NameValuePair ("USNV", "United States - Nevada"));
		list.add (new NameValuePair ("USNY", "United States - New York"));
		list.add (new NameValuePair ("USOH", "United States - Ohio"));
		list.add (new NameValuePair ("USOK", "United States - Oklahoma"));
		list.add (new NameValuePair ("USOR", "United States - Oregon"));
		list.add (new NameValuePair ("USPA", "United States - Pennsylvania"));
		list.add (new NameValuePair ("USRI", "United States - Rhode Island"));
		list.add (new NameValuePair ("USSC", "United States - South Carolina"));
		list.add (new NameValuePair ("USSD", "United States - South Dakota"));
		list.add (new NameValuePair ("USTN", "United States - Tennessee"));
		list.add (new NameValuePair ("USTX", "United States - Texas"));
		list.add (new NameValuePair ("USUT", "United States - Utah"));
		list.add (new NameValuePair ("USVA", "United States - Virginia"));
		list.add (new NameValuePair ("USVT", "United States - Vermont"));
		list.add (new NameValuePair ("USWA", "United States - Washington"));
		list.add (new NameValuePair ("USWI", "United States - Wisconsin"));
		list.add (new NameValuePair ("USWV", "United States - West Virginia"));
		list.add (new NameValuePair ("USWY", "United States - Wyoming"));
		return list;
	}

	public String toString() {
		return "("+getPrefixList()+","+getSuffixList()+")";
	}
}


/*
* <action name="contactUs" class="com.hertz.herc.franchise.action.ContactUsAction" method="display">
* <result name="error" type="tiles">home.contactUs</result>
* <result type="tiles">home.contactUs</result>
* </action>
*/
/*
* @Action(value="contact-us", results={@Result(name="success", location="home.contactUs", type="tiles")})
* public String contactUs () {
* task(6);
* return SUCCESS;
* }
* @Action(value="todo", results={@Result(name="success", location="home.home", type="tiles")})
* public String home_todo () {
* task(7);
* return SUCCESS;
* }
*/
/**
 * Perform redisplay - Repopulate object after failed execute()
 * 
 * @return Action.SUCCESS if success, else Action.ERROR
 */
/*
 * public String redisplay () {
 * LogBroker.debug (classRef, ">>> ContactUsAction::redisplay");
 * try {
 * super.execute ();
 * contactUsListsInfo.setCountryStateList (getCountryStateList(getServletRequest ()));
 * contactUsListsInfo.setPrefixList (getPrefixList (getServletRequest ()));
 * contactUsListsInfo.setSuffixList (getSuffixList (getServletRequest ()));
 * }
 * catch (Exception hex) {
 * addActionError (getText (HercErrorConstants.FSN_EXCEPTION));
 * return ERROR;
 * }
 * LogBroker.debug (classRef, "<<< ContactUsAction::redisplay");
 * return SUCCESS;
 * }
 */


/*
 * @Result(name = "success", location = "http://struts.apache.org", type = "redirect")
 * @Result(name="success", params={"contact-us-confirmation", "resend"}, type="redirectAction")
 * "contact-us-confirmation"
 * @Result(name="input", type="redirectAction", params = {"actionName" , "resend"})
 * <action name="contactUsSubmit" class="com.hertz.herc.franchise.action.ContactUsAction" method="execute">
 * <result name="success" type="chain">
 * <param name="actionName">contactUsConfirm</param>
 * <param name="namespace">/home</param>
 * </result>
 * <result name="input" type="tiles">home.contactUs</result>
 * <result name="error" type="tiles">home.contactUs</result>
 * </action>
 * <action name="contactUsConfirm">
 * <result type="tiles">home.contactUsConfirm</result>
 * </action>
 */
/*
 * public class HelloAction extends ActionSupport {
 * @Action("foo")
 * public String foo() {
 * return "bar";
 * }
 * @Action("foo-bar")
 * public String bar() {
 * return SUCCESS;
 * }
 * }
 */
