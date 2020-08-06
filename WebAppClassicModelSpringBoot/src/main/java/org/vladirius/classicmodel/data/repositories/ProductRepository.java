package org.vladirius.classicmodel.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.vladirius.classicmodel.data.models.ProductsEntity;

@Repository
public interface ProductRepository extends CrudRepository<ProductsEntity, String> {
	
	@Query(value = "SELECT * FROM products WHERE productLine = ?1", nativeQuery = true)
	List<ProductsEntity> findProductsByCategories(@Param("productLine") String productLine);

	@Query(value = "SELECT * FROM products WHERE productCode = ?1", nativeQuery = true)
	ProductsEntity findOne(@Param("productCode") String productCode);
	
}
