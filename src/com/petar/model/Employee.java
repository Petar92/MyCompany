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
	
	private Employee() {
		//private constructor so that the object cannot be instantiated
	}
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer employeeNumber;
	private String lastName;
	private String firstName;
	private String extension;
	private String email;
	//private Integer reportsTo;
	private String jobTitle;
	
	@OneToMany(mappedBy="employee", cascade = CascadeType.ALL)
	List<Employee> employees = new ArrayList<Employee>();
	
	@ManyToOne
	@JoinColumn(name="reportsTo")
	private Employee employee;
	
	@OneToMany(mappedBy="employee", cascade = CascadeType.ALL)
	List<Customer> customers = new ArrayList<Customer>();
	
	@ManyToOne
	@JoinColumn(name="officeCode")
	private Office office;
	
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

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
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
		private Employee employee;
		private List<Employee> employees;
		private Office office;
		//private Integer reportsTo;
		private String jobTitle;
		private List<Customer> customers;
		
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
		public EmployeeBuilder setOffice(Office office) {
			this.office = office;
			return this;
		}
//		public EmployeeBuilder setReportsTo(Integer reportsTo) {
//			this.reportsTo = reportsTo;
//			return this;
//		}
		public EmployeeBuilder setJobTitle(String jobTitle) {
			this.jobTitle = jobTitle;
			return this;
		}
		
		public EmployeeBuilder setEmployee(Employee employee) {
			this.employee = employee;
			return this;
		}
		
		public EmployeeBuilder setEmployees(List<Employee> employees) {
			this.employees = employees;
			return this;
		}
		
		public EmployeeBuilder setCustomers(List<Customer> customers) {
			this.customers = customers;
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
			//employee.reportsTo = this.reportsTo;
			employee.jobTitle = this.jobTitle;
			employee.employee = this.employee;
			employee.employees = this.employees;
			employee.customers = this.customers;
			return employee;
		}
		
	}
}
