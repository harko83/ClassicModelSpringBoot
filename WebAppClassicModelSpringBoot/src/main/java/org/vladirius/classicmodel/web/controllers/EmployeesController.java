package org.vladirius.classicmodel.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.vladirius.classicmodel.service.EmployeesService;

@Controller
@RequestMapping("/employees")
public class EmployeesController {
	
	public static final String GLOBAL = "/global";
	public static final String BYOFFICE = "/byOffice";
	public static final String MANAGER = "/manager";
	public static final String EMPLOYEES = "employees";
	
	@Autowired
	EmployeesService employeesService;
	
	@GetMapping(GLOBAL)
	public ModelAndView displayAllEmployees() {
		ModelAndView mav = new ModelAndView(EMPLOYEES);
		mav.addObject("employees", employeesService.getEmployees());
		return mav;
	}
	
	@PostMapping(GLOBAL+BYOFFICE)
	public ModelAndView displayEmployeesByOffice(@RequestParam("button") int officeCode) {
		ModelAndView mav = new ModelAndView(EMPLOYEES);
		mav.addObject("employees", employeesService.getEmployeesByOffice(officeCode));
		return mav;
	}
}
