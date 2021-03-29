package com.petar;

import java.util.ArrayList;
import java.util.List;

import com.petar.model.Customer;
import com.petar.model.Employee;
import com.petar.service.CustomerService;
import com.petar.service.CustomerServiceImpl;
import com.petar.service.EmployeeService;
import com.petar.service.EmployeeServiceImpl;

public class TestClass {

	public static void main(String[] args) {
		List<Customer> customers = new ArrayList<Customer>();
		List<Employee> employees = new ArrayList<Employee>();
		CustomerService service = new CustomerServiceImpl();
		EmployeeService empService = new EmployeeServiceImpl();
		Customer customer = new Customer.CustomerBuilder(11111)
										.setAddressLine1("addres 1")
										.setAddressLine2("address 2")
										.setCity("Loznica")
										.setContacFirstName("Kontakt Ime")
										.setContactLastName("Kontakt prezime")
										.setCountry("Srbija")
										.setCreditLimit(123.23)
										.setName("kupac")
										.setPhone("123321")
										.setPostalCode("15300")
										.setSalesRepEmployeeNumber(1370)
										.setState("Srbija")
										.build();
		Employee employee = new Employee.EmployeeBuilder(123456)
										.setEmail("petar@repic.com")
										.setExtension("594")
										.setFirstName("Petar")
										.setJobTitle("master of disaster")
										.setLastName("Repic")
										.setOfficeCode("BGD")
										.build();
		//service.addCustomer(customer);
		//service.deleteCustomer(1);
		//service.getCustomer(103);
//		customers = service.getAllCustomers();
//		int count = 0;
//		for (Customer customer2 : customers) {
//			System.out.println("Contact First Name is " + customer2.getContactFirstName());
//			count++;
//		}
//		System.out.println("Total number of customers is " + count);
		
		
		//empService.getEmployee(1002);
		empService.addEmployee(employee);
		
	}

}
