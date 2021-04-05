package com.petar.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity (name="productlines")
@Access(AccessType.PROPERTY)
public class ProductLine {
	
	public ProductLine() {}
	
	private String productLine;
	private String textDescription;
	private String htmlDescription;
	private byte[] image;
	List<Product> products = new ArrayList<Product>();
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	public String getProductLine() {
		return productLine;
	}
	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}
	
	@OneToMany(mappedBy = "productLine", cascade=CascadeType.ALL)
	public List<Product> getProducts() {
		return new ArrayList<Product>(products);
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public void addProduct(Product product) {
		if (products.contains(product)) {
			System.out.println("Product line already contains product " + product.getProductName() + "\nreturning...");
			return;  
		}
		System.out.println("Adding product " + product.getProductName());
		products.add(product);
		product.setProductLine(this);
	}
	public void removeProduct(Product product) {
		  if (!products.contains(product))
		    return ;
		  products.remove(product);
		  product.setProductLine(null);
	}
	
	public String getTextDescription() {
		return textDescription;
	}
	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}
	public String getHtmlDescription() {
		return htmlDescription;
	}
	public void setHtmlDescription(String htmlDescription) {
		this.htmlDescription = htmlDescription;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}

	public static class ProductLineBuilder {
		
		private String textDescription;
		private String htmlDescription;
		private byte[] image;
		private List<Product> products;
		
		public ProductLineBuilder() {}

		public ProductLineBuilder setTextDescription(String textDescription) {
			this.textDescription = textDescription;
			return this;
		}

		public ProductLineBuilder setHtmlDescription(String htmlDescription) {
			this.htmlDescription = htmlDescription;
			return this;
		}

		public ProductLineBuilder setImage(byte[] image) {
			this.image = image;
			return this;
		}
		
		public ProductLineBuilder setProducts(List<Product> products) {
			this.products = products;
			return this;
		}
		
		public ProductLine build() {
			ProductLine productLine = new ProductLine();
			productLine.textDescription = this.textDescription;
			productLine.htmlDescription = this.htmlDescription;
			productLine.image = this.image;
			productLine.products = this.products;
			
			return productLine;
		}
	}
	

}
