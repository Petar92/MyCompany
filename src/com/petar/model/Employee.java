package com.petar.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="employees")
public class Employee {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer employeeNumber;
	private String lastName;
	private String firstName;
	private String extension;
	private String email;
	private Integer reportsTo;
	private String jobTitle;
	//private String officeCode;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "officeCode", referencedColumnName = "officeCode")
	private Office office;
	
	private Employee() {
		//private constructor so that the object cannot be instantiated
	}
	
	public Integer getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(Integer employeeNumber) {
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

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Integer getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(Integer reportsTo) {
		this.reportsTo = reportsTo;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}


	public static class EmployeeBuilder {
		
		private Integer employeeNumber;
		private String lastName;
		private String firstName;
		private String extension;
		private String email;		
		private Office office;
		private Integer reportsTo;
		private String jobTitle;
		
		public EmployeeBuilder(Integer employeeNumber) {
			this.employeeNumber = employeeNumber;
		}
		
		public EmployeeBuilder setEmployeeNumber(Integer employeeNumber) {
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
		public EmployeeBuilder setReportsTo(Integer reportsTo) {
			this.reportsTo = reportsTo;
			return this;
		}
		public EmployeeBuilder setJobTitle(String jobTitle) {
			this.jobTitle = jobTitle;
			return this;
		}
		public EmployeeBuilder setOffice(Office office) {
			this.office = office;
			return this;
		}
		
		public Employee build() {
			Employee employee = new Employee();
			employee.employeeNumber = this.employeeNumber;
			employee.lastName = this.lastName;
			employee.firstName = this.firstName;
			employee.extension = this.extension;
			employee.email = this.email;
			employee.office = this.office;
			employee.reportsTo = this.reportsTo;
			return employee;
		}
		
	}
}
