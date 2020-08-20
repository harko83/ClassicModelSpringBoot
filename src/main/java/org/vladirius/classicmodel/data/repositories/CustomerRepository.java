package org.vladirius.classicmodel.data.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.vladirius.classicmodel.data.models.CustomersEntity;

@Repository
public interface CustomerRepository extends CrudRepository<CustomersEntity	, Long> {

	@Query(value = "SELECT * FROM customers WHERE customerNumber = ?1", nativeQuery = true)
	CustomersEntity findOne(@Param("customerNumber") Long customerNumber);
}
