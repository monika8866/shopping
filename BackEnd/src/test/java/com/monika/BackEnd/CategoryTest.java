package com.monika.BackEnd;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.monika.DAO.CategoryDAO;
import com.monika.Model.Category;

public class CategoryTest {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.monika");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	
@Ignore	
@Test
	public void AddCategory() {
		
		category = new Category();
		
		category.setName("Laptop");
		category.setDescription("DEVICE");
	
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
		
		
	}
	
	@Ignore
	@Test
	public void testCRUDCategory() {
		
		category = new Category();
		
		category.setName("Laptop");
		category.setDescription("Device");
	
		
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
		
		
		category = new Category();
		
		category.setName("Television");
		category.setDescription("Device");
	
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));

		
		// fetching and updating the category
	/*	category = categoryDAO.get(2);
		
		category.setName("TV");
		
		assertEquals("Successfully updated a single category in the table!",true,categoryDAO.update(category));
		
		
		// delete the category
		assertEquals("Successfully deleted a single category in the table!",true,categoryDAO.delete(category));
		
		
		//fetching the list
		assertEquals("Successfully fetched the list of categories from the table!",1,categoryDAO.list().size());		
				
		*/
	}
	
	
}