package com.ex.bgt.domain;
import java.util.ArrayList;
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
		this.subcategories = new ArrayList<SubCategory>();
	}
	public Category(int id, User user, String name, double initialFunds, int priority) {
		this.id = id;
		this.name = name;
		this.initialFunds = initialFunds;
		this.currentFunds = initialFunds;
		this.priority = priority;
		this.user = user;
		this.subcategories = new ArrayList<SubCategory>();
	}
	public Category(User user, String name, double initialFunds, int priority) {
		this.user = user;
		this.name = name;
		this.initialFunds = initialFunds;
		this.currentFunds = initialFunds;
		this.priority = priority;
		this.subcategories = new ArrayList<SubCategory>();
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
	
	public int getId() {
		return id;
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
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
}