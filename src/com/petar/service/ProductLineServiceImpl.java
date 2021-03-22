package com.petar.service;

import java.util.List;

import javax.jws.WebService;

import com.petar.model.ProductLine;

@WebService(endpointInterface="com.petar.service.ProductLineService", portName="ProductLinePort", serviceName="ProductLineService")
public class ProductLineServiceImpl implements ProductLineService {

	@Override
	public boolean addProductLine(ProductLine productLine) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProductLine(ProductLine productLine) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ProductLine getProductLine(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductLine> getAllProductLines() {
		// TODO Auto-generated method stub
		return null;
	}

}
