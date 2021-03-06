package com.ex.bgt;

import java.util.Calendar;
import java.util.List;
import java.util.Date;
import java.util.GregorianCalendar;

import com.ex.bgt.domain.BgtTransaction;
import com.ex.bgt.domain.Category;
import com.ex.bgt.domain.SubCategory;
import com.ex.bgt.domain.User;
import com.ex.dao.CategoryDao;
import com.ex.dao.SubCategoryDao;
import com.ex.dao.UserDao;
import com.ex.impl.CategoryDaoImpl;
import com.ex.impl.SubCategoryDaoImpl;
import com.ex.impl.UserDaoImpl;

import java.sql.Timestamp;

public class UserMethods 
{
	
	public void changeMoney(Category c, double amount, String notes, User thisGuy)
	{
		double temp = c.getCurrentFunds();
		temp+= amount;
		if(temp >= 0)
		{
			c.setCurrentFunds(temp);
			Timestamp time = new Timestamp(System.currentTimeMillis());
			List tempList = thisGuy.getTransactionList();
			tempList.add(new BgtTransaction(amount, time, notes, c, thisGuy, c.getCurrentFunds()));
			thisGuy.setTransactionList(tempList);
			
			if(c.getCurrentFunds() < 10)
			{
				rearrange(thisGuy, c);
			}
			
			UserDao usDao = new UserDaoImpl();
			usDao.updateUser(thisGuy);
			CategoryDao catDao = new CategoryDaoImpl();
			catDao.updateCategory(c);
		}
	}
	
	public void changeMoneySubCategory(Category c, SubCategory s, double amount, String notes, User thisGuy)
	{
		double temp = s.getCurrentFunds();
		temp+= amount;
		s.setCurrentFunds(temp);
		Timestamp time = new Timestamp(System.currentTimeMillis());
		List tempList = thisGuy.getTransactionList();
		tempList.add(new BgtTransaction(amount, time, notes, c, s, thisGuy, s.getCurrentFunds()));
		thisGuy.setTransactionList(tempList);
		
		UserDao usDao = new UserDaoImpl();
		usDao.updateUser(thisGuy);
		CategoryDao catDao = new CategoryDaoImpl();
		catDao.updateCategory(c);
		SubCategoryDao subDao = new SubCategoryDaoImpl();
		subDao.updateSubCategory(s);
	}
	
	public double rollover(User thisGuy)
	{
		List<Category> catList = thisGuy.getCategoryList();
		double rollingTotal = 0;
		CategoryDao catDao = new CategoryDaoImpl();
		CategoryMethods catMeth = new CategoryMethods();
		for(Category category: catList)
		{
			rollingTotal += catMeth.resetMoney(thisGuy, category);
			rollingTotal += catMeth.resetSubcategoryFunds(thisGuy, category);
			catDao.updateCategory(category);
		}
		Timestamp time = new Timestamp(System.currentTimeMillis());
		changeMoney(catList.get(0), rollingTotal, "Rollover Total Added to First Category", thisGuy);
		catDao.updateCategory(catList.get(0));
		return rollingTotal;
	}
	
	public void checkDate(User thisGuy)
	{
		Calendar c = new GregorianCalendar();
		Date date = new Date();
		c.setTime(date);
		if(c.get(Calendar.DAY_OF_MONTH) == 1)
		{
			rollover(thisGuy);
		}
	}
	
	public void rearrange(User thisGuy, Category c)
	{
		List<Category> catList = thisGuy.getCategoryList();
		Category transferCat = catList.get(0);
		for(Category category: catList)
		{
			if(transferCat.getPriority() < category.getPriority())
			{
				transferCat = category;
			}
		}
		if(transferCat.getCurrentFunds() > 50)
		{
			changeMoney(transferCat, -25, "Automatic Readjusting", thisGuy);
			changeMoney(c, 25, "Automatic Readjusting", thisGuy);
		}

	}
	
	public void changeCategoryFunds(Category c, double amount, User thisGuy)
	{
		c.setInitialFunds(amount);
		
		UserDao usDao = new UserDaoImpl();
		usDao.updateUser(thisGuy);
		CategoryDao catDao = new CategoryDaoImpl();
		catDao.updateCategory(c);
	}
	
	public void changeSubCategoryFunds(Category c, SubCategory s, double amount, User thisGuy)
	{
		s.setInitialFunds(amount);
		
		UserDao usDao = new UserDaoImpl();
		usDao.updateUser(thisGuy);
		CategoryDao catDao = new CategoryDaoImpl();
		catDao.updateCategory(c);
		SubCategoryDao subDao = new SubCategoryDaoImpl();
		subDao.saveSubCategory(s);
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

