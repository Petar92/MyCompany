package com.petar.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity (name="payments")
public class Payment implements Serializable{
	
	public Payment() {}
		
	@EmbeddedId
	private PaymentId checkNumber;
	
	private Date paymentDate;
	private double amount;
	
	@MapsId("customerNumber")
	@JoinColumn(name = "customerNumber", referencedColumnName = "customerNumber")
	@OneToOne(optional = false)
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
//	public String getCheckNumber() {
//		return checkNumber;
//	}
//	public void setCheckNumber(String checkNumber) {
//		this.checkNumber = checkNumber;
//	}
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
		
		private Customer customer;
		private Date paymentDate;
		private double amount;

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
			payment.paymentDate = this.paymentDate;
			payment.amount = this.amount;
			payment.customer = this.customer;
			
			return payment;
		}
		
	}
	

}
