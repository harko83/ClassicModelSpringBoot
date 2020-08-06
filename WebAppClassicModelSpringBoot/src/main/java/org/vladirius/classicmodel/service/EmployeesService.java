package org.vladirius.classicmodel.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.vladirius.classicmodel.data.models.EmployeesEntity;
import org.vladirius.classicmodel.data.repositories.EmployeeRepository;
import org.vladirius.classicmodel.data.repositories.UserRepository;

@Service
public class EmployeesService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	//Retrieve all employees
	public List<EmployeesEntity> getEmployees(){
		return (List<EmployeesEntity>) employeeRepository.findAll();
	}
	
	//Retrieve employees by office
	public List<EmployeesEntity> getEmployeesByOffice(int officeCode){
		return employeeRepository.findByOfficeCode(officeCode);
	}
	
	//Create new employee
	public void addEmployee(EmployeesEntity employees) {
		employeeRepository.save(employees);
	}
	//Retrieve employees by reportTo
	public List<EmployeesEntity> getManagerEmployeesList(String managerName) {
		//Create an empty model
		EmployeesEntity manager = new EmployeesEntity();
		
		//Load user details in the model equals to the logged account
		manager.setEmployeeNumber(userRepository.getUserByUsername(managerName).getEmployeeNumber().getEmployeeNumber());
		
		//Use the EmployeeNumber of the manager for the reportTo list
		List<EmployeesEntity> reportsToList = new ArrayList<EmployeesEntity>();
		for(EmployeesEntity employee: employeeRepository.findByReportsTo(manager.getEmployeeNumber())) {
			reportsToList.add(employee);
		}
		
		return reportsToList;
	}

}
