
package com.hertz.herc.franchise.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hertz.herc.franchise.framework.ContactUsInfo;
import com.hertz.herc.franchise.framework.ContactUsListsInfo;
import com.hertz.herc.franchise.framework.NameValuePair;
import com.hertz.herc.franchise.framework.session.SessionHelper;
import com.hertz.herc.franchise.util.HercErrorConstants;
import com.hertz.herc.franchise.util.LogBroker;
import com.opensymphony.xwork2.Action;

//TODO; move lists to content

public class ContactUsAct_jv_ion extends BaseHeaderAction implements PostExecutable {
	private static final long serialVersionUID = -5116954086599615906L;
	private static Class<?> classRef = ContactUsAct_jv_ion.class;

	private ContactUsInfo contactUsInfo = new ContactUsInfo ();

	public ContactUsInfo getContactUsInfo () {
		return contactUsInfo;
	}

	public void setContactUsInfo (ContactUsInfo contactUsInfo) {
		this.contactUsInfo = contactUsInfo;
	}

	private ContactUsListsInfo contactUsListsInfo = new ContactUsListsInfo ();

	public ContactUsListsInfo getContactUsListsInfo () {
		return contactUsListsInfo;
	}

	public void setContactUsListsInfo (ContactUsListsInfo contactUsListsInfo) {
		this.contactUsListsInfo = contactUsListsInfo;
	}

	/**
	 * Build page lists for the display option
	 * 
	 * @return Action.SUCCESS if successful
	 */
	public String display () {
		LogBroker.debug (classRef, ">>> ContactUsAction::display");
		String result = redisplay ();
/*
 * if contactus information is in session, get it from session
 */
		if (SessionHelper.isContactUsInfo (getServletRequest ())) contactUsInfo = SessionHelper.getContactUsInfo (getServletRequest ());
		return result;
	}

	/**
	 * Perform redisplay - Repopulate object after failed execute()
	 * 
	 * @return Action.SUCCESS if success, else Action.ERROR
	 */
	public String redisplay () {
		LogBroker.debug (classRef, ">>> ContactUsAction::redisplay");
		try {
			super.execute ();
			contactUsListsInfo.setCountryStateList (getCountryStateList(getServletRequest ()));
			contactUsListsInfo.setPrefixList (getPrefixList (getServletRequest ()));
			contactUsListsInfo.setSuffixList (getSuffixList (getServletRequest ()));
		}
		catch (Exception hex) {
			addActionError (getText (HercErrorConstants.FSN_EXCEPTION));
			return Action.ERROR;
		}
		LogBroker.debug (classRef, "<<< ContactUsAction::redisplay");
		return Action.SUCCESS;
	}

	/**
	 * Perform execute - send the email
	 * 
	 * @return Action.SUCCESS if successful, else Action.ERROR
	 */
	public String execute () {
		LogBroker.debug (classRef, ">>> ContactUsAction::execute");
//		super.execute ();
		SessionHelper.updateContactUsInfo (getServletRequest (), contactUsInfo);
		LogBroker.debug (classRef, "<<< ContactUsAction::execute");
		return Action.SUCCESS;
	}

	/**
	 * Perform tasks required after execute()
	 */
	public void postExecute () {
		LogBroker.debug (classRef, ">>> ContactUsAction::postExecute");
		if (hasErrors ()) {
			LogBroker.debug (classRef, "ContactUsAction::postExecute - hasErrors");
			redisplay ();
		}
		LogBroker.debug (classRef, "<<< ContactUsAction::postExecute");
	}
    public static List<NameValuePair> getPrefixList(HttpServletRequest request) {
    	List<NameValuePair> prefixList = new ArrayList<NameValuePair>(4);
    	prefixList.add(new NameValuePair("Dr", "Dr"));
    	prefixList.add(new NameValuePair("Mr", "Mr"));
    	prefixList.add(new NameValuePair("Mrs", "Mrs"));
    	prefixList.add(new NameValuePair("Ms", "Ms"));
    	return prefixList;
    }

    public static List<NameValuePair> getSuffixList(HttpServletRequest request) {
    	List<NameValuePair> suffixList = new ArrayList<NameValuePair>(10);
    	suffixList.add(new NameValuePair("Jr", "Jr"));
    	suffixList.add(new NameValuePair("Sr", "Sr"));
    	suffixList.add(new NameValuePair("II", "II"));
    	suffixList.add(new NameValuePair("III", "III"));
    	suffixList.add(new NameValuePair("IV", "IV"));
    	suffixList.add(new NameValuePair("V", "V"));
    	suffixList.add(new NameValuePair("DDS", "DDS"));
    	suffixList.add(new NameValuePair("LPN", "LPN"));
    	suffixList.add(new NameValuePair("MD", "MD"));
    	suffixList.add(new NameValuePair("RN", "RN"));
    	return suffixList;
    }
    public static List<NameValuePair> getCountryStateList(HttpServletRequest request) {
    	List<NameValuePair> list = new ArrayList<NameValuePair>(98);
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
}
