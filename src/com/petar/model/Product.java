package com.petar.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity (name="products")
public class Product {
	
	public Product() {}
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private String productCode; 
	
	private String productName;
	private String productScale;
	private String productVendor;
	private String productDescription;
	private Integer quantityInStock;
	private double buyPrice;
	private double msrp;
	
//	@OneToOne(mappedBy = "product")
//	private OrderDetails orderDetails;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "productLine", referencedColumnName = "productLine")
	private ProductLine productLine;
	
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductScale() {
		return productScale;
	}

	public void setProductScale(String productScale) {
		this.productScale = productScale;
	}

	public String getProductVendor() {
		return productVendor;
	}

	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Integer getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(Integer quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public double getMsrp() {
		return msrp;
	}

	public void setMsrp(double msrp) {
		this.msrp = msrp;
	}

//	public OrderDetails getOrderDetails() {
//		return orderDetails;
//	}
//
//	public void setOrderDetails(OrderDetails orderDetails) {
//		this.orderDetails = orderDetails;
//	}

	public ProductLine getProductLine() {
		return productLine;
	}

	public void setProductLine(ProductLine productLine) {
		this.productLine = productLine;
	}

	public static class ProductBuilder {
		
		private String productCode; 
		private String productName;
		private String productScale;
		private String productVendor;
		private String productDescription;
		private Integer quantityInStock;
		private double buyPrice;
		private double msrp;
		private OrderDetails orderDetails;
		private ProductLine productLine;
		
		public ProductBuilder(String productCode) {
			this.productCode = productCode;
		}

		public ProductBuilder setProductCode(String productCode) {
			this.productCode = productCode;
			return this;
		}

		public ProductBuilder setProductName(String productName) {
			this.productName = productName;
			return this;
		}

		public ProductBuilder setProductScale(String productScale) {
			this.productScale = productScale;
			return this;
		}

		public ProductBuilder setProductVendor(String productVendor) {
			this.productVendor = productVendor;
			return this;
		}

		public ProductBuilder setProductDescription(String productDescription) {
			this.productDescription = productDescription;
			return this;
		}

		public ProductBuilder setQuantityInStock(Integer quantityInStock) {
			this.quantityInStock = quantityInStock;
			return this;
		}

		public ProductBuilder setBuyPrice(double buyPrice) {
			this.buyPrice = buyPrice;
			return this;
		}

		public ProductBuilder setMsrp(double msrp) {
			this.msrp = msrp;
			return this;
		}
		
		public ProductBuilder setOrderDetails(OrderDetails orderDetails) {
			this.orderDetails = orderDetails;
			return this;
		}
		
		public ProductBuilder setProductLine(ProductLine productLine) {
			this.productLine = productLine;
			return this;
		}
		
		public Product build() {
			Product product = new Product();
			product.productCode = this.productCode;
			product.productName = this.productName;
			product.productScale = this.productScale;
			product.productVendor = this.productVendor;
			product.productDescription = this.productDescription;
			product.quantityInStock = this.quantityInStock;
			product.buyPrice = this.buyPrice;
			product.msrp = this.msrp;
			product.productLine = this.productLine;
//			product.orderDetails = this.orderDetails;
			
			return product;
		}
		
		
	}

}
