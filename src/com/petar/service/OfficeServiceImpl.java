package com.petar.service;

import java.util.List;

import javax.jws.WebService;

import com.petar.model.Office;

@WebService(endpointInterface="com.petar.service.OfficeService", portName="OfficePort", serviceName="OfficeService")
public class OfficeServiceImpl implements OfficeService {

	@Override
	public boolean addOffice(Office office) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteOffice(Office office) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Office getOffice(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Office> getAllOffices() {
		// TODO Auto-generated method stub
		return null;
	}

}
