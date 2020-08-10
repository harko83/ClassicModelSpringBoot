package org.vladirius.classicmodel.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.vladirius.classicmodel.service.CustomersService;

@Controller
@RequestMapping("/client")
public class ClientController {
	public static final String ACCOUNT = "clientAccount";
	
	@Autowired
	CustomersService customersService;
	
	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public ModelAndView account(@RequestParam("clientID") String username) {
		ModelAndView mav = new ModelAndView(ACCOUNT);
		mav.addObject("client", customersService.findOne(username));
		return mav;
	}

}
