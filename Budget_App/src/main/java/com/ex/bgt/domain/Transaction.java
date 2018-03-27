package com.ex.bgt.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

public class Transaction 
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
	@JoinColumn(name = "user_id")
	private User user;
	
		
	public Transaction(int id, double transactionAmount, Timestamp transactionDate, String transactionNotes,
			Category transactionCategory, User user) {
		super();
		this.id = id;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
		this.transactionNotes = transactionNotes;
		this.transactionCategory = transactionCategory;
		this.user = user;
	}
	
	public Transaction(double transactionAmount, Timestamp transactionDate, String transactionNotes,
			Category transactionCategory, User user) {
		super();
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
		this.transactionNotes = transactionNotes;
		this.transactionCategory = transactionCategory;
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
}
