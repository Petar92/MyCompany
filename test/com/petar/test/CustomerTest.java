package com.petar.test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.petar.model.Customer;
import com.petar.service.CustomerServiceImpl;

public class CustomerTest {
	
	EntityManagerFactory entityManagerFactory;
	CustomerServiceImpl service;
	static Customer customer;
	   
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
    	Mockito.when(customer.getSalesRepEmployeeNumber()).thenReturn(1370); 	

    }
    
    @Before
    public void setUp() throws Exception {
    	entityManagerFactory = Persistence.createEntityManagerFactory("MyCompany");
    	service = new CustomerServiceImpl(entityManagerFactory);
    }
    
    @Test
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
        assertEquals(customer.getSalesRepEmployeeNumber(), service.getCustomer(103).getSalesRepEmployeeNumber());
    }
    
    @Test
    public void testAddCustomer() throws Exception {
    	Customer customer2 = new Customer.CustomerBuilder().setName("Vuk")
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
			    										   .setSalesRepEmployeeNumber(1370)
			    										   .build();
    	assertEquals(true, service.addCustomer(customer2));
    }
    
    

}
