package manning.chapterSeven;


import java.util.Collection;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import manning.chapterSeven.utils.PortfolioService;
import manning.chapterSeven.utils.User;
import manning.chapterSeven.utils.Struts2PortfolioConstants;

import com.opensymphony.xwork2.ActionSupport;

/*
 * The SelectPortfolio action recieves the artist username from the list on
 * the PortfolioHomePage.  It then will retrieve the portfolios for that artist
 * to display.   
 */

public class SelectPortfolio extends ActionSupport {
	

	public String execute(){
		
		User user = getPortfolioService().getUser( getUsername()  ); 
		portfolios = user.getPortfolios().values();
		return SUCCESS;
	}
	
	/* JavaBeans Properties to Receive Request Parameters */
	
	private String username;
	private Collection portfolios;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public Collection getPortfolios(){
		return portfolios;
	}
	
	public void validate(){
		
		/* Retrieve our simple portfolio service object. */
		PortfolioService ps = getPortfolioService();
		
		if ( getUsername().length() == 0 ){			
			addFieldError( "username", getText("username.required") );
		}

	}
	
	/*  
	 * Simple way to retrieve our business logic and data peristence
	 * object.  Late versions of the portfolio app will intergrate with
	 * more sophisticated technologies for these services.
	 */
	public PortfolioService getPortfolioService( ) 	{
		
		return new PortfolioService();
		
	}

}
