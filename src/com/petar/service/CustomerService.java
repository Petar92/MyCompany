package com.petar.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.petar.model.Customer;

@WebService(name="CustomerServiceInterface", targetNamespace="http://petar.com")
public interface CustomerService {

	@WebMethod
	public boolean addCustomer(Customer customer);
	
	@WebMethod
	public boolean deleteCustomer(Integer id);
	
	@WebMethod
	public Customer getCustomer(int id);
	
	@WebMethod
	public List<Customer> getAllCustomers();
}
