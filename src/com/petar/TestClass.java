package com.petar;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
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
import com.petar.service.OfficeService;
import com.petar.service.OfficeServiceImpl;

public class TestClass {

	public static void main(String[] args) {
		//SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyCompany");;
		List<Customer> customers = new ArrayList<Customer>();
		List<Employee> employees = new ArrayList<Employee>();
		CustomerService customerService = new CustomerServiceImpl(entityManagerFactory);
		EmployeeService empService = new EmployeeServiceImpl(entityManagerFactory);
		OfficeService officeService = new OfficeServiceImpl(entityManagerFactory);
				
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
		
		Office office = new Office.OfficeBuilder().setCity("Beograd")
													   .setPhone("12343")
													   .setAddressLine1("add line 1")
													   .setCountry("Srbija")
													   .setPostalCode("11000")
													   .setTerritory("teritorija")
													   .build();
		
		
		Office office2 = new Office.OfficeBuilder().setCity("Loznica")
				   .setPhone("22222")
				   .setAddressLine1("add line 1")
				   .setCountry("Srbija")
				   .setPostalCode("15300")
				   .setTerritory("Podrinje")
				   .build();
		
		Employee bossEmployee = new Employee.EmployeeBuilder()
				  .setFirstName("Petar")
				  .setLastName("Petrovic")
				  .setEmail("petar@petar.com")
				  .setExtension("x55586")
				  .setOffice(office)
				  .setJobTitle("CapoDiTuttiCappi")
				  .build();
		
		
		System.out.println(bossEmployee.getFirstName() + " is the boss!");
		
		Employee subEmployee = new Employee.EmployeeBuilder()
//				  .setReportsTo(bossEmployee)
				  .setFirstName("Stefan")
				  .setLastName("Petrovic")
				  .setEmail("stefan@petrovic.com")
				  .setExtension("x55586")
				  .setOffice(office)
				  .setJobTitle("Capo")
				  .build();
		System.out.println(subEmployee.getFirstName() + " is a capo!");	
		
		bossEmployee.addEmployee(subEmployee);
		empService.addEmployee(subEmployee);
	}

}
