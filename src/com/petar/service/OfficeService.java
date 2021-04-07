package com.petar.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.petar.model.Office;

@WebService(name="EmployeeServiceInterface", targetNamespace="http://petar.com")
public interface OfficeService {
	
	@WebMethod
	public boolean addOffice(Office office);
	
	@WebMethod
	public boolean deleteOffice(Office office);
	
	@WebMethod
	public Office getOffice(String id);
	
	@WebMethod
	public List<Office> getAllOffices();

}
