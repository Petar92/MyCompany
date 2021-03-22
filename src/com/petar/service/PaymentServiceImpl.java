package com.petar.service;

import java.util.List;

import javax.jws.WebService;

import com.petar.model.Payment;

@WebService(endpointInterface="com.petar.service.PaymentService", portName="PaymentPort", serviceName="PaymentService")
public class PaymentServiceImpl implements PaymentService {

	@Override
	public boolean addPayment(Payment payment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePayment(Payment payment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Payment getPayment(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payment> getAllPayments() {
		// TODO Auto-generated method stub
		return null;
	}

}
