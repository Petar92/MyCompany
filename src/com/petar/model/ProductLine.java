package com.petar.model;

public class ProductLine {
	
	private ProductLine() {
		//private constructor so that the object cannot be instantiated
	}
	
	private String productLine;
	private String textDescription;
	private String htmlDescription;
	private byte[] image;
	
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
