package com.hertz.herc.franchise.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.opensymphony.xwork2.util.LocalizedTextUtil;

public class GlobalMessagesListener implements ServletContextListener {

	private static final String bundles[] = {"benefits", "buy", "company", "confirm", "contact", "errors", "form", "home", "program", "site"};

	public void contextInitialized (ServletContextEvent arg0) {
		System.out.println ("--- GlobalMessagesListener::contextInitialized");
		for (String s : bundles) {
			LocalizedTextUtil.addDefaultResourceBundle ("content/franchise/bundles/" + s);
		}
	}

	public void contextDestroyed (ServletContextEvent arg0) {}
}
