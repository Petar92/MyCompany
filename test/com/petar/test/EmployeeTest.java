package com.petar.test;

import static org.junit.Assert.assertEquals;

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
import com.petar.model.Employee;
import com.petar.model.Office;
import com.petar.service.EmployeeServiceImpl;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeTest {
	
	EntityManagerFactory entityManagerFactory;
	EmployeeServiceImpl service;
	static Office office;
	static Employee employee;
	static Employee addedEmployee;
	static Integer employeeId;
	
    @BeforeClass
    public static void initializeEmployee() {
    	
    	
    	office = Mockito.mock(Office.class);
    	office.setOfficeCode("1");
    	
    	employee = Mockito.mock(Employee.class);
    	
    	employee.setOffice(office);
    	
    	Mockito.when(employee.getEmployeeNumber()).thenReturn(1002);	
    	Mockito.when(employee.getFirstName()).thenReturn("Diane");
    	Mockito.when(employee.getLastName()).thenReturn("Murphy");
    	Mockito.when(employee.getExtension()).thenReturn("x5800");
    	Mockito.when(employee.getEmail()).thenReturn("dmurphy@classicmodelcars.com");
//    	Mockito.when(employee.getOffice().getOfficeCode()).thenReturn("1");
//    	Mockito.when(employee.getEmployee().getEmployeeNumber()).thenReturn(null);
    	Mockito.when(employee.getJobTitle()).thenReturn("President");
    }
    
    @Before
    public void setUp() throws Exception {
    	entityManagerFactory = Persistence.createEntityManagerFactory("MyCompany");
    	service = new EmployeeServiceImpl(entityManagerFactory);
    }
    
    @Test
    @Order(1)
    public void testGetCustomer() throws Exception {
        assertEquals(employee.getEmployeeNumber(), service.getEmployee(1002).getEmployeeNumber());
        assertEquals(employee.getFirstName(), service.getEmployee(1002).getFirstName());
        assertEquals(employee.getLastName(), service.getEmployee(1002).getLastName());
        assertEquals(employee.getExtension(), service.getEmployee(1002).getExtension());
        assertEquals(employee.getEmail(), service.getEmployee(1002).getEmail());
//        assertEquals(employee.getOffice(), service.getEmployee(1002).getOffice());
//        assertEquals(employee.getEmployee().getEmployeeNumber(), service.getEmployee(1002).getEmployee().getEmployeeNumber());
        assertEquals(employee.getJobTitle(), service.getEmployee(1002).getJobTitle());
    }
    
    @Test
    @Order(2)
    public void testAddCustomer() throws Exception {
    	addedEmployee = new Employee.EmployeeBuilder().setLastName("Last")
			    									  .setFirstName("First")
			    									  .setEmail("first@last.com")
			    									  .setExtension("x5866")
			    									  .setOffice(office)
			    									  .setJobTitle("Capo")
			    									  .build();
    	employeeId = addedEmployee.getEmployeeNumber();
    	System.out.println("CUSTOMER ID " + employeeId);
    	assertEquals(true, service.addEmployee(addedEmployee));
    }

}
