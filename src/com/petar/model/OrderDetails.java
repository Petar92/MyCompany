package com.petar.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity (name="orderdetails")
public class OrderDetails implements Serializable{
	
	@Id //@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderNumber;
	
	@Id //@GeneratedValue(strategy = GenerationType.AUTO)
	private String productCode;
	
	private Integer quantityOrdered;
	private double priceEach;
	private Integer orderLineNumber;
	
	@OneToOne
	@JoinColumn(name = "orderNumber")
	@MapsId
	private Order order;
	
	@OneToOne
	@JoinColumn(name = "productCode")
	@MapsId
	private Product product;
	
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public static class OrderDetailBuilder {
		
		private Integer orderNumber;
		private String productCode;
		private Integer quantityOrdered;
		private double priceEach;
		private Integer orderLineNumber;
		private Order order;
		private Product product;
		
		public OrderDetailBuilder(Integer orderNumber) {
			this.orderNumber = orderNumber;
		}

		public OrderDetailBuilder setOrderNumber(Integer orderNumber) {
			System.out.println("SETTING ORDER NUMBER TO " + orderNumber);
			this.orderNumber = orderNumber;
			return this;
		}

		public OrderDetailBuilder setProductCode(String productCode) {
			System.out.println("SETTING PRODUCT CODE TO " + productCode);
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
		
		public OrderDetailBuilder setOrder(Order order) {
			this.order = order;
			return this;
		}
		
		public OrderDetailBuilder setProduct(Product product) {
			this.product = product;
			return this;
		}
		
		public OrderDetails build() {
			OrderDetails orderDetails = new OrderDetails();
			orderDetails.orderNumber = this.orderNumber;
			orderDetails.productCode = this.productCode;
			orderDetails.quantityOrdered = this.quantityOrdered;
			orderDetails.priceEach = this.priceEach;
			orderDetails.orderLineNumber = this.orderLineNumber;
			orderDetails.order = this.order;
			orderDetails.product = this.product;
			
			return orderDetails;
		}
		
	}

}
