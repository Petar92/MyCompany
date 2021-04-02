package com.petar.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity (name="payments")
@IdClass(PaymentId.class)
public class Payment implements Serializable{
	
	public Payment() {}
	
	@Id
	@OneToOne(optional = false)
	//@PrimaryKeyJoinColumn(name = "customerNumber", referencedColumnName="customerNumber")
	private Customer customer;
	
	@Id
	private String checkNumber;
	
	private Date paymentDate;
	private double amount;
	
//	public Integer getCustomerNumber() {
//		return customerNumber;
//	}
//	public void setCustomerNumber(Integer customerNumber) {
//		this.customerNumber = customerNumber;
//	}
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
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public static class PaymentBuilder {
		
		//private Integer customerNumber;
		private String checkNumber;
		private Date paymentDate;
		private double amount;
		private Customer customer;
		
//		public PaymentBuilder(Integer customerNumber) {
//			this.customerNumber = customerNumber;
//		}
//
//		public PaymentBuilder setCustomerNumber(Integer customerNumber) {
//			this.customerNumber = customerNumber;
//			return this;
//		}

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
		
		public PaymentBuilder setCustomer(Customer customer) {
			this.customer = customer;
			return this;
		}
		
		public Payment builder() {
			Payment payment = new Payment();
			//payment.customerNumber = this.customerNumber;
			payment.checkNumber = this.checkNumber;
			payment.paymentDate = this.paymentDate;
			payment.amount = this.amount;
			payment.customer = this.customer;
			
			return payment;
		}
		
	}
	

}
