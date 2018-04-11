package com.ex.bgt;

import com.ex.bgt.domain.Category;

public class CategoryMethods 
{
	public double resetMoney(Category c)
	{
		double current = c.getCurrentFunds();
		c.setCurrentFunds(c.getInitialFunds());
		CategoryDao catDao = new CategoryDaoImpl();
		catDao.saveCategory(c);
		return current;
	}
	
	public double resetSubcategoryFunds(Category c)
	{
		double rollingTotal = 0;
		List<SubCategory> subList = thisGuy.getSubCategories();
		SubCategoryDao subDao = new SubCategoryDaoImpl()
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
		List<SubCategory> subList = thisGuy.getSubCategories();
		for(SubCategory sub: subList)
		{
			rollingTotal += sub.getCurrentFunds();
		}
		CategoryDao catDao = new CategoryDaoImpl();
		catDao.saveCategory(c);
		return rollingTotal;
	}
}
