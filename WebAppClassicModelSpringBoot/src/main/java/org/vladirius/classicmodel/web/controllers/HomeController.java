package org.vladirius.classicmodel.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController {
	
	@GetMapping("/")
	public ModelAndView index() {
		return view("index");
	}
	
	@GetMapping("/home")
	public ModelAndView home() {
		return view("home");
	}
	
}
