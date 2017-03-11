
package com.hertz.herc.franchise.info;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class HercCountryDialectsInfo implements Serializable {
	private static final long serialVersionUID = -6536472412841398362L;

	private ArrayList<HercCountryDialectsItemInfo> m_collection = new ArrayList<HercCountryDialectsItemInfo>();
	public void add (HercCountryDialectsItemInfo item) {if (item != null) m_collection.add (item);}
	public Iterator<HercCountryDialectsItemInfo> getItems() {return m_collection.iterator();}
	public int getSize() {return m_collection.size();}
	public boolean isNone() {return getSize() < 1;}

	public String getDefaultDialect() {return m_collection.get(0).getDialect();}

	public String[] getDialects() {
		String[] arr = new String[getSize()];
		for (int i = 0; i < m_collection.size(); i++) {
			arr[i] = m_collection.get(i).getDialect();
		}
		return arr;
	}

	public String getCountryText (String dialect) {
		for (HercCountryDialectsItemInfo item : m_collection) {
			if (item.getDialect().equals(dialect)) return item.getCountryText();
		}
		return "";
	}

	public String getCountryAbbreviation (String dialect) {
		for (HercCountryDialectsItemInfo item : m_collection) {
			if (item.getDialect().equals(dialect)) return item.getCountryAbbreviation();
		}
		return "";
	}

	public String toString() {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < m_collection.size(); i++)
			buf.append (m_collection.get(i).toString());
		return "("+buf.toString()+")";
	}
}
