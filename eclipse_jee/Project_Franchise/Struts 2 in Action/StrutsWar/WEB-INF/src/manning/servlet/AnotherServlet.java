package manning.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.ActionContext;

public class AnotherServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType( "text/html");
		response.getOutputStream().println( "<html>");
		response.getOutputStream().println( "<head>");
		response.getOutputStream().println( "</head>");
		response.getOutputStream().println( "<body>");
		response.getOutputStream().println( "<h5>");
		response.getOutputStream().println( "<hr/>");
		response.getOutputStream().println("<p>Hello from anotherServlet's doPost()</p>");
		response.getOutputStream().println("<p>Attribute set in the struts 2 action = " + request.getAttribute("attributeSetInS2Action" ) + "</p>");
		response.getOutputStream().println("<p>Favorite color from request parameters = " + request.getParameter("favoriteColor") + "</p>");
		String propertyFromAction = (String) ActionContext.getContext().getValueStack().findValue("testProperty");
		response.getOutputStream().println("<p>Value retrieved from action property on ValueStack = " + propertyFromAction + "</p>");
		response.getOutputStream().println( "<hr/>");
		response.getOutputStream().println( "</h5>");
		response.getOutputStream().println( "</body>");
		response.getOutputStream().println( "</html>");	
	}	
}
