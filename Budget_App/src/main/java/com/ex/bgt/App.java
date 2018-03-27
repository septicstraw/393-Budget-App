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
        User usr = new User("nickverrilli@gmail.com", 88204, "Nick", "Verrilli");
        
        UserDao usrDao = new UserDaoImpl();
        usrDao.saveUser(usr);
    }
}
