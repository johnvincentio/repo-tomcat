
package com.hertz.herc.franchise.framework.session;

import java.io.Serializable;

import com.hertz.herc.franchise.info.DialectItemInfo;
import com.hertz.herc.franchise.info.PosItemInfo;

/**
 * Handle Session data objects
 * 
 * @author John Vincent
 */
public class SessionAppInfo implements Serializable {

	private static final long serialVersionUID = -8817992303814976017L;
/*
 * handle initialization of this object
 */
	private boolean initialized = false;
	public boolean getInitialized() {return initialized;}
	public void setInitialized() {this.initialized = true;}

/*
 * handle dialect
 */
	private DialectItemInfo defaultDialectItemInfo = new DialectItemInfo();
	private DialectItemInfo userDialectItemInfo = null;
	public DialectItemInfo getDialect() {
		if (userDialectItemInfo != null) return userDialectItemInfo;
		return defaultDialectItemInfo;
	}
	public void setUserDialect (DialectItemInfo dialectItemInfo) {userDialectItemInfo = dialectItemInfo;}
	public void setUserDialect() {userDialectItemInfo = null;}

/*
 * handle point of sale
 */
	private PosItemInfo defaultPosItemInfo = new PosItemInfo();
	private PosItemInfo userPosItemInfo = null;
	public PosItemInfo getPosItemInfo() {
		if (userPosItemInfo != null) return userPosItemInfo;
		return defaultPosItemInfo;
	}
	public void setUserPos (String pos) {userPosItemInfo = new PosItemInfo (pos);}
	public void setUserPos() {userPosItemInfo = null;}

	public String toString() {
		return "defaultDialectItemInfo :"+defaultDialectItemInfo+
			": userDialectItemInfo :"+userDialectItemInfo+
			": defaultPosItemInfo :"+defaultPosItemInfo+
			": userPosItemInfo :"+userPosItemInfo;
	}
}
