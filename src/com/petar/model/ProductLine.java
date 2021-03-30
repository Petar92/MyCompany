package com.petar.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity (name="productlines")
public class ProductLine {
	
	private ProductLine() {
		//private constructor so that the object cannot be instantiated
	}
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private String productLine;
	
	private String textDescription;
	private String htmlDescription;
	private byte[] image;
	
	@OneToMany(mappedBy="productLine", cascade = CascadeType.ALL)
	List<Product> products = new ArrayList<Product>();
	
	public String getProductLine() {
		return productLine;
	}
	public void setProductLine(String productLine) {
		this.productLine = productLine;
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
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public static class ProductLineBuilder {
		
		private String productLine;
		private String textDescription;
		private String htmlDescription;
		private byte[] image;
		
		public ProductLineBuilder(String productLine) {
			this.productLine = productLine;
		}

		public void setProductLine(String productLine) {
			this.productLine = productLine;
		}

		public void setTextDescription(String textDescription) {
			this.textDescription = textDescription;
		}

		public void setHtmlDescription(String htmlDescription) {
			this.htmlDescription = htmlDescription;
		}

		public void setImage(byte[] image) {
			this.image = image;
		}
		
		public ProductLine build() {
			ProductLine productLine = new ProductLine();
			productLine.productLine = this.productLine;
			productLine.textDescription = this.textDescription;
			productLine.htmlDescription = this.htmlDescription;
			productLine.image = this.image;
			
			return productLine;
		}
	}
	

}
