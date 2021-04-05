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

@Entity(name="employees")
@Access(AccessType.PROPERTY)
public class Employee {
	
	public Employee() {}
	
	private Integer employeeNumber;
	private String lastName;
	private String firstName;
	private String extension;
	private String email;
	private String jobTitle;
	
	private Office office;
	
	private Employee employee;
	
	private List<Employee> employees = new ArrayList<Employee>();
	
	private List<Customer> customers = new ArrayList<Customer>();
		
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getEmployeeNumber() {
		return employeeNumber;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "officeCode", referencedColumnName = "officeCode")
	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		if (sameAsFormerOffice(office)) {
			return;
		}
		Office oldOffice = this.office;
		this.office = office;
		if (oldOffice != null) {
			oldOffice.removeEmployee(this);
		}
		if (office != null) {
			office.addEmployee(this);
		}
	}
	
	@OneToMany(mappedBy = "employee", cascade= CascadeType.REMOVE)
	public List<Employee> getEmployees() {
		return new ArrayList<Employee>(employees);
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public void addEmployee(Employee employee) {
		if (employees.contains(employee)) {
			System.out.println("Office already contains employee " + employee.getFirstName() + "\nreturning...");
			return;  
		}
		System.out.println("Adding employee " + employee.getFirstName());
		employees.add(employee);
		employee.setEmployee(this);
	}
	public void removeEmployee(Employee employee) {
		  if (!employees.contains(employee))
		    return ;
		  employees.remove(employee);
		  employee.setEmployee(null);
	}

	@ManyToOne(optional = true, cascade= CascadeType.PERSIST)
	@JoinColumn(name = "reportsTo", referencedColumnName = "employeeNumber")
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
			oldEmployee.removeEmployee(this);
		}
		if (employee != null) {
			employee.addEmployee(this);
		}
	}
	
	@OneToMany(mappedBy = "employee", cascade= CascadeType.REMOVE)
	public List<Customer> getCustomer() {
		return new ArrayList<Customer>(customers);
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	public void addCustomer(Customer customer) {
		if (customers.contains(customer)) {
			System.out.println("Employee already has customer " + customer.getCustomerName() + "\nreturning...");
			return;  
		}
		System.out.println("Adding customer " + customer.getCustomerName());
		customers.add(customer);
		customer.setEmployee(this);
	}
	public void removeCustomer(Customer customer) {
		  if (!customers.contains(customer))
		    return ;
		  customers.remove(customer);
		  customer.setEmployee(null);
	}
	
	private boolean sameAsFormerOffice(Office newOffice) {
		return office==null? newOffice == null : office.equals(newOffice);
	}
	
	private boolean sameAsFormerEmployee(Employee newEmployee) {
		return employee==null ? newEmployee == null : employee.equals(newEmployee);
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

	public static class EmployeeBuilder {
		
		private Integer employeeNumber;
		private String lastName;
		private String firstName;
		private String extension;
		private String email;		
		private Office office;
		private Employee reportsTo;
		private String jobTitle;
		
		public EmployeeBuilder() {}
		
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
		public EmployeeBuilder setReportsTo(Employee reportsTo) {
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
			employee.jobTitle = this.jobTitle;
			employee.employee = this.reportsTo;
			return employee;
		}
		
	}
}
