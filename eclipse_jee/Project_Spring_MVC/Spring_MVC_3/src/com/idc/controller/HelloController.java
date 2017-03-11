package com.idc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal (HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("HelloController::handleRequestInternal");
		ModelAndView modelAndView = new ModelAndView ("HelloPage");
		modelAndView.addObject("welcomeMessage", "Hi User");
		return modelAndView;
	}
}

