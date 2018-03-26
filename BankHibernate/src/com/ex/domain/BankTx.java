package com.ex.domain;

import java.sql.Timestamp;


public class BankTx {
	
	private Integer id;
	private Double amount;
	private Timestamp timestamp;
	//TODO: ba_id
	//TODO: btt_id
	
	public BankTx(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "BankTx [id=" + id + ", amount=" + amount + ", timestamp=" + timestamp + "]";
	}
	
}
