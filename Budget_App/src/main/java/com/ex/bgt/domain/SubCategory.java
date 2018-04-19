package com.ex.bgt.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "subcategory")
public class SubCategory 
{
	@Id
	@Column(name = "id")
	@GeneratedValue(generator="subcategory_id_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="subcategory_id_seq", sequenceName="subcategory_id_seq", allocationSize=1)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "initialFunds")
	private double initialFunds;
	
	@Column(name = "currentFunds")
	private double currentFunds;
	
	@Column(name = "priority")
	private int priority;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	public SubCategory(String name, double initialFunds, int priority, Category category) {
		this.name = name;
		this.initialFunds = initialFunds;
		this.currentFunds = initialFunds;
		this.category = category;
		List<SubCategory> updateList = category.getSubcategories();
		updateList.add(this);
		category.setSubcategories(updateList);
	}
	public SubCategory(int id, String name, double initialFunds, int priority, Category category) {
		this.id = id;
		this.name = name;
		this.initialFunds = initialFunds;
		this.currentFunds = initialFunds;
		this.priority = priority;
		this.category = category;
	}
	public SubCategory() {}
	
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
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
}
