package com.petar.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.petar.model.Employee;

@WebService(name="EmployeeServiceInterface", targetNamespace="http://petar.com")
public interface EmployeeService {
	
	@WebMethod
	public boolean addEmployee(Employee employee);
	
	@WebMethod
	public boolean deleteEmployee(Employee employee);
	
	@WebMethod
	public Employee getEmployee(int id);
	
	@WebMethod
	public List<Employee> getAllEmployees();

}
