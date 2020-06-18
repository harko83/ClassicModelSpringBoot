package org.vladirius.classicmodel.service;

import java.util.ArrayList;
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
		List<ProductsEntity> productsList = new ArrayList<ProductsEntity>();
		for(ProductsEntity product: repo.findAll()) {
			productsList.add(product);
		}
		return productsList;
	}
	
	public List<ProductsEntity> findProductsByCategories(String productLines) {
		List<ProductsEntity> productsByCat = new ArrayList<ProductsEntity>();
		for(ProductsEntity productbycat : repo.findProductsByCategories(productLines)) {
			productsByCat.add(productbycat);
		}
		return productsByCat;
	}
}
