package com.petar.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="employees")
public class Employee {
	
	private Employee() {
		//private constructor so that the object cannot be instantiated
	}
	
	@Id
	private int employeeNumber;
	private String lastName;
	private String firstName;
	private String extension;
	private String email;
	private String officeCode;
	private int reportsTo;
	private String jobTitle;
	
	public int getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOfficeCode() {
		return officeCode;
	}
	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}
	public int getReportsTo() {
		return reportsTo;
	}
	public void setReportsTo(int reportsTo) {
		this.reportsTo = reportsTo;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	public static class EmployeeBuilder {
		
		private int employeeNumber;
		private String lastName;
		private String firstName;
		private String extension;
		private String email;
		private String officeCode;
		private int reportsTo;
		private String jobTitle;
		
		public EmployeeBuilder(int employeeNumber) {
			this.employeeNumber = employeeNumber;
		}
		
		public EmployeeBuilder setEmployeeNumber(int employeeNumber) {
			this.employeeNumber = employeeNumber;
			return this;
		}
		public EmployeeBuilder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		public EmployeeBuilder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		public EmployeeBuilder setExtension(String extension) {
			this.extension = extension;
			return this;
		}
		public EmployeeBuilder setEmail(String email) {
			this.email = email;
			return this;
		}
		public EmployeeBuilder setOfficeCode(String officeCode) {
			this.officeCode = officeCode;
			return this;
		}
		public EmployeeBuilder setReportsTo(int reportsTo) {
			this.reportsTo = reportsTo;
			return this;
		}
		public EmployeeBuilder setJobTitle(String jobTitle) {
			this.jobTitle = jobTitle;
			return this;
		}
		
		public Employee build() {
			Employee employee = new Employee();
			employee.employeeNumber = this.employeeNumber;
			employee.lastName = this.lastName;
			employee.firstName = this.firstName;
			employee.extension = this.extension;
			employee.email = this.email;
			employee.officeCode = this.officeCode;
			employee.reportsTo = this.reportsTo;
			employee.jobTitle = this.jobTitle;
			
			return employee;
		}
		
	}
}
