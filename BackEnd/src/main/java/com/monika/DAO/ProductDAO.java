package com.monika.DAO;

import java.util.List;

import com.monika.Model.Product;

public interface ProductDAO {

	Product get(int productId);
	List<Product> list();	
	public boolean add(Product product);
	public boolean update(Product product);
	public boolean delete(Product product);

	List<Product> getProductsByParam(String param, int count);	
	
	
	// business methods
	List<Product> listActiveProducts();	
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
	
}