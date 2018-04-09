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

	@Test
	public void testAddUser() {
		User usr = new User("123@gmail.com", 88204, "Nick", "Verrilli");
        UserDao usrDao = new UserDaoImpl();
        usrDao.saveUser(usr);
        
        User usrResult = usrDao.getUserByEmail("123@gmail.com");
        
        assertEquals(usr.getEmail(), usrResult.getEmail());
	}
	
	@Test
	public void testAddCategory() {
		Category ctgry = new Category("rent", 1000, 1);
		CategoryDao ctgryDao = new CategoryDaoImpl();
		ctgryDao.saveCategory(ctgry);
		
		Category ctgryResult = ctgryDao.getCategoryByName("rent");
		
		assertEquals(ctgry.getName(), ctgryResult.getName());
	}

}
