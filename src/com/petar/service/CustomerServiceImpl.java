package com.petar.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

	@Override
	public boolean deleteCustomer(Customer customer) {
		EntityManager entityManager = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			entityManager.remove(entityManager.contains(customer) ? customer : entityManager.merge(customer));
			entityManager.getTransaction().commit();
		} catch(Exception e) {
			System.out.println("EXCEPTION CAUGHT " + e.getClass().toString() + "\nSTACK TRACE: ");
			e.printStackTrace();
			return false;
		} finally {
			entityManager.clear();
			entityManager.close();
		}
		return true;
	}

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
	public List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		EntityManager entityManager = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
			Root<Customer> rootEntry = cq.from(Customer.class);
			CriteriaQuery<Customer> all = cq.select(rootEntry);
			TypedQuery<Customer> allQuery = entityManager.createQuery(all);
			customers =  allQuery.getResultList();
			
			entityManager.getTransaction().commit();
		} catch(Exception e) {
			System.out.println("EXCEPTION CAUGHT " + e.getClass().toString() + "\nSTACK TRACE: ");
			e.printStackTrace();
			return null;
		} finally {
			entityManager.clear();
			entityManager.close();
		}
		return customers;
	}
}
