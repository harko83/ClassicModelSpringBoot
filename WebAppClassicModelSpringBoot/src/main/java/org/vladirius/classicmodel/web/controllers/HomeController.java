package org.vladirius.classicmodel.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.vladirius.classicmodel.annotation.PageTitle;

@Controller
public class HomeController extends BaseController {
	
	@GetMapping("/")
	@PageTitle("Index")
	public ModelAndView index() {
		return view("index");
	}
	
//	@GetMapping("/home")
//	public ModelAndView home() {
//		return view("home");
//	}
	
	@GetMapping("/contact")
	public ModelAndView contact() {
		return view("contact");
	}
}
