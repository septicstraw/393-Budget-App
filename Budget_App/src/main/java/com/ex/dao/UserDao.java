package com.ex.dao;

import java.io.Serializable;
import java.util.List;

import com.ex.bgt.domain.User;


public interface UserDao {
	
	public User getUserById(int id);

	public List<User> getAllUsers();
	
	public User getUserByEmail(String email);
	
	public Serializable saveUser(User usr);

}
