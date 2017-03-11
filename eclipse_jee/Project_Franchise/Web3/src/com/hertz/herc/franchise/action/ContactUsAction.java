package com.hertz.herc.franchise.action;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.hertz.herc.franchise.framework.session.SessionHelper;
import com.hertz.herc.franchise.info.ContactUsInfo;
import com.hertz.herc.franchise.info.NameValuePair;
import com.hertz.herc.franchise.util.CountryHelper;
import com.hertz.herc.franchise.util.HercErrorConstants;
import com.hertz.herc.franchise.util.LogBroker;

@Namespace ("/")
public class ContactUsAction extends BaseHeaderAction implements PostExecutable {
	private static final long serialVersionUID = -5116954086599615906L;
	private static Class<?> classRef = ContactUsAction.class;

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

	private HashMap<String, LinkedHashMap<String, String>> m_CountryStateInfo;
	public HashMap<String, LinkedHashMap<String, String>> getCountryState() {return m_CountryStateInfo;}

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
			m_prefixList = CountryHelper.getPrefixList();
			m_suffixList = CountryHelper.getSuffixList();
			m_CountryStateInfo = CountryHelper.getCountryList ();

			//TODO; remove this
			contactUsInfo.setCountry ("Canada");
			contactUsInfo.setState ("CANS");
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
	@Action (value = "contactUsSubmit", results = {
			@Result (name = "input", location = "home.contactUs", type = "tiles"),
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
*/



