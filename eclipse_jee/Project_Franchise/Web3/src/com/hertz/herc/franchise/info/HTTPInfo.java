package com.hertz.herc.franchise.info;

import java.io.Serializable;
import javax.servlet.http.HttpSession;

public class HTTPInfo implements Serializable {

	private static final long serialVersionUID = -4031182266951284008L;

	protected transient HttpSession session;

	public HTTPInfo () {}

	protected String targetPage = "";

	public String getTargetPage () {
		return targetPage;
	}

	public void setTargetPage (java.lang.String targetPage) {
		this.targetPage = targetPage;
	}

}