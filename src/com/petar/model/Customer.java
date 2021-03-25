package com.petar.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="customers")
public class Customer {
	
	public Customer() {}

	@Id
	private int customerNumber;
	private String customerName;
	private String contactLastName;
	private String contactFirstName;
	private String phone;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String postalCode;
	private String country;
	private int salesRepEmployeeNumber;
	private double creditLimit;
	
	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getContactLastName() {
		return contactLastName;
	}

	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}

	public String getContactFirstName() {
		return contactFirstName;
	}

	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getSalesRepEmployeeNumber() {
		return salesRepEmployeeNumber;
	}

	public void setSalesRepEmployeeNumber(int salesRepEmployeeNumber) {
		this.salesRepEmployeeNumber = salesRepEmployeeNumber;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
	
	public static class CustomerBuilder {
		private int customerNumber;
		private String customerName;
		private String contactLastName;
		private String contactFirstName;
		private String phone;
		private String addressLine1;
		private String addressLine2;
		private String city;
		private String state;
		private String postalCode;
		private String country;
		private int salesRepEmployeeNumber;
		private double creditLimit;
		
		public CustomerBuilder(int customerNumber) {
			this.customerNumber = customerNumber;
		}
		
		public CustomerBuilder setName(String customerName) {
			this.customerName = customerName;
			return this;
		}
		
		public CustomerBuilder setContactLastName(String contactLastName) {
			this.contactLastName = contactLastName;
			return this;
		}
		
		public CustomerBuilder setContacFirstName(String contactFirstName) {
			this.contactFirstName = contactFirstName;
			return this;
		}
		
		public CustomerBuilder setPhone(String phone) {
			this.phone = phone;
			return this;
		}
		
		public CustomerBuilder setAddressLine1(String addressLine1) {
			this.addressLine1 = addressLine1;
			return this;
		}
		
		public CustomerBuilder setAddressLine2(String addressLine2) {
			this.addressLine2 = addressLine1;
			return this;
		}
		
		public CustomerBuilder setCity(String city) {
			this.city = city;
			return this;
		}
		
		public CustomerBuilder setState(String state) {
			this.state = state;
			return this;
		}
		
		public CustomerBuilder setPostalCode(String postalCode) {
			this.postalCode = postalCode;
			return this;
		}
		
		public CustomerBuilder setCountry(String country) {
			this.country = country;
			return this;
		}
		
		public CustomerBuilder setSalesRepEmployeeNumber(int salesRepEmployeeNumber) {
			this.salesRepEmployeeNumber = salesRepEmployeeNumber;
			return this;
		}
		
		public CustomerBuilder setCreditLimit(double creditLimit) {
			this.creditLimit = creditLimit;
			return this;
		}
		
		public Customer build() {
			Customer customer = new Customer();
			customer.customerNumber = this.customerNumber;
			customer.customerName = this.customerName;
			customer.contactLastName = this.contactLastName;
			customer.contactFirstName = this.contactFirstName;
			customer.phone = this.phone;
			customer.addressLine1 = this.addressLine1;
			customer.addressLine2 = this.addressLine2;
			customer.city = this.city;
			customer.state = this.state;
			customer.postalCode = this.postalCode;
			customer.country = this.country;
			customer.salesRepEmployeeNumber = this.salesRepEmployeeNumber;
			customer.creditLimit = this.creditLimit;
			
			return customer;
		}
	}
	
}
