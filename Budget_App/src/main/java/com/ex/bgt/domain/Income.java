package com.ex.bgt.domain;

public class Income {
	
	private int id;
	private double amount;
	private double rollover;
	private int payPeriod; //Number of days of pay period
	
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
