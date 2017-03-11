package com.idc.controller.annotation;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.idc.data.Student;
import com.idc.editor.StudentNameEditor;

@Controller
public class StudentAdmissionController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
//		binder.setDisallowedFields(new String[] {"studentMobile"});		// disables validation of selected fields

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy***MM***dd");
		binder.registerCustomEditor (Date.class, "studentDOB", new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor (String.class, "studentName", new StudentNameEditor());
	}
	@ModelAttribute
	public void addingCommonObjects (Model model1) {
		model1.addAttribute("privateMessage", "Private and Confidential");
	}

// http://localhost:8080/Spring_MVC_5a/admissionForm.html
	@RequestMapping(value="/admissionForm.html", method=RequestMethod.GET)
	public ModelAndView getAdmissionForm() {
		System.out.println(">>> StudentAdmissionController::getAdmissionForm");
		ModelAndView model = new ModelAndView ("AdmissionForm");
		model.addObject ("headerMessage", "Admission submission system");
		System.out.println("<<< StudentAdmissionController::getAdmissionForm");
		return model;
	}

// http://localhost:8080/Spring_MVC_5a/submitAdmissionForm.html
	@RequestMapping(value="/submitAdmissionForm.html", method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm (@Valid @ModelAttribute("student1") Student student, BindingResult result) {
		System.out.println(">>> StudentAdmissionController::submitAdmissionForm");
		if (result.hasErrors()) {
			ModelAndView model = new ModelAndView ("AdmissionForm");
			return model;
		}
		ModelAndView model = new ModelAndView ("AdmissionSuccess");
		model.addObject ("msg", "Admission submitted");
		System.out.println("<<< StudentAdmissionController::submitAdmissionForm");
		return model;
	}
}
