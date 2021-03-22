package com.petar.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.petar.model.ProductLine;

@WebService(name="ProductLineServiceInterface", targetNamespace="http://petar.com")
public interface ProductLineService {
	
	@WebMethod
	public boolean addProductLine(ProductLine productLine);
	
	@WebMethod
	public boolean deleteProductLine(ProductLine productLine);
	
	@WebMethod
	public ProductLine getProductLine(int id);
	
	@WebMethod
	public List<ProductLine> getAllProductLines();

}
