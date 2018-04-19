package com.ex.bgt.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User 
{
	@Id
	@Column(name = "id")
	@GeneratedValue(generator="users_id_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="users_id_seq", sequenceName="users_id_seq", allocationSize=1)
	private int id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private int password;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Category> categoryList;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<BgtTransaction> transactionList;
	
	@OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
	private Income income;

	public User(int id, String email, int password, String firstName, String lastName) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.transactionList = new ArrayList<BgtTransaction>();
	}
	
	public User(String email, int password, String firstName, String lastName) {
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.transactionList = new ArrayList<BgtTransaction>();
	}
	
	public User() {
		this.transactionList = new ArrayList<BgtTransaction>();
	}
	
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
	
	public List<Category> getCategoryList() {
		return categoryList;
	}
	
	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
	
	
	public List<BgtTransaction> getTransactionList() 
	{
		return transactionList;
	}
	
	public void setTransactionList(List<BgtTransaction> transactionList) 
	{
		this.transactionList = transactionList;
	}
	
	public Income getIncome()
	{
		return income;
	}
	
	public void setIncome(Income incoming)
	{
		income = incoming;
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
