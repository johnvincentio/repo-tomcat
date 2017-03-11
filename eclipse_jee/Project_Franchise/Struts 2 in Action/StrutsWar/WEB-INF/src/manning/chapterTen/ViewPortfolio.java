package manning.chapterTen;


import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import manning.utils.Portfolio;
import manning.utils.PortfolioServiceInterface;
import manning.utils.User;

import com.opensymphony.xwork2.ActionSupport;

/*
 * This action retrieves the data model for viewing a particular portfolio. 
 */

public class ViewPortfolio extends ActionSupport  {

	public String execute(){
		
		setPortfolio(  getPortfolioService().getPortfolio(id) );
		System.out.println("Portfoli pics = " + portfolio.getPics().size());
		
		return SUCCESS;
	}

	/* JavaBeans Properties to Receive Request Parameters */
	
	private Long id;
	private Portfolio portfolio;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}
		
	/*
	 * Field with getter and setter for PortfolioService object, which will be injected
	 * via Spring.	
	 */
	
	PortfolioServiceInterface portfolioService;

	public PortfolioServiceInterface getPortfolioService( ) 	{
		
		return portfolioService;
	
	}
	
	public void setPortfolioService(PortfolioServiceInterface portfolioService) {
		this.portfolioService = portfolioService;
	}
	
	

}
