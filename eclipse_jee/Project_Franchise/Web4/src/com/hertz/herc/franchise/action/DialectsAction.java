package com.hertz.herc.franchise.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.hertz.herc.franchise.util.HercErrorConstants;
import com.hertz.herc.franchise.util.LogBroker;
import com.opensymphony.xwork2.Preparable;

@Namespace ("/")
public class DialectsAction extends BaseHeaderAction implements Preparable, PostExecutable {
	private static final long serialVersionUID = -4175135068510685935L;
	private static Class<?> classRef = DialectsAction.class;

	private String myLocale;
	public String getMyLocale() {return myLocale;}
	public void setMyLocale (String s) {myLocale = s;}

	@SkipValidation
	public void prepare() throws Exception {
		LogBroker.debug (classRef, ">>> DialectsAction::prepare");
		try {
//			m_prefixList = CountryHelper.getPrefixList();
//			m_suffixList = CountryHelper.getSuffixList();
//			m_CountryStateInfo = CountryHelper.getCountryList ();
		}
		catch (Exception hex) {
			addActionError (getText (HercErrorConstants.FSN_EXCEPTION));
		}
		LogBroker.debug (classRef, "<<< DialectsAction::prepare");
	}

	@SkipValidation
	@Action (value = "dialects", results = {@Result (location = "home.dialects", type = "tiles")})
	public String display () {
		LogBroker.debug (classRef, "--- DialectsAction::display");
		task (8);
		return SUCCESS;
	}

	/**
	 * Perform execute - send the email
	 * 
	 * @return Action.SUCCESS if successful, else Action.ERROR
	 */
	@Action (value = "dialectsSubmit", results = {
			@Result (name = "input", location = "home.dialects", type = "tiles"),
			@Result (name = "error", location = "home.dialects", type = "tiles"),
			@Result (name = "success", location = "/equipment-rental-franchise-opportunities", type = "redirect")})
	public String execute () {
		LogBroker.debug (classRef, ">>> DialectsAction::execute");
		System.out.println ("myLocale "+myLocale);
		if (hasErrors()) {
//			addActionError (getText (HercErrorConstants.FSN_EXCEPTION));
			return ERROR;
		}
		LogBroker.debug (classRef, "<<< DialectsAction::execute");
		return SUCCESS;
	}

	@SkipValidation
	public void postExecute () {
		LogBroker.debug (classRef, ">>> DialectsAction::postExecute");
		if (hasErrors ()) {
			LogBroker.debug (classRef, "DialectsAction::postExecute - hasErrors");
//			redisplay ();
		}
		LogBroker.debug (classRef, "<<< DialectsAction::postExecute");
	}
}
