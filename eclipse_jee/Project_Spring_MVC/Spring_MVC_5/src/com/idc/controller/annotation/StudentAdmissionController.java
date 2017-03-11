package com.idc.controller.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.idc.data.Student;

@Controller
public class StudentAdmissionController {

	@ModelAttribute
	public void addingCommonObjects (Model model1) {
		model1.addAttribute("privateMessage", "Private and Confidential");
	}

// http://localhost:8080/Spring_MVC_5/admissionForm.html
	@RequestMapping(value="/admissionForm.html", method=RequestMethod.GET)
	public ModelAndView getAdmissionForm() {
		System.out.println(">>> StudentAdmissionController::getAdmissionForm");
		ModelAndView model = new ModelAndView ("AdmissionForm");
		model.addObject ("headerMessage", "Admission submission system");
		System.out.println("<<< StudentAdmissionController::getAdmissionForm");
		return model;
	}

// http://localhost:8080/Spring_MVC_5/submitAdmissionForm.html
	@RequestMapping(value="/submitAdmissionForm.html", method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm (@RequestParam("studentName") String name, 
											@RequestParam(value="studentHobby", defaultValue="Football") String hobby) {
		System.out.println(">>> StudentAdmissionController::submitAdmissionForm");
		Student student = new Student();
		student.setStudentName(name);
		student.setStudentHobby(hobby);
		ModelAndView model = new ModelAndView ("AdmissionSuccess");
		model.addObject ("msg", "Details; Name "+name+" Hobby "+hobby);
		model.addObject ("student1", student);
		System.out.println("<<< StudentAdmissionController::submitAdmissionForm");
		return model;
	}

// http://localhost:8080/Spring_MVC_5/submitAdmissionForm2.html
	@RequestMapping(value="/submitAdmissionForm2.html", method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm2 (@ModelAttribute("student1") Student student1) {
		System.out.println(">>> StudentAdmissionController::submitAdmissionForm2");
		ModelAndView model = new ModelAndView ("AdmissionSuccess");
		model.addObject ("msg", "Admission submitted");
		System.out.println("<<< StudentAdmissionController::submitAdmissionForm2");
		return model;
	}
}
