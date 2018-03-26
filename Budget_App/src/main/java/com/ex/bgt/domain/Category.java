package com.ex.bgt.domain;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Category 
{
	@Id
	@Column(name = "id")
	@GeneratedValue(generator="category_id_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="category_id_seq", sequenceName="category_id_seq", allocationSize=1)
	int id;
	
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

//I'll be honest I have no idea where stuff goes anymore
//So I'm gonna add the methods here and then you can relocate them to wherever they go
/*
* public Date checkDate()
* {
* 		return Calendar.getInstance();
* }
* 
* public void decreaseMoney(double amount)
* {
* 		currentFunds -= amount;
* }
* 
* public void addMoney(double amount)
* {
* 		currentFunds += amount;
* }
* 
* public void resetMoney()
* {
* 		currentFunds = initialFunds();
* } 
* 
*/
