
package com.hertz.herc.franchise.info;

import java.io.Serializable;

/**
 * Describe a Central Reservation object. DO NOT USE SETTERS.
 * 
 * @author John Vincent
 */
public class CentralResItemInfo implements Serializable {
	private static final long serialVersionUID = 6495434563975708006L;

	private String telephone;
	private String email_addresses;
	private String contact_email_addresses;
	
	public CentralResItemInfo (String telephone, String email_addresses, String contact_email_addresses) {
		this.telephone = telephone;
		this.email_addresses = email_addresses;
		this.contact_email_addresses = contact_email_addresses;
	}
	public String getTelephone() {return telephone;}
	public String getEmail_addresses() {return email_addresses;}
	public String getContact_email_addresses() {return contact_email_addresses;}
	
	public String toString() {
		return "("+getTelephone()+","+getEmail_addresses()+","+getContact_email_addresses()+")";
	}
}
