package com.monika.DAOImpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.monika.DAO.UserDAO;
import com.monika.Model.Address;
import com.monika.Model.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public boolean save(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);	
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);	
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean delete(int id) {
		try {
			sessionFactory.getCurrentSession().delete(get(id));	
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public User get(int id) {
		try {
			return sessionFactory.getCurrentSession().get(User.class,id);	
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean save(Address address) {
		try {
			sessionFactory.getCurrentSession().save(address);	
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Address address) {
		try {
			sessionFactory.getCurrentSession().update(address);	
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Address getBillingAddress(int id) {
		try {
			return sessionFactory.getCurrentSession().get(Address.class,id);	
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
