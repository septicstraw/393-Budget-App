package com.ex.bgt;

import java.util.List;

import com.ex.bgt.domain.Category;
import com.ex.bgt.domain.User;
import com.ex.dao.UserDao;
import com.ex.impl.UserDaoImpl;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        User usr = new User("nickverrilli@gmail.com", 88204, "Nick", "Verrilli");
        UserDao usrDao = new UserDaoImpl();
        usrDao.saveUser(usr);
        usr = usrDao.getUserByEmail("nickverrilli@gmail.com");
        
        List<Category> cats = usr.getCategoryList();
        for(Category c: cats)
        {
        	System.out.println(c.getName());
        }
        
    }
}
