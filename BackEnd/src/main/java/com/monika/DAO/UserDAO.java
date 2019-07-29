    
package com.monika.DAO;

import com.monika.Model.Address;
import com.monika.Model.User;

public interface UserDAO {

	public boolean save(User user);
	public boolean update(User user);
	public boolean delete(int id);
	
	public User get(int id);
	
	public boolean save(Address address);
	public boolean update(Address address);
	
	public Address getBillingAddress(int id);
}