package com.petar.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.petar.model.Order;

@WebService(name="EmployeeServiceInterface", targetNamespace="http://petar.com")
public interface OrderService {
	
	@WebMethod
	public boolean addOrder(Order order);
	
	@WebMethod
	public boolean deleteOrder(Order order);
	
	@WebMethod
	public Order getOrder(int id);
	
	@WebMethod
	public List<Order> getAllOrders();

}
