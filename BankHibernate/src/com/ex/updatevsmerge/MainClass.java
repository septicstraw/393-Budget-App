package com.ex.updatevsmerge;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.dao.util.ConnectionUtil;
import com.ex.domain.BankUser;

public class MainClass {
	public static void main(String[] args) {

		/*
		 * Session One
		 */
		Session sessionOne = ConnectionUtil.getSession();
		Transaction tx = sessionOne.beginTransaction();
		
		BankUser user = (BankUser) sessionOne.get(BankUser.class, 23);
		user.setPassword("I forgot my last password");
		
		sessionOne.update(user);
		
		tx.commit();
		sessionOne.close();
		
		user.setPassword("one last time");
		
		
		
		
		/*
		 * Session Two
		 */
		Session sessionTwo = ConnectionUtil.getSession();
		Transaction tx2 = sessionTwo.beginTransaction();
		
		BankUser another = (BankUser)sessionTwo.get(BankUser.class, 23);
		System.out.println(another);
		
		sessionTwo.merge(user);
		
		tx2.commit();
		sessionTwo.close();
		
		System.out.println(another);
		System.out.println(user);
		
		
		
	}
}
