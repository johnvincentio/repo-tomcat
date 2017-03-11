package com.hertz.herc.franchise.info;

import java.util.ArrayList;
import java.util.Iterator;

public class Nav {
	ArrayList<NavItem> m_list = new ArrayList<NavItem> ();

	public Iterator<NavItem> getItems () {
		return m_list.iterator ();
	}

	public int size () {
		return m_list.size ();
	}

	public boolean isNone () {
		return m_list.isEmpty ();
	}

	public void add (NavItem item) {
		m_list.add (item);
	}
}
