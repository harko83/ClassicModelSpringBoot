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
	
	@Query(value = "SELECT * from employees WHERE firstName = ?1", nativeQuery = true)
	EmployeesEntity findByLastName(@Param("firstName")String lastName);
	
	@Query(value = "SELECT * from employees WHERE reportsTo = ?1", nativeQuery = true)
	List<EmployeesEntity> findByReportsTo(@Param("employeeNumber")Long managerEmpNumber);

}
