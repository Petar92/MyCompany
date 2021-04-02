package com.petar.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;

import com.petar.model.Customer;
import com.petar.service.CustomerServiceImpl;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerTest {
	
	EntityManagerFactory entityManagerFactory;
	CustomerServiceImpl service;
	static Customer customer;
	static Customer addedCustomer;
	static Integer customerId;
	   
    @BeforeClass
    public static void initializeCustomer() {
    	
    	customer = Mockito.mock(Customer.class);
    	Mockito.when(customer.getCustomerNumber()).thenReturn(103);
    	Mockito.when(customer.getCustomerName()).thenReturn("Atelier graphique");
    	Mockito.when(customer.getContactLastName()).thenReturn("Schmitt");
    	Mockito.when(customer.getContactFirstName()).thenReturn("Carine ");
    	Mockito.when(customer.getPhone()).thenReturn("40.32.2555");
    	Mockito.when(customer.getAddressLine1()).thenReturn("54, rue Royale");
    	Mockito.when(customer.getAddressLine2()).thenReturn(null);
    	Mockito.when(customer.getCity()).thenReturn("Nantes");
    	Mockito.when(customer.getState()).thenReturn(null);
    	Mockito.when(customer.getPostalCode()).thenReturn("44000");
    	Mockito.when(customer.getCountry()).thenReturn("France");
    	Mockito.when(customer.getCreditLimit()).thenReturn(21000.00); 	

    }
    
    @Before
    public void setUp() throws Exception {
    	entityManagerFactory = Persistence.createEntityManagerFactory("MyCompany");
    	service = new CustomerServiceImpl(entityManagerFactory);
    }
    
    @Test
    @Order(1)
    public void testGetCustomer() throws Exception {
        assertEquals(customer.getCustomerNumber(), service.getCustomer(103).getCustomerNumber());
        assertEquals(customer.getCustomerName(), service.getCustomer(103).getCustomerName());
        assertEquals(customer.getContactLastName(), service.getCustomer(103).getContactLastName());
        assertEquals(customer.getContactFirstName(), service.getCustomer(103).getContactFirstName());
        assertEquals(customer.getPhone(), service.getCustomer(103).getPhone());
        assertEquals(customer.getAddressLine1(), service.getCustomer(103).getAddressLine1());
        assertEquals(customer.getAddressLine2(), service.getCustomer(103).getAddressLine2());
        assertEquals(customer.getCity(), service.getCustomer(103).getCity());
        assertEquals(customer.getState(), service.getCustomer(103).getState());
        assertEquals(customer.getPostalCode(), service.getCustomer(103).getPostalCode());
        assertEquals(customer.getCountry(), service.getCustomer(103).getCountry());
        assertEquals(customer.getCreditLimit(), service.getCustomer(103).getCreditLimit(), 0.00);
        //assertEquals(customer.getSalesRepEmployeeNumber(), service.getCustomer(103).getSalesRepEmployeeNumber());
    }
    
    @Test
    @Order(2)
    public void testAddCustomer() throws Exception {
    	addedCustomer = new Customer.CustomerBuilder().setName("Vuk")
			    										   .setContactLastName("Prezime")
			    										   .setContacFirstName("Ime")
			    										   .setPhone("555-101010")
			    										   .setAddressLine1("Zmaj od nocaja")
			    										   .setAddressLine2(null)
			    										   .setCity("Beograd")
			    										   .setState("Srbija")
			    										   .setPostalCode("11000")
			    										   .setCountry("Srbija")
			    										   .setCreditLimit(221000.00)
			    										   .build();
    	customerId = addedCustomer.getCustomerNumber();
    	System.out.println("CUSTOMER ID " + customerId);
    	assertEquals(true, service.addCustomer(addedCustomer));
    }
    
    @Test
    @Order(3)
    public void testDeleteCustomer() throws Exception {
    	System.out.println("CUSTOMER ID " + customerId);
    	Customer deletedCustomer = service.getCustomer(12);
    	assertEquals(true, service.deleteCustomer(deletedCustomer));
    }
    
    @Test
    @Order(4)
    public void testGetAllCustomers() throws Exception {
    	List<Customer> customers = new ArrayList<Customer>();
    	customers = service.getAllCustomers();
    	assertEquals(124, customers.size());
    }
    
    

}
