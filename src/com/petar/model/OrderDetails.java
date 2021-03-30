package com.petar.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity (name = "orderdetails")
public class OrderDetails implements Serializable{
	
	@Id @GeneratedValue
	private Integer orderNumber;
	@Id @GeneratedValue
	private String productCode;
	private Integer quantityOrdered;
	private double priceEach;
	private Integer orderLineNumber;
	
	@OneToOne(mappedBy = "orderDetails")
	@Cascade(value = { CascadeType.ALL })
	@PrimaryKeyJoinColumn
	@NotFound(action=NotFoundAction.IGNORE)
	private Order order;
	
	private OrderDetails() {
		//private constructor so that the object cannot be instantiated
	}

	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Integer getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(Integer quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public double getPriceEach() {
		return priceEach;
	}

	public void setPriceEach(double priceEach) {
		this.priceEach = priceEach;
	}

	public Integer getOrderLineNumber() {
		return orderLineNumber;
	}

	public void setOrderLineNumber(Integer orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}
	
	public static class OrderDetailBuilder {
		
		private Integer orderNumber;
		private String productCode;
		private Integer quantityOrdered;
		private double priceEach;
		private Integer orderLineNumber;
		
		public OrderDetailBuilder(Integer orderNumber) {
			this.orderNumber = orderNumber;
		}

		public OrderDetailBuilder setOrderNumber(Integer orderNumber) {
			this.orderNumber = orderNumber;
			return this;
		}

		public OrderDetailBuilder setProductCode(String productCode) {
			this.productCode = productCode;
			return this;
		}

		public OrderDetailBuilder setQuantityOrdered(Integer quantityOrdered) {
			this.quantityOrdered = quantityOrdered;
			return this;
		}

		public OrderDetailBuilder setPriceEach(double priceEach) {
			this.priceEach = priceEach;
			return this;
		}

		public OrderDetailBuilder setOrderLineNumber(Integer orderLineNumber) {
			this.orderLineNumber = orderLineNumber;
			return this;
		}
		
		public OrderDetails build() {
			OrderDetails orderDetails = new OrderDetails();
			orderDetails.orderNumber = this.orderNumber;
			orderDetails.productCode = this.productCode;
			orderDetails.quantityOrdered = this.quantityOrdered;
			orderDetails.priceEach = this.priceEach;
			orderDetails.orderLineNumber = this.orderLineNumber;
			
			return orderDetails;
		}
		
	}

}
