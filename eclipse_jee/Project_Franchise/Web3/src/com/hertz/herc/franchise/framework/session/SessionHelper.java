
package com.hertz.herc.franchise.framework.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.hertz.herc.franchise.info.ContactUsInfo;
import com.hertz.herc.franchise.info.DialectItemInfo;
import com.hertz.herc.franchise.info.PosItemInfo;

/**
 * Handle Session data tasks
 * 
 * @author John Vincent
 * @author Manasi Lonkar
 */
public class SessionHelper {
	/**
	 * Get the SessionHttpInfo object
	 * 
	 * @param request		HttpServletRequest
	 * @return				SessionHttpInfo object
	 */
	private static SessionHttpInfo getSessionHttpInfo (HttpServletRequest request) {
		return SessionHttpInfo.getInstance(request.getSession());
	}

	/**
	 * Update UserHttpInfo object.
	 * 
	 * @param request		HttpServletRequest
	 */
	private static void updateSessionHttpInfo (HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute(SessionHttpInfo.SESSION_NAME, getSessionHttpInfo (request));
	}

	/**
	 * get the SessionInfo object
	 * 
	 * @param request		HttpServletRequest
	 * @return				the SessionInfo object
	 */
	private static SessionAppInfo getSessionAppInfo (HttpServletRequest request) {
		return getSessionHttpInfo(request).getSessionAppInfo();
	}

/*
 * handle initialized
 */
	/**
	 * determine if already initialized
	 * 
	 * @param request		HttpServletRequest
	 * @return				true if already initialized
	 */
	public static boolean getInitialized (HttpServletRequest request) {
		return getSessionAppInfo(request).getInitialized();
	}

	/**
	 * set to initialized
	 * 
	 * @param request		HttpServletRequest
	 */
	public static void setInitialized (HttpServletRequest request) {
		getSessionAppInfo(request).setInitialized();
		updateSessionHttpInfo (request);
	}

/*
 * handle point of sale
 */
	/**
	 * Get point of sale
	 * 
	 * @param request		HttpServletRequest
	 * @return				point of sale
	 */
	public static String getPos (HttpServletRequest request) {
		return getSessionAppInfo(request).getPosItemInfo().getPos();
	}

	/**
	 * Get point of sale object
	 * 
	 * @param request		HttpServletRequest
	 * @return				point of sale object
	 */
	public static PosItemInfo getPosItemInfo (HttpServletRequest request) {
		return getSessionAppInfo(request).getPosItemInfo();
	}

	/**
	 * Set point of sale
	 * 
	 * @param request		HttpServletRequest
	 * @param pos			Point of Sale
	 */
	public static void setUserPos (HttpServletRequest request, String pos) {
		getSessionAppInfo(request).setUserPos (pos);
		updateSessionHttpInfo (request);
	}

/*
 * handle dialect
 */
	/**
	 * get dialectItemInfo
	 * 
	 * @param request		HttpServletRequest
	 * @return				dialectItemInfo
	 */
	public static DialectItemInfo getDialectItemInfo (HttpServletRequest request) {
		return getSessionAppInfo(request).getDialect();
	}

	/**
	 * get dialect
	 * 
	 * @param request		HttpServletRequest
	 * @return				dialect
	 */
	public static String getDialect (HttpServletRequest request) {
		return getSessionAppInfo(request).getDialect().getDialect();
	}

	/**
	 * Set dialect
	 * 
	 * @param request				HttpServletRequest
	 * @param dialectItemInfo		Dialect
	 */
	public static void setUserDialect (HttpServletRequest request, DialectItemInfo dialectItemInfo) {
		getSessionAppInfo(request).setUserDialect (dialectItemInfo);
		updateSessionHttpInfo (request);
	}


/*
 * handle contact us
 */
	/**
	 * Determine whether contactus information exists
	 * 
	 * @param request		HttpServletRequest
	 * @return				true if contactus data exists
	 */
	public static boolean isContactUsInfo (HttpServletRequest request) {
		return getSessionAppInfo(request).getContactUsInfo() != null;
	}

	/**
	 * Get contactus data
	 * 
	 * @param request		HttpServletRequest
	 * @return				contactus data
	 */
	public static ContactUsInfo getContactUsInfo (HttpServletRequest request) {
		return getSessionAppInfo(request).getContactUsInfo();
	}

	/**
	 * Set contactUsInfo in session
	 * 
	 * @param request			HttpServletRequest
	 * @param contactUsInfo		Contact Us Info
	 */
	public static void updateContactUsInfo (HttpServletRequest request, ContactUsInfo contactUsInfo) {
		getSessionAppInfo(request).setContactUsInfo (contactUsInfo);
		updateSessionHttpInfo (request);
	}


/*
 * handle trace of session object
 */

	/**
	 * Get String representing the session object
	 * 
	 * @param request		HttpServletRequest
	 */
	public static String toString (HttpServletRequest request) {
		return getSessionAppInfo(request).toString();
	}
}
