package com.petar.service;

import java.util.List;

import javax.jws.WebService;

import com.petar.model.Product;

@WebService(endpointInterface="com.petar.service.ProductService", portName="ProductPort", serviceName="ProductService")
public class ProductServiceImpl implements ProductService {

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

}
