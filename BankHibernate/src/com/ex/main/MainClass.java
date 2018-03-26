package com.ex.main;

import java.util.ArrayList;
import java.util.List;

import com.ex.dao.BankDaoImpl;
import com.ex.domain.BankAccount;
import com.ex.domain.BankUser;

public class MainClass {
	public static void main(String[] args) {
		BankDaoImpl dao = new BankDaoImpl();
		
		BankUser bu = dao.getBankUserById(23);
		System.out.println(bu);
		
	}
}
