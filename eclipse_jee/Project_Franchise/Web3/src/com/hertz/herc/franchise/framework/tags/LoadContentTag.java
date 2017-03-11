package com.hertz.herc.franchise.framework.tags;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.hertz.herc.franchise.framework.session.SessionHelper;
import com.hertz.herc.franchise.content.HercContentBroker;
import com.hertz.herc.franchise.util.LogBroker;
import com.opensymphony.xwork2.ActionContext;

public class LoadContentTag extends SimpleTagSupport {
	private static Class<?> classRef = LoadContentTag.class;
	private static final String APPLICATION = "franchise";
	private String file;
	private String section;
	private String key;

	public void doTag () throws JspException, IOException {
		LogBroker.debug (classRef, ">>> LoadContentTag::doTag; file :" + file + ": section :" + section + ":");
		PageContext pageContext = (PageContext) getJspContext ();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest ();
		String dialect = SessionHelper.getDialect (request);
		HashMap<String, String> contentCacheElement = HercContentBroker.getContentMap (APPLICATION, dialect, section, file);
//		LogBroker.debug (classRef, "contentCacheElement " + contentCacheElement);
		ActionContext.getContext ().getValueStack ().set (key, contentCacheElement);
		LogBroker.debug (classRef, "<<< LoadContentTag::doTag");
	}

	public void setFile (String file) {
		this.file = file;
	}

	public void setSection (String section) {
		this.section = section;
	}

	public void setKey (String key) {
		this.key = key;
	}
}
