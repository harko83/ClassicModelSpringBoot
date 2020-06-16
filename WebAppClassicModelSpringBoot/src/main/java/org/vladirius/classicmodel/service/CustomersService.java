package org.vladirius.classicmodel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vladirius.classicmodel.data.models.CustomersEntity;
import org.vladirius.classicmodel.data.repositories.CustomerRepository;

@Service
public class CustomersService {
	@Autowired
	private CustomerRepository repo;
	
	public List<CustomersEntity> getCustomers() {
		List<CustomersEntity> customersList = new ArrayList<CustomersEntity>();
		for(CustomersEntity customer: repo.findAll()) {
			customersList.add(customer);
		}
		return customersList;
	}
}
