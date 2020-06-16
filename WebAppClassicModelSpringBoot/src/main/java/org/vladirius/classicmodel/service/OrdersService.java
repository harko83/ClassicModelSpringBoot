package org.vladirius.classicmodel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vladirius.classicmodel.data.models.OrdersEntity;
import org.vladirius.classicmodel.data.repositories.OrdersRepository;

@Service
public class OrdersService {
	@Autowired
	private OrdersRepository repo;

	public List<OrdersEntity> getOrders() {
		List<OrdersEntity> ordersList = new ArrayList<OrdersEntity>();
		for(OrdersEntity order: repo.findAll()) {
			ordersList.add(order);
		}
		return ordersList;
	}

}
