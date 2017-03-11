package com.example.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

@Namespace("/custom")
public class AbcAction extends ActionSupport {
	private static final long serialVersionUID = 9199709760172632019L;

	@Action("different/url")
	public String execute() {
		System.out.println("in AbcAction::execute");
		return SUCCESS;
	}

	@Action(value = "url", 
		results = { @Result(name = "success", location = "http://struts.apache.org", type = "redirect") }
	)
	public String doSomething() {
		System.out.println("in AbcAction::doSomething");
		return SUCCESS;
	}
}
