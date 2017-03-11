
package com.hertz.herc.franchise.info;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * @author John Vincent
 *
 *	describe a menu - used by the JSPs
 */

public class Menu {
	ArrayList<MenuItem> m_list = new ArrayList<MenuItem>();		// items in the menu
	public void add (MenuItem menuItem) {
		if (! isExists (menuItem)){
			m_list.add(menuItem);
		}
	}
	public Iterator<MenuItem> getItems() {return m_list.iterator();}
	public int getSize() {return m_list.size();}
	public boolean isEmpty() {return m_list.isEmpty();}
	public boolean isExists (MenuItem menuItem) {
		Iterator<MenuItem> iter = m_list.iterator();
		while (iter.hasNext()) {
			MenuItem item = iter.next();
			if (item.getId() == menuItem.getId()) return true;
		}
		return false;
	}
	
	public MenuItem getItem(MenuItem menuItem){
		Iterator<MenuItem> iter = getItems();
		while (iter.hasNext()){
			MenuItem item = iter.next();
			if (item.getId() == menuItem.getId()) return item;
		}
		return null;
	}

	public void sort() {
		Collections.sort(m_list, new SortItemsAsc());
		Iterator<MenuItem> iter = m_list.iterator();
		while (iter.hasNext()) {
			MenuItem item = iter.next();
			item.sort();
		}
	}
	private class SortItemsAsc implements Comparator<MenuItem> {
		public int compare (MenuItem a, MenuItem b) {
			return a.getName().compareTo (b.getName());
		}
	}
}
