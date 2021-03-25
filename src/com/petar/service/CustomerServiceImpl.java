package com.petar.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.petar.model.Customer;

@WebService(endpointInterface="com.petar.service.CustomerService", portName="CustomerPort", serviceName="CustomerService")
public class CustomerServiceImpl implements CustomerService {

	@Override
	public boolean addCustomer(Customer customer) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(customer);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean deleteCustomer(Integer id) {
		boolean result = false;
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Serializable id2 = id;
		Object persistentInstance = session.load(Customer.class, id2);
		if (persistentInstance != null) {
		    session.delete(persistentInstance);
		    result = true;
		}
		session.getTransaction().commit();
		session.close();
		return result;
	}

	@Override
	public Customer getCustomer(int id) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Customer customer = new Customer.CustomerBuilder(id).build();
		customer = (Customer) session.get(Customer.class, id);		
		session.getTransaction().commit();
		session.close();
		System.out.println("customer: " + customer.getCustomerName());
		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Customer> customers = (List<Customer>) session.createNativeQuery("SELECT * FROM customers").addScalar("customerNumber").addScalar("customerName").list();
		session.getTransaction().commit();
		session.close();
		return customers;
	}

}
