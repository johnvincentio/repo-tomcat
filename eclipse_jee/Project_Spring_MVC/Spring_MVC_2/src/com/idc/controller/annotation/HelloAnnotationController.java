package com.idc.controller.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class HelloAnnotationController {

	@RequestMapping(value="/welcome2", method=GET)
//	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome (ModelMap model) {
		System.out.println(">>> HelloAnnotationController::printWelcome");
		model.addAttribute("welcomeMessage", "Spring 3 MVC Hello World");
		String nextPage = "HelloPage";
		System.out.println("<<< HelloAnnotationController::printWelcome");
		return nextPage;
	}
}
