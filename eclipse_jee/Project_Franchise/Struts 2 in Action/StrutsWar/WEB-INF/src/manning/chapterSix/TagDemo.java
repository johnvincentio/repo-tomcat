package manning.chapterSix;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import manning.chapterSix.utils.PortfolioService;
import manning.chapterSix.utils.User;

import com.opensymphony.xwork2.ActionSupport;

/*
 * This action provides a list of portfolios available for viewing.
 */

public class TagDemo  extends ActionSupport
{
	public String execute() throws Exception {
		
		setUsers( getPortfolioService().getUsers() );
		setFirstUser();
		
		return SUCCESS;
	}

	
	private void setFirstUser() {
		for (Iterator iter = getUsers().iterator(); iter.hasNext();) {
			setUser( (User) iter.next() );
			break;
		}
		
	}


	/* JavaBeans Properties to be accessed via the valueStack */
	
	private User user;
	
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	private Collection users;


	public Collection getUsers() {
		return users;
	}


	public void setUsers(Collection users) {
		this.users = users;
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
