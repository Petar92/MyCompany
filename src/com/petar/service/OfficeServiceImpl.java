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

import com.petar.model.Office;

@WebService(endpointInterface="com.petar.service.OfficeService", portName="OfficePort", serviceName="OfficeService")
public class OfficeServiceImpl implements OfficeService {
	
	private EntityManagerFactory entityManagerFactory;
	
	public OfficeServiceImpl(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	public boolean addOffice(Office office) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(office);
		entityManager.getTransaction().commit();
		entityManager.clear();
		entityManager.close();
		return true;
	}

	@Override
	public boolean deleteOffice(Office office) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Office off = entityManager.find(Office.class, office.getOfficeCode());
		entityManager.remove(off);
		entityManager.getTransaction().commit();
		entityManager.clear();
		entityManager.close();
		return true;
	}

	@Override
	public Office getOffice(String id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Office office = entityManager.find(Office.class, id);
		entityManager.getTransaction().commit();
		entityManager.clear();
		entityManager.close();
		return office;
	}

	@Override
	public List<Office> getAllOffices() {
		List<Office> offices = new ArrayList<Office>();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();;
		try {
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<Office> cq = cb.createQuery(Office.class);
			Root<Office> rootEntry = cq.from(Office.class);
			CriteriaQuery<Office> all = cq.select(rootEntry);
			TypedQuery<Office> allQuery = entityManager.createQuery(all);
			offices =  allQuery.getResultList();
			entityManager.getTransaction().commit();
		} catch(Exception e) {
			System.out.println("EXCEPTION CAUGHT " + e.getClass().toString() + "\nSTACK TRACE: ");
			e.printStackTrace();
			return null;
		} finally {
			entityManager.clear();
			entityManager.close();
		}
		return offices;
	}

}
