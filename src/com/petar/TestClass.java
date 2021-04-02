package com.petar;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.petar.model.Customer;
import com.petar.model.Employee;
import com.petar.model.Office;
import com.petar.service.CustomerService;
import com.petar.service.CustomerServiceImpl;
import com.petar.service.EmployeeService;
import com.petar.service.EmployeeServiceImpl;

public class TestClass {

	public static void main(String[] args) {
		//SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyCompany");;
		List<Customer> customers = new ArrayList<Customer>();
		List<Employee> employees = new ArrayList<Employee>();
		CustomerService service = new CustomerServiceImpl(entityManagerFactory);
		EmployeeService empService = new EmployeeServiceImpl(entityManagerFactory);
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
		Office office = new Office.OfficeBuilder("555").setCity("Beograd")
													   .setPhone("12343")
													   .setAddressLine1("add line 1")
													   .setCountry("Srbija")
													   .setPostalCode("11000")
													   .setTerritory("teritorija")
													   .build();
		
		Employee addedEmployee = new Employee.EmployeeBuilder().setLastName("Last")
				  .setFirstName("First")
				  .setEmail("first@last.com")
				  .setExtension("x5866")
				  .setOffice(office)
				  .setJobTitle("Capo")
				  .build();
		
		
		office.addEmployee(addedEmployee);
		addedEmployee.setOffice(office);
		
		empService.addEmployee(addedEmployee);
		
//		service.addCustomer(customer);
//		service.deleteCustomer(customer);
//		service.getCustomer(489);
//		customers = service.getAllCustomers();
//		int count = 0;
//		for (Customer customer2 : customers) {
//			System.out.println("Contact First Name is " + customer2.getContactFirstName());
//			count++;
//		}
//		System.out.println("Total number of customers is " + count);
//		
//		
//		//empService.getEmployee(1002);
//		//empService.addEmployee(employee);
//		
	}

}
