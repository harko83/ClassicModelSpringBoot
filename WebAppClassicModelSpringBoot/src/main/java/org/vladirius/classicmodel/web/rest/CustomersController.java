package org.vladirius.classicmodel.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vladirius.classicmodel.data.models.CustomersEntity;
import org.vladirius.classicmodel.web.services.CustomersService;

@RestController
public class CustomersController {
	@Autowired
	private CustomersService service;
	
	@RequestMapping("/customers")
	public List<CustomersEntity> getCustomers(){
		return service.getCustomers();
	}
}
