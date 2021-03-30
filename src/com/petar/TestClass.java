package com.petar;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.petar.model.Customer;
import com.petar.model.Employee;
import com.petar.service.CustomerService;
import com.petar.service.CustomerServiceImpl;
import com.petar.service.EmployeeService;
import com.petar.service.EmployeeServiceImpl;

public class TestClass {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		List<Customer> customers = new ArrayList<Customer>();
		List<Employee> employees = new ArrayList<Employee>();
		CustomerService service = new CustomerServiceImpl(sessionFactory);
		EmployeeService empService = new EmployeeServiceImpl(sessionFactory);
		Customer customer = new Customer.CustomerBuilder()
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
										.setState("Srbija")
										.build();
		Employee employee = new Employee.EmployeeBuilder(123456)
										.setEmail("petar@repic.com")
										.setExtension("594")
										.setFirstName("Petar")
										.setJobTitle("master of disaster")
										.setLastName("Repic")
										.build();
		//service.addCustomer(customer);
		//service.deleteCustomer(5);
		//service.getCustomer(489);
//		customers = service.getAllCustomers();
//		int count = 0;
//		for (Customer customer2 : customers) {
//			System.out.println("Contact First Name is " + customer2.getContactFirstName());
//			count++;
//		}
//		System.out.println("Total number of customers is " + count);
		
		
		//empService.getEmployee(1002);
		//empService.addEmployee(employee);
		
	}

}
