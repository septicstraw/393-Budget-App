package com.ex.bgt.domain;

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
@Table(name = "income")
public class Income {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(generator="income_id_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="income_id_seq", sequenceName="income_id_seq", allocationSize=1)
	private int id;
	
	@Column(name = "amount")
	private double amount;
	
	@Column(name = "rollover")
	private double rollover;
	
	@Column(name = "payeriod")
	private int payPeriod; //Number of days of pay period
	
	@ManyToOne
	@JoinColumn(name = "userid")
	private User user;
	
	public Income() {
		super();
	}
	
	public Income(double amount, double rollover, int payPeriod) {
		this.amount = amount;
		this.rollover = rollover;
		this.payPeriod = payPeriod;
	}
	public Income(int id, double amount, double rollover, int payPeriod) {
		this.id = id;
		this.amount = amount;
		this.rollover = rollover;
		this.payPeriod = payPeriod;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getRollover() {
		return rollover;
	}
	public void setRollover(double rollover) {
		this.rollover = rollover;
	}
	public int getPayPeriod() {
		return payPeriod;
	}
	public void setPayPeriod(int payPeriod) {
		this.payPeriod = payPeriod;
	}
	
	

}
