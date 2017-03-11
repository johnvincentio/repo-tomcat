
package com.hertz.herc.franchise.info;

import com.hertz.herc.franchise.util.UtilHelper;

/**
 * @author John Vincent
 *
 *	describe a menu item
 */

public class MenuItem {
	private int id;
	private int count;
	private String name;
	private String urlName;
	private Menu menu;
	public MenuItem (int i, String s) {
		id = i;
		name = s;
		urlName = UtilHelper.getTransformedUrl (name);
		count = 0;		
		menu = new Menu();
	}
	public MenuItem (int categoryId, String displayName, int itemCount) {
		id = categoryId;
		name = displayName;
		urlName = UtilHelper.getTransformedUrl (name);
		count = itemCount;		
		menu = new Menu();
	}
	public int getId() {return id;}
	public int getCount() {return count;}
	public String getName() {return name;}
	public String getUrlName() {return urlName;}

	public Menu getMenu() {return menu;}
	public boolean isLeaf() {
		if (menu == null || menu.getSize() < 1) return true;
		return false;
	}
	public void sort() {menu.sort();}
}
