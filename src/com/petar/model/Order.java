package com.petar.model;

import java.sql.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity (name="orders")
@Access(AccessType.PROPERTY)
public class Order {
	
	public Order() {}
	
	
	private Integer orderNumber;
	private Date orderDate;
	private Date requiredDate;
	private Date shippedDate;
	private String status;
	private String comments;
	private Customer customer;
	private OrderDetails orderDetails;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	//////////////////////RELATION TO CUSTOMERS START///////////////////
	
	@ManyToOne(optional = false, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "customerNumber", referencedColumnName = "customerNumber")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		if (sameAsFormerCustomer(customer)) {
			return;
		}
		Customer oldCustomer = this.customer;
		this.customer = customer;
		if (oldCustomer != null) {
			oldCustomer.removeOrder(this);
		}
		if (customer != null) {
			customer.addOrder(this);
		}
	}
	
	private boolean sameAsFormerCustomer(Customer newCustomer) {
		return customer==null ? newCustomer == null : customer.equals(newCustomer);
	}
	
	//////////////////////RELATION TO CUSTOMERS END///////////////////
	
	//////////////////////RELATION TO ORDERDETAILS START///////////////////
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	public OrderDetails getOrderDetails() {
		return orderDetails;
	}
	
	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	//////////////////////RELATION TO ORDERDETAILS END///////////////////

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
	
	public static class OrderBuilder {
		
		private Integer orderNumber;
		private Date orderDate;
		private Date requiredDate;
		private Date shippedDate;
		private String status;
		private String comments;
		private Customer customer;
		public OrderDetails orderDetails;
		
		public OrderBuilder(Integer orderNumber) {
			this.orderNumber = orderNumber;
		}

		public OrderBuilder setOrderNumber(Integer orderNumber) {
			System.out.println("SETTING ORDER NUMBER TO " + orderNumber);
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
		
		public OrderBuilder setCustomer(Customer customer) {
			this.customer = customer;
			return this;
		}
		
		public OrderBuilder setOrderDetails(OrderDetails orderDetails) {
			this.orderDetails = orderDetails;
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
			order.customer = this.customer;
			order.orderDetails = this.orderDetails;
			
			return order;
		}
		
		
	}
}
