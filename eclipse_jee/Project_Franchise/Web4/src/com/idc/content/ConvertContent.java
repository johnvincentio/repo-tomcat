package com.idc.content;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ConvertContent {
	private static final String MY_INFILE = "C:/jvDevelopment/repo_tomcat/eclipse_jee/Project_Franchise/Web4/resource/content/franchise/enUS/home/contactUsConfirmView.xml";
	private static final String MY_OUTFILE = "C:/work/work205/properties.txt";
	private static final String MY_KEY = "confirm.";

	private OutputFile m_outputfile;

	public static void main (String[] args) {
		(new ConvertContent()).doApp ();
	}
	private void doApp () {
		System.out.println("Starting application");
		m_outputfile = new OutputFile (new File (MY_OUTFILE));
		m_outputfile.open();
		m_outputfile.writeNL("#");
		parse (new File (MY_INFILE));
		m_outputfile.writeNL("#");
		m_outputfile.close();
		System.out.println("Application is complete");
	}

	private void parse (File xmlFile) {
		System.out.println(">>> parse; "+xmlFile.getPath());
		try {
			InputSource source = new InputSource (new FileInputStream (xmlFile));
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance ();
			docBuilderFactory.setNamespaceAware (false);
			docBuilderFactory.setIgnoringElementContentWhitespace (true);
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder ();
			Document doc = docBuilder.parse (source);
			doc.getDocumentElement ().normalize ();
			NodeList nodeList1 = doc.getChildNodes ();
			System.out.println("aaa "+doc.getChildNodes());
			for (int i1 = 0; i1 < nodeList1.getLength (); i1++) {
				Node node1 = nodeList1.item (i1);
				if (node1.getNodeType () == Node.ELEMENT_NODE) {
					NodeList nodeList2 = node1.getChildNodes ();
					for (int i2 = 0; i2 < nodeList2.getLength (); i2++) {
						Node node2 = nodeList2.item (i2);
						if (node2.getNodeType () == Node.ELEMENT_NODE) {
							Element eElement2 = (Element) node2;
							System.out.println("eElement name "+eElement2.getNodeName());
							String value = JVString.cleanString (getTagValue (eElement2));
							System.out.println("eElement value "+value);
							if ("disclaimerContent".equals (eElement2.getNodeName())) {
								JVString.dump (value, "disclaimerContent");
							}
							m_outputfile.writeNL (MY_KEY + eElement2.getNodeName() + "=" + value);
						}
					}
				}
			}
		}
		catch (FileNotFoundException ex) {
			System.out.println ("FileNotFoundException; file " + xmlFile.getPath () + ", " + ex);
		}
		catch (SAXException saxEx) {
			System.out.println ("SAXException; file " + xmlFile.getPath () + ", " + saxEx);
		}
		catch (IOException ioEx) {
			System.out.println ("IOException; file " + xmlFile.getPath () + ", " + ioEx);
		}
		catch (ParserConfigurationException pcEx) {
			System.out.println ("ParserConfigurationException; file " + xmlFile.getPath () + ", " + pcEx);
		}
		System.out.println("<<< parse; "+xmlFile.getPath());
		return;
	}

	/**
	 * Returns the value of the XML Element
	 * 
	 * @param  sTag   			String
	 * @param  eElement 		Element
	 * @return tagValue			String
	 */
	private static String getTagValue (Element eElement) {
		NodeList list = eElement.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			if (list.item(i) instanceof CharacterData) {
				CharacterData cd = (CharacterData) list.item(i);
				String data = cd.getData();
				if (data != null && data.trim().length() > 0)
					return data;
			}			
		}
		return "";
	}
}
