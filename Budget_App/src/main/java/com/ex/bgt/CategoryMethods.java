package com.ex.bgt;

import com.ex.bgt.domain.Category;

public class CategoryMethods 
{
	public double resetMoney(Category c)
	{
		double current = c.getCurrentFunds();
		c.setCurrentFunds(c.getInitialFunds());
		return current;
	}
}
