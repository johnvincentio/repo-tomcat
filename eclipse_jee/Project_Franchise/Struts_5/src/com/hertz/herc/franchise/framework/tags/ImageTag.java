
package com.hertz.herc.franchise.framework.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.hertz.herc.franchise.util.UtilHelper;

public class ImageTag extends TagSupport {
	private static final long serialVersionUID = 6412184388454325079L;

	private static final String IMAGE_PREFIX = "herc/franchise";
	private static String DEFAULT_DIALECT = "enUS";

	private String image;
	private String prefix;
	private boolean dialect;
	private String view;

	public void setDialect(boolean dialect) {this.dialect = dialect;}	
    public void setImage(String image) {this.image = image;}
    public void setPrefix(String prefix) {this.prefix = prefix;}
    public void setView (String view) {this.view = view;}

	public int doEndTag() throws JspException {
		try { 
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			String url;
			if (dialect) {
				if (view != null && view.length() > 0)
					url = UtilHelper.buildImagePath (request, IMAGE_PREFIX + "/" + prefix, image + "#view=" + view, DEFAULT_DIALECT);
				else
					url = UtilHelper.buildImagePath (request, IMAGE_PREFIX + "/" + prefix, image, DEFAULT_DIALECT);
			}
			else {
				if (view != null && view.length() > 0)
					url = UtilHelper.buildImagePath (request, IMAGE_PREFIX + "/" + prefix, image + "#view=" + view, null);
				else
					url = UtilHelper.buildImagePath (request, IMAGE_PREFIX + "/" + prefix, image, null);
			}
			pageContext.getOut().print(url);
		}
		catch (Exception e) { 
			throw new JspException(e);
		}
		return EVAL_PAGE;
	}
}
