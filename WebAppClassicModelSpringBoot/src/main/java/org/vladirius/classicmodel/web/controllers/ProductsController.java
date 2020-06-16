package org.vladirius.classicmodel.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.vladirius.classicmodel.service.ProductsService;

@Controller
public class ProductsController {
	@Autowired
	ProductsService productsService;
	
	@GetMapping("/products")
	public ModelAndView products() {
		ModelAndView modelAndView = new ModelAndView("catalog");
		modelAndView.addObject("products", productsService.getProducts());
		return modelAndView;
	}
}
