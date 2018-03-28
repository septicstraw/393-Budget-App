package com.ex.bgt;

import java.util.List;

import com.ex.bgt.domain.BgtTransaction;
import com.ex.bgt.domain.Category;
import com.ex.bgt.domain.SubCategory;
import com.ex.bgt.domain.User;
import com.ex.dao.CategoryDao;
import com.ex.dao.UserDao;
import com.ex.impl.CategoryDaoImpl;
import com.ex.impl.UserDaoImpl;
import java.sql.Timestamp;

public class UserMethods 
{
	
	public void changeMoney(Category c, double amount, String notes, User thisGuy)
	{
		double temp = c.getCurrentFunds();
		temp+= amount;
		c.setCurrentFunds(temp);
		Timestamp time = new Timestamp(System.currentTimeMillis());
		List tempList = thisGuy.getTransactionList();
		tempList.add(new BgtTransaction(amount, time, notes, c, thisGuy));
		thisGuy.setTransactionList(tempList);
		
		UserDao usDao = new UserDaoImpl();
		usDao.saveUser(thisGuy);
		CategoryDao catDao = new CategoryDaoImpl();
		catDao.saveCategory(c);
	}
	
	public void changeMoneySubCategory(Category c, SubCategory s, double amount, String notes, User thisGuy)
	{
		double temp = s.getCurrentFunds();
		temp+= amount;
		s.setCurrentFunds(temp);
		Timestamp time = new Timestamp(System.currentTimeMillis());
		List tempList = thisGuy.getTransactionList();
		tempList.add(new BgtTransaction(amount, time, notes, c, s, thisGuy));
		thisGuy.setTransactionList(tempList);
		
		UserDao usDao = new UserDaoImpl();
		usDao.saveUser(thisGuy);
		CategoryDao catDao = new CategoryDaoImpl();
		catDao.saveCategory(c);
	}
	
	public double rollover(User thisGuy)
	{
		List<Category> catList = thisGuy.getCategoryList();
		double rollingTotal = 0;
		CategoryDao catDao = new CategoryDaoImpl();
		CategoryMethods catMeth = new CategoryMethods();
		for(Category category: catList)
		{
			rollingTotal += catMeth.resetMoney(category);
			catDao.saveCategory(category);
		}
		return rollingTotal;
	}
	
	//Shows all categories and how much money is in each
	public void viewBudget()
	{
		//UI Magic goes here
	}
	
	//Shows the list of logged transactions
	public void viewLog(User usr)
	{
		List<BgtTransaction> tempList = usr.getTransactionList();
		for(BgtTransaction transact: tempList)
		{
			System.out.print("Date: " + transact.getTransactionDate() + " --- ");
			System.out.print("Category: " + transact.getTransactionCategory().getName() + " --- ");
			System.out.print("Amount: " + transact.getTransactionAmount() + " --- ");
			System.out.println("Notes: " + transact.getTransactionNotes() + " --- ");
		}
	}
}

