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
	
	public ProductLine() {}
	
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
		private List<Product> products;
		
		public ProductLineBuilder(String productLine) {
			this.productLine = productLine;
		}

		public ProductLineBuilder setProductLine(String productLine) {
			this.productLine = productLine;
			return this;
		}

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
			productLine.productLine = this.productLine;
			productLine.textDescription = this.textDescription;
			productLine.htmlDescription = this.htmlDescription;
			productLine.image = this.image;
			productLine.products = this.products;
			
			return productLine;
		}
	}
	

}
