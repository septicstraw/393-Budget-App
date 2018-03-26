package com.ex.dao;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.dao.util.ConnectionUtil;
import com.ex.domain.BankAccount;
import com.ex.domain.BankUser;

public class BankDaoImpl {
	
	
	public BankUser getBankUserById(Integer id){
		
		Session session = ConnectionUtil.getSession();
			
		BankUser user = (BankUser)session.load(BankUser.class, id);
		//user.setUsername("awgyd");
		//user.getAccounts().size();
		
		
		session.close();
		
		return user;
	}
	
	public Serializable addBankUser(BankUser bu){
		Session session = ConnectionUtil.getSession();
		Transaction tx = null;
		Serializable s = null;
		
		try{
			tx = session.beginTransaction();
			s = session.save(bu);
			tx.commit();
			return s;
		}catch(HibernateException ex){
			if(tx != null){
				tx.rollback();
			}
			return null;
		}finally{
			session.close();
		}
	}
	
	public void addBankAccount(BankAccount ba){
		Session session = ConnectionUtil.getSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			session.save(ba);
			tx.commit();
		}catch(HibernateException ex){
			if(tx != null){
				tx.rollback();
			}
		}finally{
			session.close();
		}
	}
	
}
