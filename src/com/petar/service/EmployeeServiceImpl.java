package com.petar.service;

import java.io.Serializable;
import java.util.List;

import javax.jws.WebService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.petar.model.Customer;
import com.petar.model.Employee;

@WebService(endpointInterface="com.petar.service.EmployeeService", portName="EmployeePort", serviceName="EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public boolean addEmployee(Employee employee) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean deleteEmployee(Integer id) {
		boolean result = false;
		SessionFactory sessionFactory = null;
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed. " + ex);
			ex.printStackTrace();
		}
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Serializable id2 = id;
		Object persistentInstance = session.load(Employee.class, id2);
		if (persistentInstance != null) {
		    session.delete(persistentInstance);
		    result = true;
		}
		session.getTransaction().commit();
		session.close();
		return result;
	}

	@Override
	public Employee getEmployee(int id) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Employee employee = new Employee.EmployeeBuilder(id).build();
		employee = (Employee) session.get(Employee.class, id);		
		session.getTransaction().commit();
		session.close();
		System.out.println("customer: " + employee.getFirstName());
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();		
		Query<Employee> query = session.createQuery("from com.petar.model.Employee");
		List<Employee> customers = query.list();
		session.getTransaction().commit();
		session.close();
		return customers;
	}

}
