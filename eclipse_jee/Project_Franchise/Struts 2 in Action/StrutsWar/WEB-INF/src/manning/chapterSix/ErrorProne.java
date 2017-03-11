package manning.chapterSix;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;


/*
 * This action does nothing but throw an exception.  Everytime.
 */

public class ErrorProne  
{
	public String execute() throws Exception{
		
		/*
		 * Encounter unforeseen problem in processing.
		 */
		
		throw new Exception ( "Routine Code Explosion");
		
	}

}
