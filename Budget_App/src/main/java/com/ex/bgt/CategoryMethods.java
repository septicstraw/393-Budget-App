package com.ex.bgt;

import java.util.List;

import com.ex.bgt.domain.Category;
import com.ex.bgt.domain.SubCategory;
import com.ex.bgt.domain.User;
import com.ex.dao.CategoryDao;
import com.ex.dao.SubCategoryDao;
import com.ex.impl.CategoryDaoImpl;
import com.ex.impl.SubCategoryDaoImpl;

public class CategoryMethods 
{
	public double resetMoney(User thisGuy, Category c)
	{
		double current = c.getCurrentFunds();
		c.setCurrentFunds(c.getInitialFunds());
		CategoryDao catDao = new CategoryDaoImpl();
		catDao.saveCategory(c);
		return current;
	}
	
	public double resetSubcategoryFunds(User thisGuy, Category c)
	{
		double rollingTotal = 0;
		List<SubCategory> subList = c.getSubcategories();
		SubCategoryDao subDao = new SubCategoryDaoImpl();
		for(SubCategory sub: subList)
		{
			rollingTotal += sub.getCurrentFunds();
			sub.setCurrentFunds(sub.getInitialFunds());
			subDao.saveSubCategory(sub);
		}
		CategoryDao catDao = new CategoryDaoImpl();
		catDao.saveCategory(c);
		return rollingTotal;
	}
	
	public double totalSubcategoryFunds(Category c)
	{
		double rollingTotal = 0;
		List<SubCategory> subList = c.getSubcategories();
		for(SubCategory sub: subList)
		{
			rollingTotal += sub.getCurrentFunds();
		}
		CategoryDao catDao = new CategoryDaoImpl();
		catDao.saveCategory(c);
		return rollingTotal;
	}
}
