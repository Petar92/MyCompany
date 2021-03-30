package com.petar.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity (name="payments")
public class Payment implements Serializable{
	
	private Payment() {
		//private constructor so that the object cannot be instantiated
	}
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerNumber;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private String checkNumber;
	
	private Date paymentDate;
	private double amount;
	
	public Integer getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(Integer customerNumber) {
		this.customerNumber = customerNumber;
	}
	public String getCheckNumber() {
		return checkNumber;
	}
	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public static class PaymentBuilder {
		
		private Integer customerNumber;
		private String checkNumber;
		private Date paymentDate;
		private double amount;
		
		public PaymentBuilder(Integer customerNumber) {
			this.customerNumber = customerNumber;
		}

		public PaymentBuilder setCustomerNumber(Integer customerNumber) {
			this.customerNumber = customerNumber;
			return this;
		}

		public PaymentBuilder setCheckNumber(String checkNumber) {
			this.checkNumber = checkNumber;
			return this;
		}

		public PaymentBuilder setPaymentDate(Date paymentDate) {
			this.paymentDate = paymentDate;
			return this;
		}

		public PaymentBuilder setAmount(double amount) {
			this.amount = amount;
			return this;
		}
		
		public Payment builder() {
			Payment payment = new Payment();
			payment.customerNumber = this.customerNumber;
			payment.checkNumber = this.checkNumber;
			payment.paymentDate = this.paymentDate;
			payment.amount = this.amount;
			
			return payment;
		}
		
	}
	

}
