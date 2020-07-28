package org.vladirius.classicmodel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vladirius.classicmodel.data.models.EmployeesEntity;
import org.vladirius.classicmodel.data.repositories.EmployeeRepository;

@Service
public class EmployeesService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<EmployeesEntity> getEmployees(){
		return (List<EmployeesEntity>) employeeRepository.findAll();
	}
	
	public List<EmployeesEntity> getEmployeesByOffice(int officeCode){
		return employeeRepository.findByOfficeCode(officeCode);
	}
}
