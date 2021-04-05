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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity (name="customers")
@Access(AccessType.PROPERTY)
public class Customer {
	
	public Customer() {}

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerNumber;
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
	private double creditLimit;	
	
	private Employee employee;
	
	private List<Order> orders = new ArrayList<Order>();
	
	private Payment payment;
	
	/////////////////////////////REALTION TO EMPLOYEES START////////////////////////////////////
	
	@ManyToOne(optional = true, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "salesRepEmployeeNumber", referencedColumnName = "employeeNumber")
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		if (sameAsFormerEmployee(employee)) {
			return;
		}
		Employee oldEmployee = this.employee;
		this.employee = employee;
		if (oldEmployee != null) {
			oldEmployee.removeCustomer(this);
		}
		if (employee != null) {
			employee.addCustomer(this);
		}
	}
	
	private boolean sameAsFormerEmployee(Employee newEmployee) {
		return employee==null ? newEmployee == null : employee.equals(newEmployee);
	}
	
	/////////////////////////////REALTION TO EMPLOYEES END////////////////////////////////////
	
	/////////////////////////////REALTION TO ORDERS START////////////////////////////////////
	
	@OneToMany(mappedBy = "customer", cascade=CascadeType.REMOVE)
	public List<Order> getOrders() {
		return new ArrayList<Order>(orders);
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public void addOrder(Order order) {
		if (orders.contains(order)) {
			System.out.println("Customer already contains order " + order.getCustomer() + "\nreturning...");
			return;  
		}
		System.out.println("Adding employee " + order.getCustomer());
		orders.add(order);
		order.setCustomer(this);
	}
	public void removeOrder(Order order) {
		  if (!orders.contains(order))
		    return ;
		  orders.remove(order);
		  order.setCustomer(null);
	}	
	
	/////////////////////////////REALTION TO ORDERS END////////////////////////////////////
	
	/////////////////////////////REALTION TO PAYMENT START////////////////////////////////////
	
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	public Payment getPayment() {
		return payment;
	}
	
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
		
	/////////////////////////////REALTION TO PAYMENT END////////////////////////////////////
	
	public Integer getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Integer customerNumber) {
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

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public static class CustomerBuilder {
		private Integer customerNumber;
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
		private double creditLimit;
		//private Integer salesRepEmployeeNumber;
		private Employee employee;
		private Order order;
		
		public CustomerBuilder() {
		}
		
		public CustomerBuilder setCustomerNumber(Integer customerNumber) {
			this.customerNumber = customerNumber;
			return this;
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
		
		public CustomerBuilder setCreditLimit(double creditLimit) {
			this.creditLimit = creditLimit;
			return this;
		}
		
//		public CustomerBuilder setSalesRepEmployeeNumber(Integer salesRepEmployeeNumber) {
//			this.salesRepEmployeeNumber = salesRepEmployeeNumber;
//			return this;
//		}
		
		public CustomerBuilder setEmployee(Employee employee) {
			this.employee = employee;
			return this;
		}
		
		public CustomerBuilder setPayment(Order order) {
			this.order = order;
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
			customer.creditLimit = this.creditLimit;
//			customer.salesRepEmployeeNumber = this.salesRepEmployeeNumber;
			customer.employee = this.employee;
//			customer.order = this.order;
			
			return customer;
		}
	}
	
}
