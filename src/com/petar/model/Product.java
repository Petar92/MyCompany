package com.petar.model;

public class Product {
	
	private Product() {
		//private constructor so that the object cannot be instantiated
	}
	
	private String productCode; 
	private String productName;
	private String productLine;
	private String productScale;
	private String productVendor;
	private String productDescription;
	private int quantityInStock;
	private double buyPrice;
	private double msrp;
	
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
	public String getProductLine() {
		return productLine;
	}
	public void setProductLine(String productLine) {
		this.productLine = productLine;
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
	public int getQuantityInStock() {
		return quantityInStock;
	}
	public void setQuantityInStock(int quantityInStock) {
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
	
	public static class ProductBuilder {
		
		private String productCode; 
		private String productName;
		private String productLine;
		private String productScale;
		private String productVendor;
		private String productDescription;
		private int quantityInStock;
		private double buyPrice;
		private double msrp;
		
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

		public ProductBuilder setProductLine(String productLine) {
			this.productLine = productLine;
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

		public ProductBuilder setQuantityInStock(int quantityInStock) {
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
		
		public Product build() {
			Product product = new Product();
			product.productCode = this.productCode;
			product.productName = this.productName;
			product.productLine = this.productLine;
			product.productScale = this.productScale;
			product.productVendor = this.productVendor;
			product.productDescription = this.productDescription;
			product.quantityInStock = this.quantityInStock;
			product.buyPrice = this.buyPrice;
			product.msrp = this.msrp;
			
			return product;
		}
		
		
	}

}
