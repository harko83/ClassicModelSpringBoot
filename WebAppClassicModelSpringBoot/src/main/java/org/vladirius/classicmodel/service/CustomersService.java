package org.vladirius.classicmodel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vladirius.classicmodel.data.models.CustomersEntity;
import org.vladirius.classicmodel.data.repositories.CustomerRepository;
import org.vladirius.classicmodel.data.repositories.UserRepository;

@Service
public class CustomersService {
	@Autowired
	private CustomerRepository repo;
	
	@Autowired
	private UserRepository userRepository;
	
	// Retrieve all customers
	public List<CustomersEntity> getCustomers() {
		List<CustomersEntity> customersList = new ArrayList<CustomersEntity>();
		for(CustomersEntity customer: repo.findAll()) {
			customersList.add(customer);
		}
		return customersList;
	}
	
	// Retrieve one customer
	public CustomersEntity findOne(String username) {
		CustomersEntity client = new CustomersEntity();
		
		client.setCustomerNumber(userRepository.getUserByUsername(username).getCustomerNumber().getCustomerNumber());
		
		return repo.findOne(client.getCustomerNumber());
	}
}
