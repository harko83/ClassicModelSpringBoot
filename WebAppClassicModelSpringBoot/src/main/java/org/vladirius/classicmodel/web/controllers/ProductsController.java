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
	@Autowired
	ProductsService productsService;
	
	@GetMapping("")
	public ModelAndView products() {
		ModelAndView modelAndView = new ModelAndView("catalog");
		modelAndView.addObject("products", productsService.getProducts());
		return modelAndView;
	}
	
	@PostMapping("/ClassicCars")
	public ModelAndView productsByCars(@RequestParam("button") String categories) {
		ModelAndView modelAndView = new ModelAndView("catalog");
		modelAndView.addObject("products", productsService.findProductsByCategories(categories));
		return modelAndView;
	}
	
	@PostMapping("/Motorcycles")
	public ModelAndView productsByMoto(@RequestParam("button") String categories) {
		ModelAndView modelAndView = new ModelAndView("catalog");
		modelAndView.addObject("products", productsService.findProductsByCategories(categories));
		return modelAndView;
	}
	
	@PostMapping("/Planes")
	public ModelAndView productsByPlanes(@RequestParam("button") String categories) {
		ModelAndView modelAndView = new ModelAndView("catalog");
		modelAndView.addObject("products", productsService.findProductsByCategories(categories));
		return modelAndView;
	}
	
	@PostMapping("/Ships")
	public ModelAndView productsByShips(@RequestParam("button") String categories) {
		ModelAndView modelAndView = new ModelAndView("catalog");
		modelAndView.addObject("products", productsService.findProductsByCategories(categories));
		return modelAndView;
	}
	
	@PostMapping("/Trains")
	public ModelAndView productsByTrains(@RequestParam("button") String categories) {
		ModelAndView modelAndView = new ModelAndView("catalog");
		modelAndView.addObject("products", productsService.findProductsByCategories(categories));
		return modelAndView;
	}
	
	@PostMapping("/TrucksAndBuses")
	public ModelAndView productsByTruckAndBuses(@RequestParam("button") String categories) {
		ModelAndView modelAndView = new ModelAndView("catalog");
		modelAndView.addObject("products", productsService.findProductsByCategories(categories));
		return modelAndView;
	}
	@PostMapping("/VintageCars")
	public ModelAndView productsByVintageCars(@RequestParam("button") String categories) {
		ModelAndView modelAndView = new ModelAndView("catalog");
		modelAndView.addObject("products", productsService.findProductsByCategories(categories));
		return modelAndView;
	}
}
