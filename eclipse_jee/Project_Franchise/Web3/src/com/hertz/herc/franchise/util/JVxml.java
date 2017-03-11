
package com.hertz.herc.franchise.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class JVxml {
	public HashMap<String, String> parse (String strXML) {
		InputSource source = new InputSource (new StringReader (strXML));
		return handle (source);
	}

	public HashMap<String, String> parse (File file) {
		InputSource source = null;
		try {
			source = new InputSource (new FileInputStream (file));
		}
		catch (FileNotFoundException ex) {
			System.out.println ("--- FileNotFoundException ---:");
			System.out.println (ex.getMessage ());
		}
		return handle (source);
	}

	private HashMap<String, String> handle (InputSource source) {
		DocumentBuilderFactory docBuilderFactory;
		DocumentBuilder docBuilder;
		Document doc;
		HashMap<String, String> map = new HashMap<String, String> ();
		try {
			docBuilderFactory = DocumentBuilderFactory.newInstance ();
			docBuilderFactory.setNamespaceAware (false);
			docBuilderFactory.setIgnoringElementContentWhitespace (true);
			docBuilder = docBuilderFactory.newDocumentBuilder ();
			doc = docBuilder.parse (source);
			doc.getDocumentElement ().normalize ();

			Element elem1 = doc.getDocumentElement ();
//			System.out.println ("(1) nodeName "+elem1.getNodeName());

			NodeList nodeList2 = elem1.getChildNodes ();
			int len2 = (nodeList2 != null) ? nodeList2.getLength () : 0;
			for (int i2 = 0; i2 < len2; i2++) {
				if (nodeList2 == null) break;
				Node node2 = nodeList2.item (i2);
				if (node2.getNodeType () == Node.ELEMENT_NODE) {
					NodeList nodeList3 = node2.getChildNodes ();
					int len3 = (nodeList3 != null) ? nodeList3.getLength () : 0;
					for (int i3 = 0; i3 < len3; i3++) {
						if (nodeList3 == null) break;
						Node node3 = nodeList3.item (i3);
//						System.out.println ("node3.getNodeType () "+node3.getNodeType ());
						if (node3.getNodeType () == Node.CDATA_SECTION_NODE) {
//							System.out.println("has child (2) node "+node2.getNodeName());
//							System.out.println("has child (3) value "+node3.getNodeValue());
							map.put (elem1.getNodeName() + "." + node2.getNodeName(), node3.getNodeValue());
						}
					}
				}
			}
		}
		catch (Exception ex) {
			System.out.println ("Exception " + ex.getMessage ());
		}
		return map;
	}
}
