package org.vladirius.classicmodel.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.vladirius.classicmodel.data.models.EmployeesEntity;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeesEntity, Long> {
	
	@Query(value = "SELECT * from employees WHERE officeCode = ?1", nativeQuery = true)
	List<EmployeesEntity> findByOfficeCode(@Param("officeCode")int officeCode);

}
