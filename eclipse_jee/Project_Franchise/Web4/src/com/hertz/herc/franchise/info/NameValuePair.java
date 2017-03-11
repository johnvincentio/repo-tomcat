
package com.hertz.herc.franchise.info;

public class NameValuePair implements java.io.Serializable {
	private static final long serialVersionUID = 1091100976262849366L;

	protected String name;
	protected String value;
	private Object objectValue;

	public NameValuePair () {}

	public NameValuePair (String name, String value) {
		this.name = name;
		this.value = value;
	}

	public NameValuePair (String name, Object value) {
		this.name = name;
		this.objectValue = value;
	}

	public String getName () {
		return name;
	}

	public String getValue () {
		return value;
	}

	public void setName (String name) {
		this.name = name;
	}

	public void setValue (String value) {
		this.value = value;
	}

	public Object getObjectValue () {
		return objectValue;
	}

	public void setObjectValue (Object objectValue) {
		this.objectValue = objectValue;
	}

	public int compareTo (Object nameValuePair) {
		return name.compareTo (((NameValuePair) nameValuePair).getName ());
	}

	public boolean equals (Object object) {
		if (object instanceof NameValuePair) return ((NameValuePair) object).getName ().equals (name);
		return super.equals (object);
	}
}
