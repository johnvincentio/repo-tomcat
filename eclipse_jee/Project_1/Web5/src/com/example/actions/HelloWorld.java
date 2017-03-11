package com.example.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

// http://localhost:8080/CONTEXT/config-browser/index.action

// http://struts.apache.org/release/2.1.x/docs/convention-plugin.html
// the Convention plugin will find the class and map the URL /hello-world
/*
 @InterceptorRefs({
 @InterceptorRef("interceptor-1"),
 @InterceptorRef("defaultStack")
 })
 @Results({
  @Result(name="failure", location="fail.jsp")
})
The result for this class will be located in WEB-INF/jsps rather than the default of WEB-INF/content.
@ResultPath("/WEB-INF/jsps")
 */
public class HelloWorld extends ActionSupport {
	private static final long serialVersionUID = -6662538623355755690L;
	private String message;

	public String getMessage() {
		System.out.println("getMessage");
		return message;
	}

	public String execute() {
		message = "Hello Better World!";
		System.out.println("execute");
		return SUCCESS;
	}

	@Action("/different/url")
	public String doUrl() {
		System.out.println("doUrl");
		return SUCCESS;
	}

	@Action("url")
	public String doSomething() {
		System.out.println("in HelloWorld::doSomething");
		return SUCCESS;
	}

	@Action(value = "action2")
	// All interceptors from defaultStack will be applied to "action2
	public String doSomething2() {
		System.out.println("doSomething2");
		return SUCCESS;
	}

	// The following interceptors will be applied to "action1": interceptor-1,
	// all interceptors from defaultStack, validation.
	@Action(value = "action1", interceptorRefs = @InterceptorRef("validation"))
	public String doPart1() {
		System.out.println("doPart1");
		return SUCCESS;
	}

	@Action(value = "/different/url-part2", 
		results = { @Result(name = "success", location = "http://struts.apache.org", type = "redirect") }
	)
	public String doPart2() {
		System.out.println("doPart2");
		return SUCCESS;
	}

	@Action(value = "/different/url-part3", 
		results={@Result(name="success", type="httpheader", params={"status", "500", "errorMessage", "Internal Error"})}
	)
	public String doPart3() {
		System.out.println("doPart3");
		return SUCCESS;
	}
}
