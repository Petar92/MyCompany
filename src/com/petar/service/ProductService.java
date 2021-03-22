package com.petar.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.petar.model.Product;

@WebService(name="ProductServiceInterface", targetNamespace="http://petar.com")
public interface ProductService {
	
	@WebMethod
	public boolean addProduct(Product product);
	
	@WebMethod
	public boolean deleteProduct(Product product);
	
	@WebMethod
	public Product getProduct(int id);
	
	@WebMethod
	public List<Product> getAllProducts();

}
