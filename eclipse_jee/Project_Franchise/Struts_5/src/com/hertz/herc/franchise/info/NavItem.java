package com.hertz.herc.franchise.info;

public class NavItem {
	private final String text;
	private final String url;
	private boolean selected;
	private boolean isVisible; // used to determine if this NavItem should be displayed in devices other than desktop

	private final Nav nav = new Nav ();

	public NavItem (String text, String url, boolean selected, boolean isVisible) {
		this.text = text;
		this.url = url;
		this.selected = selected;
		this.isVisible = isVisible;
	}

	public String getText () {
		return text;
	}

	public String getUrl () {
		return url;
	}

	public Nav getNav () {
		return nav;
	}

	public boolean isSelected () {
		return selected;
	}

	public boolean isVisible () {
		return isVisible;
	}

	public boolean isLeaf () {
		if (nav == null || nav.size () < 1) return true;
		return false;
	}
}
