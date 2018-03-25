package com.ex.bgt.domain;
import java.util.List;

public class Category 
{
	public String name;
	public double initialFunds;
	public double currentFunds;
	public int priority;
	public List<Category> subcategories;
	
	public Category(String name, double initialFunds, int priority) {
		this.name = name;
		this.initialFunds = initialFunds;
		this.currentFunds = initialFunds;
		this.priority = priority;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getInitialFunds() {
		return initialFunds;
	}
	
	public void setInitialFunds(double initialFunds) {
		this.initialFunds = initialFunds;
	}
	
	public double getCurrentFunds() {
		return currentFunds;
	}
	
	public void setCurrentFunds(double currentFunds) {
		this.currentFunds = currentFunds;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public List<Category> getSubcategories() {
		return subcategories;
	}
	
	public void setSubcategories(List<Category> subcategories) {
		this.subcategories = subcategories;
	}
	
}