
package com.hertz.herc.franchise.info;

import java.io.Serializable;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

/**
 * Handle contact us
 * 
 * @author John Vincent
 */

public class ContactUsInfo implements Serializable {

	private static final long serialVersionUID = 8137514589452484011L;
	private String prefix;
	private String firstName;
	private String middleName;
	private String lastName;
	private String suffix;
	private String title;
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
	
	public String getAddress1() {
		return address1;
	}

	@RequiredStringValidator(type= ValidatorType.FIELD, message = "The name is required.")
	public void setAddress1(String address1) {
		System.out.println ("--- ContactUsInfo::setAddress1; address1 :"+address1+":");
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	@RequiredStringValidator(type=ValidatorType.FIELD,
			message="Name Should not be blank",key="errors.required")
	@StringLengthFieldValidator(type=ValidatorType.FIELD,
			message="Name should contain min of 4 characters and max 15 charcters",
			minLength="4",maxLength="15",trim=true)
	public void setCity(String city) {
		System.out.println ("--- ContactUsInfo::setCity; city :"+city+":");
		this.city = city;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
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
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
}
