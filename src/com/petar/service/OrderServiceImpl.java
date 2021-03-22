package com.petar.service;

import java.util.List;

import javax.jws.WebService;

import com.petar.model.Order;

@WebService(endpointInterface="com.petar.service.OrderService", portName="OrderPort", serviceName="OrderService")
public class OrderServiceImpl implements OrderService {

	@Override
	public boolean addOrder(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteOrder(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Order getOrder(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

}
