package org.vladirius.classicmodel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vladirius.classicmodel.data.models.ProductsEntity;
import org.vladirius.classicmodel.data.repositories.ProductRepository;

@Service
public class ProductsService  {
	
	@Autowired
	private ProductRepository repo;
	
	public List<ProductsEntity> getProducts(){
		return (List<ProductsEntity>) repo.findAll();
	}
	
	public List<ProductsEntity> findProductsByCategories(String productLines) {
		return repo.findProductsByCategories(productLines);
	}
}
