package com.ex.bgt;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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
		
		User usr = new User("test_demo@gmail.com", 12345, "Eric", "Feinstein");
        UserDao usrDao = new UserDaoImpl();
        usrDao.saveUser(usr);
        
        User usrResult = usrDao.getUserByEmail("test_demo@gmail.com");
        
        assertEquals(usr.getID(), usrResult.getID());
	}
	
	@Test
	public void testGetSetFirst() {
		UserDao usrDao = new UserDaoImpl();
		User retrieve = usrDao.getUserByEmail("test1@gmail.com");
		
		retrieve.setFirstName("Bruce");
		usrDao.updateUser(retrieve);
		
		User result = usrDao.getUserByEmail("test1@gmail.com");
		
		assertEquals(retrieve.getFirstName(), result.getFirstName());
	}
	
	@Test
	public void testGetSetLast() {
		UserDao usrDao = new UserDaoImpl();
		User retrieve = usrDao.getUserByEmail("test1@gmail.com");
		
		retrieve.setLastName("Springsteen");
		usrDao.updateUser(retrieve);
		
		User result = usrDao.getUserByEmail("test1@gmail.com");
		
		assertEquals(retrieve.getFirstName(), result.getFirstName());
	}
	
	@Test
	public void testAddCategory() {
		Category ctgry = new Category("rent", 1000, 1);
		CategoryDao ctgryDao = new CategoryDaoImpl();
		int savedId = (Integer) ctgryDao.saveCategory(ctgry);
		
		System.out.println("ID IS " + savedId + " AND NAME IS " + ctgry.getName());
		
		Category ctgryResult = ctgryDao.getCategoryById(savedId);
		
		System.out.println("GOT " + ctgryResult.getName());
		
		assertEquals(ctgry.getName(), ctgryResult.getName());
	}
	
	@Test
	public void testGetSetCategoryList() {
		UserDao usrDao = new UserDaoImpl();
		User retrieve = usrDao.getUserByEmail("test1@gmail.com");
		
		List<Category> catList = retrieve.getCategoryList();
		System.out.println("List: " + catList);
		
		CategoryDao catDao = new CategoryDaoImpl();
		Category newCat = new Category(retrieve, "fun", 10000, 1);
		catDao.saveCategory(newCat);
		System.out.println("Cat name: " + newCat.getName());
		
		catList.add(newCat);
		retrieve.setCategoryList(catList);
		
		usrDao.updateUser(retrieve);
		
		User result = usrDao.getUserByEmail("test1@gmail.com");
		
		assertEquals(retrieve.getCategoryList().get(0).getName(), result.getCategoryList().get(0).getName());
	}
	
	//Category Tests
	
	@Test
	public void testGetSetCategoryName() {
		CategoryDao catDao = new CategoryDaoImpl();
		Category retrieve = catDao.getCategoryById(62); //Example (currently in db)
		
		retrieve.setName("food");
		catDao.updateCategory(retrieve);
		
		Category result = catDao.getCategoryById(62);
		
		assertEquals(result.getName(), retrieve.getName());
	}
}
