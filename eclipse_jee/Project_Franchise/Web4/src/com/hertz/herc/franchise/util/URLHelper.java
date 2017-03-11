
package com.hertz.herc.franchise.util;

import java.net.ProtocolException;

import javax.servlet.http.HttpServletRequest;


/**
 * @author Michael Tardif
 */
public class URLHelper {

	public final static String IMAGE_SERVER = "images.hertz.com";

	/**
	 *  Build relative path to handler - eg. /web_context/handlers/HomeHandler
	 * 	@param request 
	 *  @param handler
	 *  @return handler path
	 */ 
	public static String buildHandlerPath(HttpServletRequest request, String handler) {
		StringBuffer buffer = new StringBuffer(request.getContextPath());
		buffer.append("/handlers/").append(handler);
		return buffer.toString();
	}

	/**
	 *  Build path to target page - eg. /web_context/home/index.jsp?targetPage=homeView.jsp
	 * 	@param request 
	 *  @param section 
	 *  @param target
	 *  @return index path
	 */ 
	public static String buildIndexPath(HttpServletRequest request, String section, String target) {
		StringBuffer buffer = new StringBuffer(request.getContextPath());
		buffer.append("/").append(section).append("/index.jsp?targetPage=").append(target);
		return buffer.toString();
	}
	/**
	 *  Build path to target page - eg. /home/index.jsp?targetPage=homeView.jsp
	 * 	@param request 
	 *  @param section 
	 *  @param target
	 *  @return index path
	 */ 
	public static String buildRelativeIndexPath(String section, String target) {
		StringBuffer buffer = new StringBuffer("/");
		buffer.append(section).append("/index.jsp?targetPage=").append(target);
		return buffer.toString();
	}
	/**
	 * Build path to the rentals page - eg. /pages/rentals/equipmentDetails.jsp?catId=1212...
	 * 
	 * @param section
	 * @param target
	 * @return
	 */
	public static String buildPath(String section, String target){		
		StringBuffer buffer = new StringBuffer("/");
		buffer.append(section).append("/").append(target);
		return buffer.toString();
	}
	/**
	 *  Build path to file - eg. /home/homeView.jsp
	 *  @param section 
	 *  @param target
	 *  @return internal path
	 */ 	
	public static String buildIncludePath(String section, String file) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("/").append(section).append("/").append(file);
		return buffer.toString();
	}	

	public static String buildImagePath (HttpServletRequest request, String prefix, String image_name) {
		return buildImagePath(request, prefix, image_name, null);
	}

	/**
	 *  Build path to image with dialect
	 * 	@param request 
	 *  @param prefix 
	 *  @param image
	 *  @return image path
	 */ 	
	public static String buildImageDialectPath (HttpServletRequest request, String prefix, String dialect, String image) {
	    return buildImagePath (request, prefix, image, dialect);
	}	

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
	 *  Build path to file - eg. /web_context/homeView.jsp
	 * 	@param request
	 *  @param target
	 *  @return internal path
	 */ 
	public static String buildPath(HttpServletRequest request, String target) {
		StringBuffer buffer = new StringBuffer(request.getContextPath());
		buffer.append("/").append(target);
		return buffer.toString();
	}	
	
	public static String buildConstructionPath(HttpServletRequest request) {
		return buildPath (request, "construction", "index.jsp");
	}
	
	/**
	 *  Build path to file - eg. /web_context/home/homeView.jsp
	 * 	@param request
	 *  @param section 
	 *  @param target
	 *  @return internal path
	 */ 
	public static String buildPath(HttpServletRequest request, String section, String target) {
		StringBuffer buffer = new StringBuffer(request.getContextPath());
		buffer.append("/").append(section).append("/").append(target);
		return buffer.toString();
	}

	public static String appendParam (String currentURL, String key, String value) {
		StringBuffer buf = new StringBuffer (currentURL);
		if (currentURL.indexOf("?") > -1)
			buf.append("&");
		else
			buf.append("?");
		buf.append(UtilHelper.encodeURI(key)).append("=").append(UtilHelper.encodeURI(value));
		return buf.toString();
	}
	
	public static String replaceParam(String currentURL, String key, String value) {    

	    int start = currentURL.indexOf(key + "=");
	    
	    if(start > 0) {
	        start += key.length() + 1;
	        int end = currentURL.indexOf('&', start);
	        
	        String newURL = currentURL.substring(0, start) + UtilHelper.encodeURI(value);
	        
	        if(end > 0)
	            newURL += currentURL.substring(end);
	        
	        return newURL;
	    }
        return appendParam(currentURL, key, value);
	}
	
	public static String appendParam (String currentURL, String key, int value) {
		return appendParam (currentURL, key, Integer.toString(value));
	}

	public static String appendParam (String currentURL, String key, long value) {
		return appendParam (currentURL, key, Long.toString(value));
	}

	public static String buildURL(String context, String target) {
		return buildURL(context, target, null);
	}
	
	public static String buildURL(String context, String target, String query) {
		StringBuffer url = new StringBuffer("");
		if(UtilHelper.isSet(context)) {
			if(context.endsWith("/"))
				url.append(context);
			else 
				url.append(context + "/");
		}
		
		if(UtilHelper.isSet(target)) {
			if(target.startsWith("/"))
				url.append(target.substring(1));
			else
				url.append(target);
		}
		
		if(UtilHelper.isSet(query)) {
			if(query.startsWith("?"))
				url.append(query);
			else
				url.append("?" + query);
		}
		return url.toString();
	}

	public static String buildAbsoluteURLAcrossDomains(String domain, String contextRoot, String prefix, String dialect, 
			String suffix, boolean isSecureURL) 	{
		String relativeURL = buildi18nRelativePath (contextRoot, prefix, dialect, suffix);
		String protocol;
		StringBuffer buffer;
	
		if (isSecureURL) 
			protocol = "https://";	
		else
			protocol = "http://";	
					
		buffer = new StringBuffer(protocol);
		buffer.append(domain);
		buffer.append(relativeURL);
		return buffer.toString();	
	}

	public static String buildi18nRelativePath (String ctx_root, String prefix, String dialect, String suffix) {
		if (ctx_root == null) return buildi18nRelativePath (prefix, dialect, suffix);	

		ctx_root = formatContextRoot (ctx_root);
		StringBuffer relativeURL = new StringBuffer (ctx_root);

		if (prefix != null) {
			if (! prefix.startsWith("/")) relativeURL.append("/");
			relativeURL.append(prefix);
		}
		
		if (dialect != null) {
			if (! dialect.startsWith("/")) relativeURL.append("/");
			relativeURL.append(dialect);
		}
		
		if (suffix != null) {
			if (! suffix.startsWith("/")) relativeURL.append("/");
			relativeURL.append(suffix);
		}
		
		return relativeURL.toString();
	}

	public static String buildi18nRelativePath (String prefix, String dialect, String suffix) {
		StringBuffer relativeURL = new StringBuffer("");
		
		if (! prefix.startsWith("/")) relativeURL.append("/");
		relativeURL.append(prefix);
		
		if (! dialect.startsWith("/")) relativeURL.append("/");
		relativeURL.append(dialect);
		
		if (! suffix.startsWith("/")) relativeURL.append("/");
		relativeURL.append(suffix);
			
		return relativeURL.toString();
	}

	private static String formatContextRoot (String ctx_root) {
		if (ctx_root == null) return "";
		if (ctx_root.equals ("/")) ctx_root = "";	
		if (! ctx_root.startsWith("/") && ! ctx_root.trim().equals ("")) ctx_root = "/" + ctx_root;
		return ctx_root;
	}

	public static String secureURL (String non_secureURL) throws ProtocolException {
		String secureUrl;
		
		int start_index = non_secureURL.toLowerCase().indexOf("http://");		
		if (start_index > -1) {		// not secure
			StringBuffer unsecureUrl = new StringBuffer(non_secureURL);
			secureUrl = unsecureUrl.insert(start_index+4, "s").toString();		// make secure
		}
		else {
		    if (non_secureURL.toLowerCase().indexOf("https://") > -1)		// already secure
		        return non_secureURL;
	        throw new ProtocolException();		// wrong format
		}
		return secureUrl;			
	}
	
	public static String unSecureURL (String secureURL) throws ProtocolException {
		String non_secureUrl;
		
		int start_index = secureURL.toLowerCase().indexOf("https://");		
		if (start_index > -1) {		// not secure
			StringBuffer unsecureUrl = new StringBuffer(secureURL);
			non_secureUrl = unsecureUrl.deleteCharAt(start_index + 4).toString();		// make unsecured
		}
		else {
		    if (secureURL.toLowerCase().indexOf("http://") > -1)		// already unsecured
		        return secureURL;
	        throw new ProtocolException();		// wrong format
		}
		return non_secureUrl;			
	}
}
