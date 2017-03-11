
package com.hertz.herc.franchise.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Various helper methods
 * 
 * @author John Vincent
 */

public class UtilHelper { 

	public final static String IMAGE_SERVER = "images.hertz.com";

	public static String buildImagePath (HttpServletRequest request, String prefix, String image_name, String dialect) {
		String protocol;
		if (request.isSecure())
			protocol = "https://";
		else
			protocol = "http://";

		StringBuffer imageUrl = new StringBuffer (protocol);
		imageUrl.append (IMAGE_SERVER);

		if (prefix != null) {
			if (! prefix.startsWith("/")) imageUrl.append("/");
			imageUrl.append (prefix);
		}
		
		if (dialect != null && ! dialect.equals("")) {
			if (! dialect.startsWith("/")) imageUrl.append ("/");
			imageUrl.append (dialect);	
		}
		
		if (! image_name.startsWith("/")) imageUrl.append ("/");
		imageUrl.append (image_name);

		return imageUrl.toString();
	}

    /**
     * translates a string into application/x-www-form-urlencoded format
     * 
     * @param str		String to encode
     * @return			encoded String
     */
    public static String encodeURI (String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            return str;
        }
    }
    
    // tests for a null/empty string
	public static boolean isSet(String str) {
		return (str == null || "".equals(str)) ? false : true;
	}    
	
	public static String getTransformedUrl (String url) {return url.toLowerCase().replace('/', '.').replace(' ', '-');}
	public static String getUnTransformedUrl (String url) {return url.replace('.', '/').replace('-', ' ');}

	public static void doErrorPage (HttpServletResponse response) {
		try {
			response.reset();
		}
		catch (Exception e) {
		}
	}
}
