package com.petar.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.petar.model.OrderDetails;

@WebService(name="OrderDetailsServiceInterface", targetNamespace="http://petar.com")
public interface OrderDetailsService {
	
	@WebMethod
	public boolean addOrderDetails(OrderDetails orderDetails);
	
	@WebMethod
	public boolean deleteOrderDetails(OrderDetails orderDetails);
	
	@WebMethod
	public OrderDetails getOrderDetails(int id);
	
	@WebMethod
	public List<OrderDetails> getAllOrderDetails();

}
