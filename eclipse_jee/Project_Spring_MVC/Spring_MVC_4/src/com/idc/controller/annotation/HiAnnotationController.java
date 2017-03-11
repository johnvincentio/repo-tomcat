package com.idc.controller.annotation;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/greet")
public class HiAnnotationController {

// http://localhost:8080/Spring_MVC_4/greet/hi
	@RequestMapping(value="/hi", method=RequestMethod.GET)
	public String hi (ModelMap model) {
		System.out.println(">>> HelloAnnotationController::hi");
		model.addAttribute("welcomeMessage", "HelloAnnotationController::hi");
		String nextPage = "HelloPage";
		System.out.println("<<< HelloAnnotationController::hi");
		return nextPage;
	}

// http://localhost:8080/Spring_MVC_4/greet/hi2
	@RequestMapping(value="/hi2", method=RequestMethod.GET)
	public String hi2 (ModelMap model) {
		System.out.println(">>> HelloAnnotationController::hi2");
		model.addAttribute("welcomeMessage", "HelloAnnotationController::hi2");
		String nextPage = "HelloPage";
		System.out.println("<<< HelloAnnotationController::hi2");
		return nextPage;
	}

	// http://localhost:8080/Spring_MVC_4/greet/hi3
	@RequestMapping(value="/hi3", method=RequestMethod.GET)
	public ModelAndView hi3() {
		System.out.println(">>> HelloAnnotationController::hi3");
		ModelAndView model = new ModelAndView ("HelloPage");
		model.addObject ("welcomeMessage", "HelloAnnotationController::hi3");
		System.out.println("<<< HelloAnnotationController::hi3");
		return model;
	}

	// http://localhost:8080/Spring_MVC_4/greet/hi/user/fred
	@RequestMapping(value="/hi/user/{id}", method=RequestMethod.GET)
	public ModelAndView hi4 (@PathVariable("id") String id) {
		System.out.println(">>> HelloAnnotationController::hi4; id "+id);
		ModelAndView model = new ModelAndView ("HelloPage");
		model.addObject ("welcomeMessage", "HelloAnnotationController::hi4; id = " + id);
		System.out.println("<<< HelloAnnotationController::hi4");
		return model;
	}

	// http://localhost:8080/Spring_MVC_4/greet/hi/bill/fred
	@RequestMapping(value="/hi/{user}/{id}", method=RequestMethod.GET)
	public ModelAndView hi5 (@PathVariable("user") String user, @PathVariable("id") String id) {
		System.out.println(">>> HelloAnnotationController::hi5; user "+user+" id "+id);
		ModelAndView model = new ModelAndView ("HelloPage");
		model.addObject ("welcomeMessage", "HelloAnnotationController::hi5; user "+user+" id "+id);
		System.out.println("<<< HelloAnnotationController::hi5");
		return model;
	}

	// http://localhost:8080/Spring_MVC_4/greet/hi/bill/fred
	@RequestMapping(value="/maps/{user}/{id}", method=RequestMethod.GET)
	public ModelAndView hi6 (@PathVariable Map<String, String> pathVars) {
		System.out.println(">>> HelloAnnotationController::hi6");
		String user = pathVars.get("user");
		String id = pathVars.get("id");
		ModelAndView model = new ModelAndView ("HelloPage");
		model.addObject ("welcomeMessage", "HelloAnnotationController::hi5; user "+user+" id "+id);
		System.out.println("<<< HelloAnnotationController::hi6");
		return model;
	}
}
