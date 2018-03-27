package com.ex.bgt;

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
        System.out.println( "Hello World!" );
        User usr = new User();
        usr.setEmail("nickverrilli@gmail.com");
        usr.setPass(88204);
        usr.setFirstName("Nick");
        usr.setLastName("Verrilli");
        
        UserDao usrDao = new UserDaoImpl();
        usrDao.saveUser(usr);
    }
}
