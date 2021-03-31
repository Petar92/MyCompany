package com.petar.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.petar.model.Customer;

@WebService(endpointInterface="com.petar.service.CustomerService", portName="CustomerPort", serviceName="CustomerService")
public class CustomerServiceImpl implements CustomerService {
	
	private EntityManagerFactory entityManagerFactory = null;
		
	public CustomerServiceImpl(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	public boolean addCustomer(Customer customer) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(customer);
		entityManager.getTransaction().commit();
		entityManager.clear();
		entityManager.close();
		return true;
	}
//
//	@Override
//	public boolean deleteCustomer(Integer id) {
//		boolean result = false;
//		try {
//			sessionFactory = new Configuration().configure().buildSessionFactory();
//		} catch (Throwable ex) {
//			System.err.println("Initial SessionFactory creation failed. " + ex);
//			ex.printStackTrace();
//		}
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		Serializable id2 = id;
//		Object persistentInstance = session.load(Customer.class, id2);
//		if (persistentInstance != null) {
//		    session.delete(persistentInstance);
//		    result = true;
//		}
//		session.getTransaction().commit();
//		session.close();
//		return result;
//	}

	@Override
	public Customer getCustomer(Integer id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Customer customer = new Customer.CustomerBuilder().build();
		customer = entityManager.find(Customer.class, id);
		entityManager.getTransaction().commit();
		entityManager.clear();
		entityManager.close();
		System.out.println("customer: " + customer.getContactFirstName());
		return customer;
	}

	@Override
	public boolean deleteCustomer(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<Customer> getAllCustomers() {
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();		
//		Query<Customer> query = session.createQuery("from com.petar.model.Customer");
//		List<Customer> customers = query.list();
//		session.getTransaction().commit();
//		session.close();
//		return customers;
//	}

}
