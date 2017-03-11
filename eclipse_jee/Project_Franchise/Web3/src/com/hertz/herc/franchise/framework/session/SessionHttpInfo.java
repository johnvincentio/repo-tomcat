package com.hertz.herc.franchise.framework.session;

import javax.servlet.http.HttpSession;

import com.hertz.herc.franchise.info.HTTPInfo;

/**
 * Handle Session data
 * 
 * @author John Vincent
 */
public class SessionHttpInfo extends HTTPInfo {

	private static final long serialVersionUID = 8329696275980347577L;
	public static final String SESSION_NAME = SessionHttpInfo.class.toString ();
	private SessionAppInfo sessionAppInfo = new SessionAppInfo ();

	public SessionHttpInfo () {}

	public SessionAppInfo getSessionAppInfo () {
		return sessionAppInfo;
	}

	public static SessionHttpInfo getInstance (HttpSession session) {
		SessionHttpInfo httpInfo = (SessionHttpInfo) session.getAttribute (SESSION_NAME);
		if (httpInfo == null) {
			httpInfo = new SessionHttpInfo ();
			session.setAttribute (SESSION_NAME, httpInfo);
		}
		httpInfo.session = session;
		return httpInfo;
	}

	public static void clearSession (HttpSession session) throws IllegalArgumentException {
		if (session == null) throw new IllegalArgumentException ("Session was null");
		session.removeAttribute (SESSION_NAME);
	}
}
