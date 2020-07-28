package org.vladirius.classicmodel.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.vladirius.classicmodel.service.ProductsService;

@Controller
@RequestMapping("/products")
public class ProductsController {
	
	public static final String CATEGORIES =  "/cat";
	public static final String CATALOG = "catalog";
	
	@Autowired
	ProductsService productsService;
	
	@GetMapping("")
	public ModelAndView products() {
		ModelAndView modelAndView = new ModelAndView(CATALOG);
		modelAndView.addObject("products", productsService.getProducts());
		return modelAndView;
	}
	
	@PostMapping(CATEGORIES)
	public ModelAndView productsByCategories(@RequestParam("button") String categories) {
		ModelAndView modelAndView = new ModelAndView(CATALOG);
		modelAndView.addObject("products", productsService.findProductsByCategories(categories));
		return modelAndView;
	}
	
}
