package com.ex.bgt;

import java.util.List;

import com.ex.bgt.domain.Category;
import com.ex.bgt.domain.User;
import com.ex.dao.CategoryDao;
import com.ex.dao.UserDao;
import com.ex.impl.CategoryDaoImpl;
import com.ex.impl.UserDaoImpl;

public class UserMethods 
{
	public void addMoney(Category c, double amount)
	{
		double temp = c.getCurrentFunds();
		temp+= amount;
		c.setCurrentFunds(temp);
		CategoryDao catDao = new CategoryDaoImpl();
		catDao.saveCategory(c);
	}
}

