package com.ex.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.bgt.domain.Income;
import com.ex.dao.IncomeDao;
import com.ex.dao.util.ConnectionUtil;

public class IncomeDaoImpl implements IncomeDao {

	public Income getIncomeById(int id) {
		Session session = ConnectionUtil.getSession();
		Income inc = (Income) session.load(Income.class, id);

		return inc;
	}

	public Serializable saveIncome(Income inc) {
		Session session = ConnectionUtil.getSession();
		Transaction tx = null;
		Serializable s = null;

		try {
			tx = session.beginTransaction();
			s = session.save(inc);
			System.out.println(inc);
			tx.commit();
			return s;
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			return null;
		} finally {
			session.close();
		}
	}

	public void deleteIncome(Income inc) {
		Session session = ConnectionUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.delete(inc);
			System.out.println(inc);
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
	}
	
}
