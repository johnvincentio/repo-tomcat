package com.idc.controller.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class HelloAnnotationController {

// http://localhost:8080/Spring_MVC_4/hello
	@RequestMapping(value="/hello", method=GET)
	public String hello (ModelMap model) {
		System.out.println(">>> HelloAnnotationController::hello");
		model.addAttribute("welcomeMessage", "HelloAnnotationController::hello");
		String nextPage = "HelloPage";
		System.out.println("<<< HelloAnnotationController::hello");
		return nextPage;
	}

// http://localhost:8080/Spring_MVC_4/hello2
	@RequestMapping(value="/hello2", method=GET)
	public String hello2 (ModelMap model) {
		System.out.println(">>> HelloAnnotationController::hello2");
		model.addAttribute("welcomeMessage", "HelloAnnotationController::hello2");
		String nextPage = "HelloPage";
		System.out.println("<<< HelloAnnotationController::hello2");
		return nextPage;
	}
}
