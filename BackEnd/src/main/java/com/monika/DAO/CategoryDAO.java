package com.monika.DAO;

import java.util.List;

import com.monika.Model.Category;


public interface CategoryDAO {

	
	
	Category get(int id);
	List<Category> list();
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
	
	
}
