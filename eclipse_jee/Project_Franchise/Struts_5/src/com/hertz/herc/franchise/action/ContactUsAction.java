package com.hertz.herc.franchise.action;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.hertz.herc.franchise.info.NameValuePair;
import com.hertz.herc.franchise.util.ListsHelper;
import com.hertz.herc.franchise.util.LogBroker;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.ExpressionValidator;
import com.opensymphony.xwork2.validator.annotations.FieldExpressionValidator;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

/*
Other validations:
@IntRangeFieldValidator(type = ValidatorType.FIELD, min = "6", max = "10", message = "bar must be between ${min} and ${max}, current value is ${bar}.")
@DateRangeFieldValidator(type = ValidatorType.SIMPLE, fieldName = "datefield", min = "-1", max = "99", message = "bar must be between ${min} and ${max}, current value is ${bar}.")},
@RequiredFieldValidator(type = ValidatorType.FIELD, message = "You must enter a value for bar.")
@UrlValidator(type = ValidatorType.SIMPLE, fieldName = "hreflocation", message = "You must enter a value for email.")}
@ExpressionValidator(expression = "foo > 1", message = "Foo must be greater than Bar 1. Foo = ${foo}, Bar = ${bar}.")
*/

@Namespace ("/")
public class ContactUsAction extends BaseHeaderAction implements Preparable, PostExecutable {
	private static final long serialVersionUID = -5116954086599615906L;
	private static Class<?> classRef = ContactUsAction.class;

	private String prefix;
	private String firstName;
	private String middleName;
	private String lastName;
	private String suffix;
	private String businessName;
	private String address1;
	private String address2;
	private String city;
	private String zip;
	private String state;
	private String country;
	private String phone;
	private String fax;
	private String email1;
	private String email2;
	private String comments;

	public String getPrefix() {return prefix;}
	public void setPrefix(String prefix) {this.prefix = prefix;}

	public String getFirstName() {return firstName;}
	@RequiredStringValidator(type=ValidatorType.FIELD, key = "validate.firstName.required")
	@RegexFieldValidator(regex = "[-A-Za-z .']+", key = "validate.firstName")
	public void setFirstName(String firstName) {this.firstName = firstName;}

	public String getMiddleName() {return middleName;}
	@RegexFieldValidator(regex = "[-A-Za-z .']+", key = "validate.firstName")
	public void setMiddleName(String middleName) {this.middleName = middleName;}

	public String getLastName() {return lastName;}
	@RequiredStringValidator(type=ValidatorType.FIELD, key = "validate.lastName.required")
	@RegexFieldValidator(regex = "[-A-Za-z .']+", key = "validate.firstName")
	public void setLastName(String lastName) {this.lastName = lastName;}

	public String getSuffix() {return suffix;}
	public void setSuffix(String suffix) {this.suffix = suffix;}

	public String getBusinessName() {return businessName;}
	public void setBusinessName(String businessName) {this.businessName = businessName;}

	public String getAddress1() {return address1;}
	@RequiredStringValidator(type=ValidatorType.FIELD, key = "validate.address1.required")
	public void setAddress1(String address1) {this.address1 = address1;}

	public String getAddress2() {return address2;}
	public void setAddress2(String address2) {this.address2 = address2;}

	public String getCity() {return city;}
	@RequiredStringValidator(type=ValidatorType.FIELD, key = "validate.city.required")
	@RegexFieldValidator(regex = "[-A-Za-z0-9 .'-_]+", key = "validate.firstName")
	public void setCity(String city) {this.city = city;}

	public String getState() {return state;}
	@RequiredStringValidator(type=ValidatorType.FIELD, key = "validate.state.required")
	public void setState(String state) {this.state = state;}

	public String getCountry() {return country;}
	@RequiredStringValidator(type=ValidatorType.FIELD, key = "validate.country.required")
	public void setCountry(String country) {this.country = country;}

	public String getZip() {return zip;}
	@RequiredStringValidator(type=ValidatorType.FIELD, key = "validate.zip.required")
	@RegexFieldValidator(regex = "[-A-Za-z0-9 .']+", key = "validate.firstName")
	public void setZip(String zip) {this.zip = zip;}

	public String getEmail1() {return email1;}
	@RequiredStringValidator(type=ValidatorType.FIELD, key = "validate.email.required")
	@EmailValidator(key = "validate.email.format")
	public void setEmail1(String email1) {this.email1 = email1;}

	public String getEmail2() {return email2;}
	@EmailValidator(key = "validate.email.format")
	public void setEmail2(String email2) {this.email2 = email2;}

	public String getPhone() {return phone;}
	@RequiredStringValidator(type=ValidatorType.FIELD, key = "validate.phone.required")
	@StringLengthFieldValidator(type=ValidatorType.FIELD, key = "validate.phone", minLength="10", maxLength="30", trim = true)
	@RegexFieldValidator(regex = "[-A-Za-z0-9 +()]+", key = "validate.phone")
//	@CustomValidator(type = "phoneNumberFieldValidator", key = "validate.phone.format")
	public void setPhone(String phone) {this.phone = phone;}

	public String getFax() {return fax;}
	@StringLengthFieldValidator(type=ValidatorType.FIELD, key = "validate.fax", minLength="10", maxLength="30", trim = true)
	@RegexFieldValidator(regex = "[-A-Za-z0-9 +()]+", key = "validate.fax")
	public void setFax(String fax) {this.fax = fax;}

	public String getComments() {return comments;}
	@FieldExpressionValidator(
			fieldName = "comments",
			expression = "comments != 'abcd'", 
			key = "comments.content")
	public void setComments(String comments) {this.comments = comments;}
	
	private List<NameValuePair> m_prefixList;
	private List<NameValuePair> m_suffixList;
	public List<NameValuePair> getPrefixList() {return m_prefixList;}
	public List<NameValuePair> getSuffixList() {return m_suffixList;}

	private HashMap<String, LinkedHashMap<String, String>> m_CountryStateInfo;
	public HashMap<String, LinkedHashMap<String, String>> getCountryState() {return m_CountryStateInfo;}

	@SkipValidation
	public void prepare() throws Exception {
		LogBroker.debug (classRef, ">>> ContactUsAction::prepare");
		try {
			m_prefixList = ListsHelper.getPrefixList();
			m_suffixList = ListsHelper.getSuffixList();
			m_CountryStateInfo = ListsHelper.getCountryList ();
			task (6);
		}
		catch (Exception hex) {
			addActionError (getText ("errors.contactus"));
		}
		LogBroker.debug (classRef, "<<< ContactUsAction::prepare");
	}

	/**
	 * Build page lists for the display option
	 * 
	 * @return Action.SUCCESS if successful
	 */
	@SkipValidation
	@Action (value = "contact-us", results = {@Result (location = "home.contactUs", type = "tiles")})
	public String display () {
		LogBroker.debug (classRef, "--- ContactUsAction::display");
		return SUCCESS;
	}

/*
	public void validate() {System.out.println ("--- validate");}
*/
	/**
	 * Perform execute - send the email
	 * 
	 * @return Action.SUCCESS if successful, else Action.ERROR
	 */
	@ExpressionValidator(expression = "firstName != lastName", key = "expression.names.different")
	@Action (value = "contactUsSubmit", results = {
			@Result (name = "input", location = "home.contactUs", type = "tiles"),
			@Result (name = "error", location = "home.contactUs", type = "tiles"),
			@Result (name = "success", location = "/contact-us-confirmation", type = "redirect")})
	public String execute () {
		LogBroker.debug (classRef, ">>> ContactUsAction::execute");
		if (null != getEmail1() && getEmail1().trim().length () > 0) {
			if (null == getEmail2() || getEmail2().trim().length () < 1) {
				addFieldError ("email2", getText ("validate.email.required"));
			}
			if (null != getEmail2() && (! getEmail2().equals(getEmail1()))) {
				addFieldError ("email2", getText ("validate.email.different"));
			}
		}
		if (hasErrors()) {
//			addActionError (getText ("errors.contactus"));
			return ERROR;
		}
		LogBroker.debug (classRef, "<<< ContactUsAction::execute");
		return SUCCESS;
	}

	@SkipValidation
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
	public void show() {
		System.out.println (prefix+", "+firstName+", "+middleName+", "+lastName+", "+suffix+", "+businessName+", "
			+address1+", "+address2+", "+city+", "+zip+", "+state+", "+country+", "+phone+", "+fax+", "+email1+", "+email2+", "+comments);
	}
}


