package com.petar.model;

public class OrderDetails {
	
	private int orderNumber;
	private String productCode;
	private int quantityOrdered;
	private double priceEach;
	private int orderLineNumber;
	
	private OrderDetails() {
		//private constructor so that the object cannot be instantiated
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public double getPriceEach() {
		return priceEach;
	}

	public void setPriceEach(double priceEach) {
		this.priceEach = priceEach;
	}

	public int getOrderLineNumber() {
		return orderLineNumber;
	}

	public void setOrderLineNumber(int orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}
	
	public static class OrderDetailBuilder {
		
		private int orderNumber;
		private String productCode;
		private int quantityOrdered;
		private double priceEach;
		private int orderLineNumber;
		
		public OrderDetailBuilder(int orderNumber) {
			this.orderNumber = orderNumber;
		}

		public OrderDetailBuilder setOrderNumber(int orderNumber) {
			this.orderNumber = orderNumber;
			return this;
		}

		public OrderDetailBuilder setProductCode(String productCode) {
			this.productCode = productCode;
			return this;
		}

		public OrderDetailBuilder setQuantityOrdered(int quantityOrdered) {
			this.quantityOrdered = quantityOrdered;
			return this;
		}

		public OrderDetailBuilder setPriceEach(double priceEach) {
			this.priceEach = priceEach;
			return this;
		}

		public OrderDetailBuilder setOrderLineNumber(int orderLineNumber) {
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
