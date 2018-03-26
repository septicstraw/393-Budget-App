package com.ex.bgt.domain;

import java.sql.Date;
import java.util.List;
import java.util.Calendar;

public class User 
{
	int id;
	String email;
	int password;
	String firstName;
	String lastName;
	List<Category> categoryList;
	double initialFunds;
	List<Transaction> transactionLog;
	Income userIncome;
	
	public int getID() {
		return id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getPass() {
		return password;
	}
	
	public void setPass(int pass) {
		password = pass;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public List getCategoryList() {
		return categoryList;
	}
	
	public void setCategoryList(List categoryList) {
		this.categoryList = categoryList;
	}
	
	public double getInitialFunds() {
		return initialFunds;
	}
	
	public void setInitialFunds(double initialFunds) {
		this.initialFunds = initialFunds;
	}
	
	public List getTransactionLog() {
		return transactionLog;
	}
	
	public void setTransactionLog(List transactionLog) {
		this.transactionLog = transactionLog;
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
 * public void decreaseMoney(Category c, double amount, String note)
 * {
 * 		c.decreaseMoney(amount);
 * 		transactionList.add(new Transaction(c, amount, checkDate(), note));
 * }
 * 
 * public void addMoney(Category c, double amount, String note)
 * {
 * 		c.addMoney(amount);
 * 		transactionList.add(new Transaction(c, amount, checkDate(), note));
 * }
 * 
 * public double rollover()
 * {
 * 	double rolloverTotal = 0;
 * 	for(Category c: categoryList)
 * 	{
 * 		total += c.getCurrentFunds();
 * 		c.resetMoney();
 * 		income.setRollover(total);
 * 	}
 * }
 * 
 * public void getCurrentFunds()
 * {
 * 		//UI magic brings us to CurrentBudgetScreen
 * }
 * 
 * public void displayLog()
 * {
 * 		//UI magic brings us to TransactionLogScreen, but for now...
 * 		for(Transaction t: transactionList)
 * 		{
 * 			System.out.println("Category: " + t.getTransactionCategory().getName() + " --- 
 * 			Amount: " + t.getTransactionAmount() + " --- Date: " + t.getTransactionDate() + 
 * 			" --- Notes: " + t.getTransactionNotes());
 * 		}
 * }
 * 
 * public void setIncome(int id, double amount, double rollover, int payPeriod)
 * {
 * 		userIncome = new Income(id, amount, rollover, payPeriod);
 * }
 * 
 */
