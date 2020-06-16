package org.vladirius.classicmodel.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.vladirius.classicmodel.data.models.ProductsEntity;

@Repository
public interface ProductRepository extends CrudRepository<ProductsEntity, String> {
	
}
