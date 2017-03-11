
package com.hertz.herc.franchise.content;

import java.util.HashMap;

import com.hertz.herc.franchise.util.JVFile;
import com.hertz.herc.franchise.util.JVxml;

public class HercContentBroker {
	private static Class<?> classRef = HercContentBroker.class;

	private static HashMap<String, HashMap<String, String>> m_map = new HashMap<String, HashMap<String, String>>();

	public static void main (String[] args) {
		System.out.println (">>> HercContentBroker::main");
//		getContentMap ("franchise", "enUS", "home", "companyView.xml");
		getContentMap ("franchise", "enUS", "common", "siteframe.xml");
		System.out.println ("<<< HercContentBroker::main");
	}
/*
	public static void doTest() {
		System.out.println (">>> HercContentBroker::doTest");
		String buf = JVFile.readFileFromWebAppClasspath (classRef, "content/franchise/enUS/common/siteFrame.xml");
		buf = JVFile.readFileFromWebAppClasspath (classRef, "/content/franchise/enUS/common/siteFrame.xml");
		buf = JVFile.readFileFromWebAppClasspath (classRef, "/classes/content/franchise/enUS/common/siteFrame.xml");
		buf = JVFile.readFileFromWebAppClasspath (classRef, "classes/content/franchise/enUS/common/siteFrame.xml");
		buf = JVFile.readFileFromWebAppClasspath (classRef, "/WEB-INF/classes/content/franchise/enUS/common/siteFrame.xml");
		System.out.println ("<<< HercContentBroker::doTest");
	}
*/

	private static HashMap<String, String> handleContent (String key) {
//		System.out.println (">>> handleContent; key "+key);
		if (m_map.containsKey (key)) {
			return m_map.get (key);
		}
//		System.out.println ("get file from "+key);
		String buf = JVFile.readFileFromWebAppClasspath (classRef, key);
//		System.out.println ("buf "+buf);
		HashMap<String, String> map = (new JVxml()).parse (buf);
//		System.out.println ("<<< handleContent; key "+key);
		return map;
	}

	/**
	 * Get content from the cache for one file.
	 * 
	 * @param application		Herc application
	 * @param dialect			Dialect
	 * @param section			Section
	 * @param file				File name containing the content
	 * @return					Object containing the content for the given file
	 */
	public static HashMap<String, String> getContentMap (String application, String dialect, String section, String file) {
//		LogBroker.debug (classRef, ">>> HercContentBroker::getElement; file :"+file+":");
		String key = "/content/" + application + "/" + dialect + "/" + section + "/" + file;
//		LogBroker.debug (classRef, "key :"+key+":");
		HashMap<String, String> element = handleContent (key);
//		LogBroker.debug (classRef, "<<< HercContentBroker::getElement; element :"+element+":");
		return element;
	}
	
	/**
	 * Get content from the cache for one file.
	 * 
	 * @param application		Herc application
	 * @param dialect			Dialect
	 * @param section			Section
	 * @param file				File name containing the content
	 * @return					Object containing the content for the given file
	 */
/*
	public static ContentCacheElement getElement (String application, String dialect, String section, String file, boolean seo) {
//		LogBroker.debug (classRef, ">>> HercContentBroker::getElement; file :"+file+":");
		String filename;
		if (seo)
			filename = "seo/" + application + "/" + dialect + "/" + section + "/" + file;
		else
			filename = application + "/" + dialect + "/" + section + "/" + file;
//		LogBroker.debug (classRef, "filename :"+filename+":");
		ContentCacheElement element = hercCache.get (filename);
		if (element == null) {
			element = new ContentCacheElement();
		}
//		LogBroker.debug (classRef, "<<< HercContentBroker::getElement; element :"+element+":");
		return element;
	}
*/
	/**
	 * Get value from the file based on the key.
	 * 
	 * @param key				To get the actual message.
	 * @return					Object containing the content for the given file
	 */
/*
	public static String getMessage (String key) {
	    ContentCacheElement contentCacheElement = getElement("hercWeb", "enUS", "appMessages", "messages.xml");
	    return contentCacheElement.getContent("messages."+key);
	}
*/
	/**
	 * Get value from a node in the XML file for a given application, section and dialect.
	 * 
	 * @param application	Herc application
	 * @param dialect		Dialect
	 * @param section		Section
	 * @param file			File name containing the content
	 * @param node			Node containing the content
	 * @return				Object containing the content for the given file
	 */
/*
	public static String getContent(String application, String dialect, String section, String file, String node) {
		ContentCacheElement contentCacheElement = getElement(application, dialect, section, file);
		return contentCacheElement.getContent(node);
	}
	public static String getContent(String application, DialectItemInfo dialectItemInfo, String section, String file, String node) {
		return getContent (application, dialectItemInfo.getDialect(), section, file, node);
	}
*/
	/**
	 *  Get value from a node in the XML file for a given application, section, dialect and seo section.
	 *  
	 * @param application	Herc application
	 * @param dialect		Dialect
	 * @param section		Section
	 * @param file			File name containing the content
	 * @param node			Node containing the content
	 * @param seo			seo section - true or false
	 * @return				Object containing the content for the given file
	 */
/*
	public static String getContent(String application, String dialect, String section, String file, String node, boolean seo) {
		ContentCacheElement contentCacheElement = getElement(application, dialect, section, file, seo);
		return contentCacheElement.getContent(node);
	}
	public static String getContent(String application, DialectItemInfo dialectItemInfo, String section, String file, String node, boolean seo) {
		return getContent (application, dialectItemInfo.getDialect(), section, file, node, seo);
	}
*/
	/**
	 * Get content from the cache for a POS based file.
	 * 
	 * @param application		Herc application
	 * @param pos				Point of Sale
	 * @param dialect			Dialect
	 * @param section			Section
	 * @param file				File name containing the content
	 * @return					Object containing the content for the given file
	 */
/*
	public static ContentCacheElement getElement (String application, String pos, String dialect, String section, String file) {
		String filename = application + "/" + pos + "/" + dialect + "/" + section + "/" + file;
		ContentCacheElement element = hercCache.get (filename);
		if (element == null) element = new ContentCacheElement();
		return element;
	}
*/
	
	/**
	 * Get value from a node in the XML file for a given application, POS, dialect and section.
	 * 
	 * @param application	Herc application
	 * @param pos			Point of Sale
	 * @param dialect		Dialect
	 * @param section		Section
	 * @param file			File name containing the content
	 * @param node			Node containing the content
	 * @return				Object containing the content for the given file
	 */
//	public static String getContent(String application, String pos, String dialect, String section, String file, String node) {
//		ContentCacheElement contentCacheElement = getElement(application, pos, dialect, section, file);
//		return contentCacheElement.getContent(node);
//	}
	
	/**
	 * Get value from a node in the XML file for a given application, 
	 * POS, dialect and section.
	 * TODO - If the content is not available for a dialect, 
	 * look for the same in default dialect for the POS.
	 * 
	 * @param application	Herc application
	 * @param pos			Point of Sale
	 * @param dialect		Dialect
	 * @param section		Section
	 * @param file			File name containing the content
	 * @param node			Node containing the content
	 * @return				Object containing the content for the given file
	 */
//	public static String getContentForPosByDialect(String application, PosItemInfo pos, DialectItemInfo dialect, String section, String file, String node) {
//		//TODO 06/15/10 - Fix the content management framework
//		String dialectBasedContentFolder = "enUS";
//		String content = getContent(application, pos.getPos(), dialectBasedContentFolder, section, file, node);		
//		return content;
//	}
}


/*

	public static Properties loadPropertiesFromFile (Class<?> classRef, String file) throws HertzSystemException {
		try {
		    Properties properties = new Properties(); 
		    properties.load (new FileInputStream (new File (file)));    
		    return properties;
		}
		catch (IOException ioex) {
			throw HercErrorHelper.handleException (classRef, ioex);
		}
	}
*/
