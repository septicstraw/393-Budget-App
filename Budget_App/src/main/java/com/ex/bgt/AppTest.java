package com.ex.bgt;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ex.bgt.domain.User;
import com.ex.dao.UserDao;
import com.ex.impl.UserDaoImpl;
import com.ex.bgt.domain.Category;
import com.ex.dao.CategoryDao;
import com.ex.impl.CategoryDaoImpl;

public class AppTest {

	//User Tests
	@Test
	public void testAddUser() {
		
		User usr = new User("test1@gmail.com", 12345, "Eric", "Feinstein");
        UserDao usrDao = new UserDaoImpl();
        usrDao.saveUser(usr);
        
        User usrResult = usrDao.getUserByEmail("test1@gmail.com");
        
        assertEquals(usr.getID(), usrResult.getID());
	}
	
	public void testGetSetEmail() {
		UserDao usrDao = new UserDaoImpl();
		User retrieve = usrDao.getUserByEmail("test1@gmail.com");
		
		retrieve.setEmail("test2@gmail.com");
		usrDao.saveUser(retrieve);
		
		User result = usrDao.getUserByEmail("test2@gmail.com");
		
		assertEquals(retrieve.getEmail(), result.getEmail());
	}
	
	//Category Tests
	@Test
	public void testAddCategory() {
		Category ctgry = new Category("rent", 1000, 1);
		CategoryDao ctgryDao = new CategoryDaoImpl();
		ctgryDao.saveCategory(ctgry);
		
		Category ctgryResult = ctgryDao.getCategoryByName("rent");
		
		assertEquals(ctgry.getName(), ctgryResult.getName());
	}

}
