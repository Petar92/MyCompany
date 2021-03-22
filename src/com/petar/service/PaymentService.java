package com.petar.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.petar.model.Payment;

@WebService(name="PaymentServiceInterface", targetNamespace="http://petar.com")
public interface PaymentService {

	@WebMethod
	public boolean addPayment(Payment payment);
	
	@WebMethod
	public boolean deletePayment(Payment payment);
	
	@WebMethod
	public Payment getPayment(int id);
	
	@WebMethod
	public List<Payment> getAllPayments();
	
}
