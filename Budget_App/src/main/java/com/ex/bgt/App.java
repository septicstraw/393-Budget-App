package com.ex.bgt;

import java.util.List;

import com.ex.bgt.domain.Category;
import com.ex.bgt.domain.Income;
import com.ex.bgt.domain.User;
import com.ex.dao.CategoryDao;
import com.ex.dao.IncomeDao;
import com.ex.dao.UserDao;
import com.ex.impl.CategoryDaoImpl;
import com.ex.impl.IncomeDaoImpl;
import com.ex.impl.UserDaoImpl;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //User usr = new User("nickverrilli@gmail.com", 1216985755, "Nick", "Verrilli");
    	//User usr;
        UserDao usrDao = new UserDaoImpl();
        //usrDao.saveUser(usr);
        
    	User usr = usrDao.getUserById(2);
        IncomeDao incDao = new IncomeDaoImpl();
        Income inc = new Income(100, 1, 1, 1, usr);
        incDao.saveIncome(inc);
        //usr = usrDao.getUserByEmail("nverrilli@gmail.com");
        
        /*List<Category> cats = usr.getCategoryList();
        for(Category c: cats)
        {
        	System.out.println(c.getName());
        }*/
        //System.out.println(usr.getEmail());
    	
    	/*Category cat = new Category();
    	cat.setCurrentFunds(100);
    	cat.setInitialFunds(100);
    	cat.setName("Electronics");
    	cat.setPriority(3);
    	cat.setUser(usr);
    	
    	CategoryDao catDao = new CategoryDaoImpl();
    	catDao.saveCategory(cat);*/
    }
    
}
