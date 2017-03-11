package manning.chapterFive;

import java.util.List;
import java.util.Map;

import manning.chapterFive.utils.User;

import com.opensymphony.xwork2.ActionSupport;

/*
 *	This action serves to demo the many styles of configuring JavaBeans properties
 *	to receive data from the OGNL expressions in our forms.  
 */

public class DataTransferTest extends ActionSupport {

	public String execute() {

		return SUCCESS;
	}

	/* An array of ages as Double data type */

	private Double[] ages;

	public Double[] getAges() {
		return ages;
	}

	public void setAges(Double[] ages) {
		this.ages = ages;
	}

	/* An array of Strings */

	private String[] names = new String[10];

	public String[] getNames() {
		return names;
	}

	public void setNames(String[] names) {
		this.names = names;
	}

	/* A list of names */

	private List lastNames;

	public List getLastNames() {
		return lastNames;
	}

	public void setLastNames(List lastNames) {
		this.lastNames = lastNames;
	}

	/* A list of middleNames */

	private List middleNames;

	public List getMiddleNames() {
		return middleNames;
	}

	public void setMiddleNames(List middleNames) {
		this.middleNames = middleNames;
	}

	/* A list of weights */

	private List weights;

	public List getWeights() {
		return weights;
	}

	public void setWeights(List weight) {
		this.weights = weight;
	}

	/*
	 * A list of User objects. The DataTransferTest_conversion.properties file,
	 * in this package, describes the type for this list.
	 */

	private List users;

	public List getUsers() {
		return users;
	}

	public void setUsers(List users) {
		this.users = users;
	}

	private Map myUsers;

	public Map getMyUsers() {
		return myUsers;
	}

	public void setMyUsers(Map myUsers) {
		this.myUsers = myUsers;
	}

	private Map myOrderedUsers;

	public Map getMyOrderedUsers() {
		return myOrderedUsers;
	}

	public void setMyOrderedUsers(Map myOrderedUsers) {
		this.myOrderedUsers = myOrderedUsers;
	}

	private Map maidenNames;

	public Map getMaidenNames() {
		return maidenNames;
	}

	public void setMaidenNames(Map maidenNames) {
		this.maidenNames = maidenNames;
	}

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private boolean trueOrFalse;

	public boolean isTrueOrFalse() {
		return trueOrFalse;
	}

	public void setTrueOrFalse(boolean trueOrFalse) {
		this.trueOrFalse = trueOrFalse;
	}

	private char aLetter;

	public char getALetter() {
		return aLetter;
	}

	public void setALetter(char letter) {
		aLetter = letter;
	}

}
