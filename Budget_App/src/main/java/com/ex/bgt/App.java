package com.ex.bgt;

import java.util.List;

import com.ex.bgt.domain.Category;
import com.ex.bgt.domain.User;
import com.ex.dao.CategoryDao;
import com.ex.dao.UserDao;
import com.ex.impl.CategoryDaoImpl;
import com.ex.impl.UserDaoImpl;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        User usr = new User("nickaverrilli@gmail.com", 1216985755, "Nick", "Verrilli");
    	//User usr;
        UserDao usrDao = new UserDaoImpl();
        //int usrid = (Integer) usrDao.saveUser(usr);
        usr = usrDao.getUserById(3);
        //usr = usrDao.getUserByEmail("nverrilli@gmail.com");
        
        /*List<Category> cats = usr.getCategoryList();
        for(Category c: cats)
        {
        	System.out.println(c.getName());
        }*/
        //System.out.println(usr.getEmail());
    	
    	Category cat = new Category();
    	cat.setCurrentFunds(100);
    	cat.setInitialFunds(100);
    	cat.setName("Food");
    	cat.setPriority(2);
    	cat.setUser(usr);
    	
    	CategoryDao catDao = new CategoryDaoImpl();
    	int catid = (Integer) catDao.saveCategory(cat);
    	cat = catDao.getCategoryById(catid);
    	System.out.println(cat.getName());
    }
    
}
