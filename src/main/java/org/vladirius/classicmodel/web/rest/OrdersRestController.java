package org.vladirius.classicmodel.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vladirius.classicmodel.data.models.OrdersEntity;
import org.vladirius.classicmodel.service.OrdersService;

@RestController
public class OrdersRestController {
	@Autowired
	private OrdersService service;
	
	@RequestMapping("/rest/orders")
	public List<OrdersEntity> getOrders(){
		return service.getOrders();
	}
}
