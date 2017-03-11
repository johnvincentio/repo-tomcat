package com.idc.test;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class App {
	Locale[] supportedLocales = {Locale.FRENCH, Locale.GERMAN, Locale.ENGLISH};

	public static void main (String[] args) {
		(new App ()).doTest ();
	}

	private void doTest () {
//		doBundle ("com.hertz.herc.franchise.action.ContactUsAction");
//		doBundle ("global_messages");
//		doBundleLocale ("global_messages", Locale.ENGLISH);
		doBundleLocale ("content.franchise.bundles.benefits", Locale.ENGLISH);
	}
	private void doBundle (String bundleName) {
		for (Locale locale : supportedLocales) {
			doBundleLocale (bundleName, locale);
		}
	}

	private void doBundleLocale (String bundleName, Locale locale) {
		System.out.println (">>> doBundleLocale; bundleName "+bundleName+" locale "+locale);
		ResourceBundle rb = ResourceBundle.getBundle (bundleName, locale);
		Enumeration<String> keys = rb.getKeys ();
		while (keys.hasMoreElements ()) {
			String key = keys.nextElement ();
			String value = rb.getString (key);
			System.out.println (key + ": " + value);
		}
		System.out.println ("<<< doBundleLocale; bundleName "+bundleName+" locale "+locale);
	}
}
