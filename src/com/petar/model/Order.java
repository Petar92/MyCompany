package com.petar.model;

import java.sql.Date;

public class Order {
	
	private int orderNumber;
	private Date orderDate;
	private Date requiredDate;
	private Date shippedDate;
	private String status;
	private String comments;
	private int customerNumber;
	
	private Order() {
		//private constructor so that the object cannot be instantiated
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(Date requiredDate) {
		this.requiredDate = requiredDate;
	}

	public Date getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}
	
	public static class OrderBuilder {
		
		private int orderNumber;
		private Date orderDate;
		private Date requiredDate;
		private Date shippedDate;
		private String status;
		private String comments;
		private int customerNumber;
		
		public OrderBuilder(int orderNumber) {
			this.orderNumber = orderNumber;
		}

		public OrderBuilder setOrderNumber(int orderNumber) {
			this.orderNumber = orderNumber;
			return this;
		}

		public OrderBuilder setOrderDate(Date orderDate) {
			this.orderDate = orderDate;
			return this;
		}

		public OrderBuilder setRequiredDate(Date requiredDate) {
			this.requiredDate = requiredDate;
			return this;
		}

		public OrderBuilder setShippedDate(Date shippedDate) {
			this.shippedDate = shippedDate;
			return this;
		}

		public OrderBuilder setStatus(String status) {
			this.status = status;
			return this;
		}

		public OrderBuilder setComments(String comments) {
			this.comments = comments;
			return this;
		}

		public OrderBuilder setCustomerNumber(int customerNumber) {
			this.customerNumber = customerNumber;
			return this;
		}
		
		public Order build() {
			Order order = new Order();
			order.orderNumber = this.orderNumber;
			order.orderDate = this.orderDate;
			order.requiredDate = this.requiredDate;
			order.shippedDate = this.shippedDate;
			order.status = this.status;
			order.comments = this.comments;
			order.customerNumber = this.customerNumber;
			
			return order;
		}
		
		
	}
}
