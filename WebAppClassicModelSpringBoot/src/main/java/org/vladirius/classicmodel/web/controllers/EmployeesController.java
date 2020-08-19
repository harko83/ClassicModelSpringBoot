package org.vladirius.classicmodel.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.vladirius.classicmodel.data.models.EmployeesEntity;
import org.vladirius.classicmodel.service.EmployeesService;

@Controller
@RequestMapping("/employees")
public class EmployeesController {
	//PATH
	public static final String GLOBAL = "/global";
	public static final String BYOFFICE = "/byOffice";
	public static final String ADD = "/addEmployee";
	public static final String MANAGER = "/manager";
	public static final String CLIENT = "/client";
	public static final String ADDCLIENT = "/addClient";
	public static final String ACCOUNT = "/account";
	
	//JSP
	public static final String EMPLOYEES = "employees";
	public static final String ADDEMPLOYEES = "addEmployee";
	public static final String VCLIENT = "client";
	public static final String VADDCLIENT = "addClient";
	public static final String VACCOUNT = "employeeAccount";
	
	@Autowired
	EmployeesService employeesService;
	
	//Show all employees
	@GetMapping(GLOBAL)
	public ModelAndView displayAllEmployees() {
		ModelAndView mav = new ModelAndView(EMPLOYEES);
		mav.addObject("employees", employeesService.getEmployees());
		return mav;
	}
	
	//Show employee by office
	@PostMapping(GLOBAL+BYOFFICE)
	public ModelAndView displayEmployeesByOffice(@RequestParam("button") int officeCode) {
		ModelAndView mav = new ModelAndView(EMPLOYEES);
		mav.addObject("employees", employeesService.getEmployeesByOffice(officeCode));
		return mav;
	}
	
	//show the employee form and also pass an empty backing bean object to store the form field values
	@GetMapping(GLOBAL+ADD)
	public ModelAndView contact() {
		return new ModelAndView(ADDEMPLOYEES, "NewEmployee", new EmployeesEntity());
	}
	
	//Get the form field values which are populated using the backing bean and store it in db
	@PostMapping(GLOBAL+ADD)
	public ModelAndView addNewEmployee(@ModelAttribute("NewEmployee") EmployeesEntity employeesEntity) {
		
		employeesService.addEmployee(employeesEntity);
		
		return new ModelAndView("redirect:/employees"+GLOBAL);
	}
	
	//Show all employees
	@GetMapping(MANAGER)
	public ModelAndView displayEmployeesFromManagerOffice(@RequestParam("button") String manager) {
		ModelAndView mav = new ModelAndView(EMPLOYEES);
		mav.addObject("employees", employeesService.getManagerEmployeesList(manager));
		return mav;
	}
	
	//Show employee account
	@GetMapping(ACCOUNT)
	public ModelAndView displayEmployeeAccount(@RequestParam("button") String employee) {
		ModelAndView mav = new ModelAndView(VACCOUNT);
		mav.addObject("accEmployee", employeesService.getEmployeeAccount(employee));
		return mav;
	}
}
