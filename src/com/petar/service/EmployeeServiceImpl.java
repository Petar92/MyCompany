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
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		entityManager.clear();
		entityManager.close();
		return true;
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Employee emp = entityManager.find(Employee.class, employee.getEmployeeNumber());
		entityManager.remove(emp);
		entityManager.getTransaction().commit();
		entityManager.clear();
		entityManager.close();
		return true;
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
		List<Employee> employees = new ArrayList<Employee>();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();;
		try {
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
			Root<Employee> rootEntry = cq.from(Employee.class);
			CriteriaQuery<Employee> all = cq.select(rootEntry);
			TypedQuery<Employee> allQuery = entityManager.createQuery(all);
			employees =  allQuery.getResultList();
			entityManager.getTransaction().commit();
		} catch(Exception e) {
			System.out.println("EXCEPTION CAUGHT " + e.getClass().toString() + "\nSTACK TRACE: ");
			e.printStackTrace();
			return null;
		} finally {
			entityManager.clear();
			entityManager.close();
		}
		return employees;
	}


}
