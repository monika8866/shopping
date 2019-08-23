package com.monika.BackEnd;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.monika.DAO.UserDAO;
import com.monika.Model.Address;
import com.monika.Model.User;

public class UserTest {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Address address=null;
	
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.monika");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
    @Ignore
	@Test
	public void saveUser() {
		
		user = new User() ;
		user.setFirstName("Monika");
		user.setLastName("Tiwari");
		user.setEmail("mt@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("CUSTOMER");
		user.setEnabled(true);
		user.setPassword("12345");
		
		
		
		// add the user
		//assertEquals("Failed to add the user!", true, userDAO.save(user));	
	
	}
	
    @Ignore
   	@Test
   	public void saveAddress() {
    	
    	address= new Address();
    	address.setAddressLineOne("ADD1");
    	address.setAddressLineTwo("ADD2");
    	address.setBilling(true);
    	address.setCity("LKO");
    	address.setCountry("INDIA");
    	address.setPostalCode("226002");
    	address.setShipping(true);
    	address.setState("U.P.");
    	
    	//assertEquals("Failed to add the user!", true, userDAO.save(address));	
    }

	
}