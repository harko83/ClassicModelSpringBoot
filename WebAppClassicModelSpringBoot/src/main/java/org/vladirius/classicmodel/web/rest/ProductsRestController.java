package org.vladirius.classicmodel.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vladirius.classicmodel.data.models.ProductsEntity;
import org.vladirius.classicmodel.service.ProductsService;

@RestController
public class ProductsRestController {
	@Autowired
	private ProductsService service;

	@RequestMapping("/rest/products")
	public List<ProductsEntity> getProducts(){
		return service.getProducts();
	}
}
