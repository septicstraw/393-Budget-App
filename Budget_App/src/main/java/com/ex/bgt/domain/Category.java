package com.ex.bgt.domain;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "category")
public class Category 
{
	@Id
	@Column(name = "id")
	@GeneratedValue(generator="category_id_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="category_id_seq", sequenceName="category_id_seq", allocationSize=1)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "initialFunds")
	private double initialFunds;
	
	@Column(name = "currentFunds")
	private double currentFunds;
	
	@Column(name = "priority")
	private int priority;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<SubCategory> subcategories;
	
	@ManyToOne
	@JoinColumn(name = "userid")
	private User user;
	
	public Category(String name, double initialFunds, int priority) {
		this.name = name;
		this.initialFunds = initialFunds;
		this.currentFunds = initialFunds;
		this.priority = priority;
	}
	public Category(int id, String name, double initialFunds, int priority) {
		this.id = id;
		this.name = name;
		this.initialFunds = initialFunds;
		this.currentFunds = initialFunds;
		this.priority = priority;
	}
	public Category() {
		super();
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
	
	public List<SubCategory> getSubcategories() {
		return subcategories;
	}
	
	public void setSubcategories(List<SubCategory> subcategories) {
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
