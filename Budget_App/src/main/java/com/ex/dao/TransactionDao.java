package com.ex.dao;

import java.io.Serializable;
import java.util.List;

import com.ex.bgt.domain.BgtTransaction;

public interface TransactionDao {
	
	public BgtTransaction getTransactionById(int id);

	public List<BgtTransaction> getAllTransactions();

	void deleteTransaction(BgtTransaction transaction);

	Serializable saveTransaction(BgtTransaction transaction);
	
	public BgtTransaction getTransactionByName(String name);
	
}
