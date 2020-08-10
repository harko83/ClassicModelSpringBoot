package org.vladirius.classicmodel.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.vladirius.classicmodel.service.CustomersService;
import org.vladirius.classicmodel.service.OrdersService;

@Controller
@RequestMapping("/client")
public class ClientController {
	public static final String ACCOUNT = "clientAccount";
	public static final String ORDERS = "orders";
	
	@Autowired
	CustomersService customersService;
	
	@Autowired
	OrdersService ordersService;
	
	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public ModelAndView account(@RequestParam("clientID") String username) {
		ModelAndView mav = new ModelAndView(ACCOUNT);
		mav.addObject("client", customersService.findOne(username));
		mav.addObject("orders", ordersService.getOrdersByClient(username));
		return mav;
	}
	
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public ModelAndView orders(@RequestParam("orderNumber") int orderNumber) {
		ModelAndView mav = new ModelAndView(ORDERS);
		mav.addObject("order", ordersService.getOneOrderDetails(orderNumber));
		return mav;
	}

}
