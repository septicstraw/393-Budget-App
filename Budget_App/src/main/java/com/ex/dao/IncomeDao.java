package com.ex.dao;

import java.io.Serializable;

import com.ex.bgt.domain.Income;

public interface IncomeDao {
	
	public Income getIncomeById(int id);
	
	public Serializable saveIncome(Income inc);
	
	void deleteIncome(Income inc);
	
}
