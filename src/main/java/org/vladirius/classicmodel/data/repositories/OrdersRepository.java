package org.vladirius.classicmodel.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.vladirius.classicmodel.data.models.OrdersEntity;

@Repository
public interface OrdersRepository extends CrudRepository<OrdersEntity, Long>{
	
	@Query(value = "SELECT * FROM orders WHERE customerNumber = ?1", nativeQuery = true)
	List<OrdersEntity> findOrdersByClient(@Param("customerNumber") Long customerNumber);
}
