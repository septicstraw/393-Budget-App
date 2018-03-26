package com.ex.domain;

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
@Table(name="BANK_ACCOUNTS")
public class BankAccount {
	
	@Id
	@Column(name="BA_ID")
	@GeneratedValue(generator="acct_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="acct_seq", sequenceName="acct_seq", allocationSize=1)
	private Integer id;
	
	@Column(name="BA_BALANCE")
	private Double balance;
	
	@ManyToOne
	@JoinColumn(name="bu_id")
	private BankUser bankUser;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public BankAccount(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	

	public BankUser getBankUser() {
		return bankUser;
	}

	public void setBankUser(BankUser bankUser) {
		this.bankUser = bankUser;
	}

	@Override
	public String toString() {
		return this.id + " " + this.balance;
	}
	
}
