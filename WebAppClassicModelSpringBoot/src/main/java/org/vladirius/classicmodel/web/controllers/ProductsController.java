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
	public static final String CLASSIC_CARS_URL =  "/ClassicCars";
	public static final String MOTORCYCLES_URL =  "/Motorcycles";
	public static final String PLANES_URL =  "/Planes";
	public static final String SHIPS_URL =  "/Ships";
	public static final String TRAINS_URL =  "/Trains";
	public static final String TRUCKSANDBUSES_URL =  "/TrucksAndBuses";
	public static final String VINTAGECARS_URL =  "/VintageCars";
	public static final String CATALOG = "catalog";
	
	@Autowired
	ProductsService productsService;
	
	@GetMapping("")
	public ModelAndView products() {
		ModelAndView modelAndView = new ModelAndView(CATALOG);
		modelAndView.addObject("products", productsService.getProducts());
		return modelAndView;
	}
	
	@PostMapping(CLASSIC_CARS_URL)
	public ModelAndView productsByCars(@RequestParam("button") String categories) {
		ModelAndView modelAndView = new ModelAndView(CATALOG);
		modelAndView.addObject("products", productsService.findProductsByCategories(categories));
		return modelAndView;
	}
	
	@PostMapping(MOTORCYCLES_URL)
	public ModelAndView productsByMoto(@RequestParam("button") String categories) {
		ModelAndView modelAndView = new ModelAndView(CATALOG);
		modelAndView.addObject("products", productsService.findProductsByCategories(categories));
		return modelAndView;
	}
	
	@PostMapping(PLANES_URL)
	public ModelAndView productsByPlanes(@RequestParam("button") String categories) {
		ModelAndView modelAndView = new ModelAndView(CATALOG);
		modelAndView.addObject("products", productsService.findProductsByCategories(categories));
		return modelAndView;
	}
	
	@PostMapping(SHIPS_URL)
	public ModelAndView productsByShips(@RequestParam("button") String categories) {
		ModelAndView modelAndView = new ModelAndView(CATALOG);
		modelAndView.addObject("products", productsService.findProductsByCategories(categories));
		return modelAndView;
	}
	
	@PostMapping(TRAINS_URL)
	public ModelAndView productsByTrains(@RequestParam("button") String categories) {
		ModelAndView modelAndView = new ModelAndView(CATALOG);
		modelAndView.addObject("products", productsService.findProductsByCategories(categories));
		return modelAndView;
	}
	
	@PostMapping(TRUCKSANDBUSES_URL)
	public ModelAndView productsByTruckAndBuses(@RequestParam("button") String categories) {
		ModelAndView modelAndView = new ModelAndView(CATALOG);
		modelAndView.addObject("products", productsService.findProductsByCategories(categories));
		return modelAndView;
	}
	@PostMapping(VINTAGECARS_URL)
	public ModelAndView productsByVintageCars(@RequestParam("button") String categories) {
		ModelAndView modelAndView = new ModelAndView(CATALOG);
		modelAndView.addObject("products", productsService.findProductsByCategories(categories));
		return modelAndView;
	}
}
