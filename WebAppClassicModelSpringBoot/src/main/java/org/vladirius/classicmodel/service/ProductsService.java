package org.vladirius.classicmodel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vladirius.classicmodel.data.models.ProductsEntity;
import org.vladirius.classicmodel.data.repositories.ProductRepository;

@Service
@Transactional
public class ProductsService  {
	
	@Autowired
	private ProductRepository repo;
	
	public List<ProductsEntity> getProducts(){
		return (List<ProductsEntity>) repo.findAll();
	}
	
	public List<ProductsEntity> findProductsByCategories(String productLines) {
		return repo.findProductsByCategories(productLines);
	}
	
	public ProductsEntity find(String productCode) {
		return repo.findOne(productCode);
	}
	
}
