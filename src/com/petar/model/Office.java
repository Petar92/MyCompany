package com.petar.model;

public class Office {
	
	private String officeCode;
	private String city;
	private String phone;
	private String addressLine1;
	private String addressLine2;
	private String state;
	private String country;
	private String postalCode;
	private String territory;
	
	private Office() {
		//private constructor so that the object cannot be instantiated
	}
	
	public String getOfficeCode() {
		return officeCode;
	}
	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getTerritory() {
		return territory;
	}
	public void setTerritory(String territory) {
		this.territory = territory;
	}
	
	public static class OfficeBuilder {
		
		private String officeCode;
		private String city;
		private String phone;
		private String addressLine1;
		private String addressLine2;
		private String state;
		private String country;
		private String postalCode;
		private String territory;
		
		public OfficeBuilder(String officeCode) {
			this.officeCode = officeCode;
		}

		public OfficeBuilder setOfficeCode(String officeCode) {
			this.officeCode = officeCode;
			return this;
		}

		public OfficeBuilder setCity(String city) {
			this.city = city;
			return this;
		}

		public OfficeBuilder setPhone(String phone) {
			this.phone = phone;
			return this;
		}

		public OfficeBuilder setAddressLine1(String addressLine1) {
			this.addressLine1 = addressLine1;
			return this;
		}

		public OfficeBuilder setAddressLine2(String addressLine2) {
			this.addressLine2 = addressLine2;
			return this;
		}

		public OfficeBuilder setState(String state) {
			this.state = state;
			return this;
		}

		public OfficeBuilder setCountry(String country) {
			this.country = country;
			return this;
		}

		public OfficeBuilder setPostalCode(String postalCode) {
			this.postalCode = postalCode;
			return this;
		}

		public OfficeBuilder setTerritory(String territory) {
			this.territory = territory;
			return this;
		}
		
		public Office build() {
			Office office = new Office();
			office.officeCode = this.officeCode;
			office.city = this.city;
			office.phone = this.phone;
			office.addressLine1 = this.addressLine1;
			office.addressLine2 = this.addressLine2;
			office.state = this.state;
			office.country = this.country;
			office.postalCode = this.postalCode;
			office.territory = this.territory;
			
			return office;
		}
		
	}

}
