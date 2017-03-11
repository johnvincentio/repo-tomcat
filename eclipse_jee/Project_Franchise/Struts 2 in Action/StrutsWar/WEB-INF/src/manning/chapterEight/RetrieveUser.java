package manning.chapterEight;

import manning.chapterEight.utils.PortfolioService;
import manning.chapterEight.utils.User;

import com.opensymphony.xwork2.ActionSupport;

/*
 *
 */

public class RetrieveUser extends ActionSupport {

	public String execute() {

		User user = getPortfolioService().getUser(getUsername());
		setJsonModel(user);

		return SUCCESS;
	}

	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private Object jsonModel;

	public Object getJsonModel() {
		return jsonModel;
	}

	public void setJsonModel(Object jsonModel) {
		this.jsonModel = jsonModel;
	}

	/*
	 * Simple way to retrieve our business logic and data persistence object.
	 * Late versions of the portfolio app will integrate with more
	 * sophisticated technologies for these services.
	 */
	public PortfolioService getPortfolioService() {

		return new PortfolioService();

	}

}
