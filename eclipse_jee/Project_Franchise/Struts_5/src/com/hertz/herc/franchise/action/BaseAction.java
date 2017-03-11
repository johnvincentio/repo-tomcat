
package com.hertz.herc.franchise.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.hertz.herc.franchise.util.LogBroker;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements ServletRequestAware, ServletResponseAware, RequestAware, SessionAware {
	private static final long serialVersionUID = -5133012114700775557L;
	private static Class<?> classRef = BaseAction.class;
/*
 * Handle HttpServletRequest
 */
	private HttpServletRequest servletRequest;
	public HttpServletRequest getServletRequest () {
		return servletRequest;
	}
	public void setServletRequest (HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}

/*
 * Handle HttpServletResponse
 */
	private HttpServletResponse servletResponse;
	public HttpServletResponse getServletResponse () {
		return servletResponse;
	}
	public void setServletResponse (HttpServletResponse servletResponse) {
		this.servletResponse = servletResponse;
	}

/*
 * Handle Request
 */
	private Map<String, Object> request;

//	public Map getRequest() {return request;}
	public void setRequest (Map<String, Object> request) {
		this.request = request;
	}

	public void addRequest (String key, Object obj) {
		LogBroker.debug (classRef, ">>> BaseAction::addRequest, key :" + key + ":");
		request.put (key, obj);
		LogBroker.debug (classRef, "<<< BaseAction::addRequest ");
	}

	public Object getRequest (String key) {
		return request.get (key);
	}

/*
 * handle session
 */
	private Map<String, Object> session;

	public Map<String, Object> getSession () {
		return session;
	}

	public void setSession (Map<String, Object> session) {
		this.session = session;
	}

	public void addSession (String key, Object obj) {
		LogBroker.debug (classRef, ">>> BaseAction::addSession, key :" + key + ":");
		session.put (key, obj);
		LogBroker.debug (classRef, "<<< BaseAction::addSession ");
	}

	public Object getSession (String key) {
		return session.get (key);
	}

	public Object getSessionClear (String key) {
		Object obj = session.get (key);
		session.remove (key);
		return obj;
	}

/*
 * Handle Parameters
 */
	public String getParameter (String key) {
		return getServletRequest ().getParameter (key);
	}

	/**
	 * Execute; tasks performed for all Application Action classes
	 */
	public void task () {
		LogBroker.debug (classRef, ">>> BaseAction::task");
//		JVRequest.getInstance().showAll (getServletRequest(), "BaseAction::execute");
		LogBroker.debug (classRef, "<<< BaseAction::task");
	}

	/**
	 * Get Action name
	 * 
	 * @return Action name
	 */
	public String getAppActionName () {
		LogBroker.debug (classRef, ">>> BaseAction::getAppActionName");
		ActionContext actionContext = ActionContext.getContext ();
		ActionInvocation actionInvocation = actionContext.getActionInvocation ();
		LogBroker.debug (classRef, "<<< BaseAction::getAppActionName");
		return actionInvocation.getProxy ().getActionName ();
	}

	/**
	 * Get Action namespace
	 * 
	 * @return Action namespace
	 */
	public String getAppActionNamespace () {
		LogBroker.debug (classRef, ">>> BaseAction::getAppActionNamespace");
		ActionContext actionContext = ActionContext.getContext ();
		ActionInvocation actionInvocation = actionContext.getActionInvocation ();
		LogBroker.debug (classRef, "<<< BaseAction::getAppActionNamespace");
		return actionInvocation.getProxy ().getNamespace ();
	}
}
