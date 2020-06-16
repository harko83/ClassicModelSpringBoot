package org.vladirius.classicmodel.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vladirius.classicmodel.data.models.ProductsEntity;
import org.vladirius.classicmodel.web.services.ProductsService;

@RestController
public class ProductsController {
	@Autowired
	private ProductsService service;

	@RequestMapping("/products")
	public List<ProductsEntity> getProducts(){
		return service.getProducts();
	}
}
