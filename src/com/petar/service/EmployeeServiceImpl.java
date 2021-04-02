package com.petar.service;

import java.io.Serializable;
import java.util.List;

import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.petar.model.Customer;
import com.petar.model.Employee;

@WebService(endpointInterface="com.petar.service.EmployeeService", portName="EmployeePort", serviceName="EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	private EntityManagerFactory entityManagerFactory = null;
	
	public EmployeeServiceImpl(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	
	@Override
	public boolean addEmployee(Employee employee) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		System.out.println("Created entity manager...");
		entityManager.getTransaction().begin();
		System.out.println("Transaction started...");
		entityManager.persist(employee);
		System.out.println(employee.getFirstName() + " persisted...");
		entityManager.getTransaction().commit();
		System.out.println("Transaction started...");
		entityManager.clear();
		System.out.println("Cleard entity manager...");
		entityManager.close();
		System.out.println("Closed entity manager...");
		return true;
	}

	@Override
	public boolean deleteEmployee(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee getEmployee(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Employee employee = new Employee.EmployeeBuilder().build();
		employee = entityManager.find(Employee.class, id);
		entityManager.getTransaction().commit();
		entityManager.clear();
		entityManager.close();
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}


}
