package com.petar.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity (name="payments")
public class Payment implements Serializable{
	
	private Payment() {
		//private constructor so that the object cannot be instantiated
	}
	
	@Id
	private int customerNumber;
	
	@Id
	private String checkNumber;
	
	@OneToOne(mappedBy = "payment")
	@PrimaryKeyJoinColumn
	@NotFound(action=NotFoundAction.IGNORE)
	private Customer customer;
	
	private Date paymentDate;
	private double amount;
	
	public int getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(int customerNumber) {
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
		
		private int customerNumber;
		private String checkNumber;
		private Date paymentDate;
		private double amount;
		
		public PaymentBuilder(int customerNumber) {
			this.customerNumber = customerNumber;
		}

		public PaymentBuilder setCustomerNumber(int customerNumber) {
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
