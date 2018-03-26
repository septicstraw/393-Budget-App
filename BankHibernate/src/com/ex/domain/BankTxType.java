package com.ex.domain;

public class BankTxType {
	
	private Integer id;
	private String type;
	
	public BankTxType(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "BankTxType [id=" + id + ", type=" + type + "]";
	}
	
}
