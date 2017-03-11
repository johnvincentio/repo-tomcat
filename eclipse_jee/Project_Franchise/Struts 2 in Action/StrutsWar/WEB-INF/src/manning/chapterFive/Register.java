package manning.chapterFive;


import manning.chapterFive.utils.PortfolioService;
import manning.chapterFive.utils.User;

import com.opensymphony.xwork2.ActionSupport;

/*
 *	Register with domain object backed JavaBeans property to receive data.
 *   
 */

public class Register extends ActionSupport {
	


	public String execute(){
		
		getPortfolioService().createAccount( user ); 
		
		return SUCCESS;
	}
	
	/* Expose our domain object as a JavaBeans property for data transfer. */
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void validate(){
		
		/* Retrieve our simple portfolio service object. */
		PortfolioService ps = getPortfolioService();
		
		/* Check that fields are not empty */
		if ( user.getPassword().length() == 0 ){			
			addFieldError( "password", getText("password.required") );
		}
		if ( user.getUsername().length() == 0 ){			
			addFieldError( "username", getText("username.required") );
		}
		if ( user.getPortfolioName().length() == 0  ){			
			addFieldError( "portfolioName", getText( "portfolioName.required" ));
		}
		if ( user.getBirthday() == null  ){			
			addFieldError( "birthday", getText( "birthday.required" ));
		}
		if ( user.getAge() == null  ){			
			addFieldError( "age", getText( "age.required" ));
		}
		
		
		/* Make sure user doesn't already have an account */
		if ( ps.userExists( user.getUsername() ) ){		
			addFieldError("username", getText( "user.exists"));
		}
		
	}
	
	public PortfolioService getPortfolioService( ) 	{
		
		return new PortfolioService();
		
	}

}
