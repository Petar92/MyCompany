package com.petar;

import com.petar.model.Customer;
import com.petar.service.CustomerService;
import com.petar.service.CustomerServiceImpl;

public class TestClass {

	public static void main(String[] args) {
		CustomerService service = new CustomerServiceImpl();
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
		service.addCustomer(customer);

	}

}
