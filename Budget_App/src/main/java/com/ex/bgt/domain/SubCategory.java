package com.ex.bgt.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

public class SubCategory 
{
	@Id
	@Column(name = "id")
	@GeneratedValue(generator="subcategory_id_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="subcategory_id_seq", sequenceName="subcategory_id_seq", allocationSize=1)
	private int id;
	
	@Column(name = "name")
	public String name;
	
	@Column(name = "initialFunds")
	public double initialFunds;
	
	@Column(name = "currentFunds")
	public double currentFunds;
	
	@Column(name = "priority")
	public int priority;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	public Category parentCategory;
	
	public SubCategory(String name, double initialFunds, int priority) {
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
	
	public Category getParentCategory() {
		return parentCategory;
	}
	
	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}
	
}
