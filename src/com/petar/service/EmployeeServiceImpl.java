package com.petar.service;

import java.util.List;

import javax.jws.WebService;

import com.petar.model.Employee;

@WebService(endpointInterface="com.petar.service.EmployeeService", portName="EmployeePort", serviceName="EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public boolean addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEmployee(Employee customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

}
