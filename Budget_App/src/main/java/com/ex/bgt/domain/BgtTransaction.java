package com.ex.bgt.domain;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
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
@Table(name = "transaction")
public class BgtTransaction
{
	@Id
	@Column(name = "id")
	@GeneratedValue(generator="transaction_id_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="transaction_id_seq", sequenceName="transaction_id_seq", allocationSize=1)
	private int id;
	
	@Column(name = "amount")
	private double transactionAmount;
	
	@Column(name = "date")
	private Timestamp transactionDate;
	
	@Column(name = "notes")
	private String transactionNotes;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category transactionCategory;
	
	@ManyToOne
	@JoinColumn(name = "userid")
	private User user;
	
	public BgtTransaction() {}
		
	public BgtTransaction(int id, double transactionAmount, Timestamp transactionDate, String transactionNotes,
			Category transactionCategory, User user, double amountRemaining) {
		super();
		this.id = id;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
		this.transactionNotes = transactionNotes;
		this.transactionCategory = transactionCategory;
		this.user = user;
	}
	
	public BgtTransaction(double transactionAmount, Timestamp transactionDate, String transactionNotes,
			Category transactionCategory, User user, double amountRemaining) {
		super();
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
		this.transactionNotes = transactionNotes;
		this.transactionCategory = transactionCategory;
		this.user = user;
	}

	public BgtTransaction(int id, double transactionAmount, Timestamp transactionDate, String transactionNotes,
			Category transactionCategory, SubCategory transactionSubCategory, User user, double amountRemaining) {
		super();
		this.id = id;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
		this.transactionNotes = transactionNotes;
		this.transactionCategory = transactionCategory;
		//this.transactionSubCategory = transactionSubCategory;
		this.user = user;
	}
	
	public BgtTransaction(double transactionAmount, Timestamp transactionDate, String transactionNotes,
			Category transactionCategory, SubCategory transactionSubCategory, User user, double amountRemaining) {
		super();
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
		this.transactionNotes = transactionNotes;
		this.transactionCategory = transactionCategory;
		//this.transactionSubCategory = transactionSubCategory;
		this.user = user;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Timestamp getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionNotes() {
		return transactionNotes;
	}

	public void setTransactionNotes(String transactionNotes) {
		this.transactionNotes = transactionNotes;
	}

	public void setTransactionCategory(Category transactionCategory) {
		this.transactionCategory = transactionCategory;
	}
	
	public Category getTransactionCategory() {
		return transactionCategory;
	}
	
	public User getTransactionUser() {
		return user;
	}
	
	public void setTransactionUser(User user) {
		this.user = user;
	}
	
	
}
