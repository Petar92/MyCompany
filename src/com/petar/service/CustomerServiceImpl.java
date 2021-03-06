package com.petar.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.petar.model.Customer;

@WebService(endpointInterface="com.petar.service.CustomerService", portName="CustomerPort", serviceName="CustomerService")
public class CustomerServiceImpl implements CustomerService {
	
	private SessionFactory sessionFactory = null;
	
	public CustomerServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean addCustomer(Customer customer) {
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
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed. " + ex);
			ex.printStackTrace();
		}
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
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Customer customer = new Customer.CustomerBuilder().build();
		customer = (Customer) session.get(Customer.class, id);		
		session.getTransaction().commit();
		session.close();
		System.out.println("customer: " + customer.getCustomerName());
		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();		
		Query<Customer> query = session.createQuery("from com.petar.model.Customer");
		List<Customer> customers = query.list();
		session.getTransaction().commit();
		session.close();
		return customers;
	}

}
