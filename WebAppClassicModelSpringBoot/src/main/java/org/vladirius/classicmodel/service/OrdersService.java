package org.vladirius.classicmodel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vladirius.classicmodel.data.models.CustomersEntity;
import org.vladirius.classicmodel.data.models.OrderdetailsEntity;
import org.vladirius.classicmodel.data.models.OrdersEntity;
import org.vladirius.classicmodel.data.repositories.OrderDetailsRepository;
import org.vladirius.classicmodel.data.repositories.OrdersRepository;
import org.vladirius.classicmodel.data.repositories.UserRepository;

@Service
public class OrdersService {
	@Autowired
	private OrdersRepository repo;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderDetailsRepository orderDetailsRepo;

	// Retrieve all orders
	public List<OrdersEntity> getOrders() {
		List<OrdersEntity> ordersList = new ArrayList<OrdersEntity>();
		for(OrdersEntity order: repo.findAll()) {
			ordersList.add(order);
		}
		return ordersList;
	}
	
	// Retrieve orders from one client
	public List<OrdersEntity>getOrdersByClient(String username){
		// Create empty model
		CustomersEntity client = new CustomersEntity();
		
		//Load user details in the model equals to the logged account
		client.setCustomerNumber(userRepository.getUserByUsername(username).getCustomerNumber().getCustomerNumber());
		
		//Use the CustomerNumber of the client retrieve
		List<OrdersEntity> ordersList = new ArrayList<OrdersEntity>();
		for(OrdersEntity order: repo.findOrdersByClient(client.getCustomerNumber())) {
			ordersList.add(order);
		}
		return ordersList;
	}
	
	// Retrieve details of one order
	public List<OrderdetailsEntity> getOneOrderDetails(int orderNumber){
		List<OrderdetailsEntity> orderDetails = new ArrayList<OrderdetailsEntity>();
		for(OrderdetailsEntity line : orderDetailsRepo.detailsOrderByOrderNumber(orderNumber)) {
			orderDetails.add(line);
		}
		return orderDetails;
	}

}
