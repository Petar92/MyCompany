package com.petar.service;

import java.util.List;

import javax.jws.WebService;

import com.petar.model.OrderDetails;

@WebService(endpointInterface="com.petar.service.OrderDetailsService", portName="OrderDetailsPort", serviceName="OrderDetailsService")
public class OrderDetailsServiceImpl implements OrderDetailsService {

	@Override
	public boolean addOrderDetails(OrderDetails orderDetails) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteOrderDetails(OrderDetails orderDetails) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OrderDetails getOrderDetails(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDetails> getAllOrderDetails() {
		// TODO Auto-generated method stub
		return null;
	}

}
