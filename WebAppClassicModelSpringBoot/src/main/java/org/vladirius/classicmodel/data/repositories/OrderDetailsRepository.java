package org.vladirius.classicmodel.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.vladirius.classicmodel.data.models.OrderdetailsEntity;

@Repository
public interface OrderDetailsRepository extends CrudRepository<OrderdetailsEntity, Integer> {
	
	@Query(value = "SELECT * FROM ordersdetails WHERE orderNumber = ?1 ORDER BY orderLineNumber", nativeQuery = true)
	List<OrderdetailsEntity> detailsOrderByOrderNumber(@Param("orderNumber") int orderNumber);

}
