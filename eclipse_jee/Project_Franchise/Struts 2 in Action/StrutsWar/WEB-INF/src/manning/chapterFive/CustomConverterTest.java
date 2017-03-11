package manning.chapterFive;

import manning.chapterFive.utils.Circle;

import com.opensymphony.xwork2.ActionSupport;

/*
 *	This action serves to demo the many styles of configuring JavaBeans properties
 *	to receive data from the OGNL expressions in our forms.  
 */

public class CustomConverterTest extends ActionSupport {

	public String execute() {

		System.out.println("Circle = " + circle.getRadius());

		return SUCCESS;
	}

	/* Circle Property */

	private Circle circle;

	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}

}
