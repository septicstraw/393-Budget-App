package com.ex.impl;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Transaction;

import com.ex.bgt.MainScene;
import com.ex.bgt.domain.BgtTransaction;
import com.ex.dao.TransactionDao;
import com.ex.dao.util.ConnectionUtil;

public class TransactionDaoImpl implements TransactionDao {

	public BgtTransaction getTransactionById(int id) {
		Session session = ConnectionUtil.getSession();
		BgtTransaction cat = (BgtTransaction) session.load(BgtTransaction.class, id);
		session.close();

		return cat;
	}
	
	public BgtTransaction getTransactionByName(String name) {
		Session session = ConnectionUtil.getSession();
		Criteria c = session.createCriteria(BgtTransaction.class);
		c.add(Restrictions.eq("name", name));
		BgtTransaction cat = (BgtTransaction) c.uniqueResult();

		return cat;
	}

	public List<BgtTransaction> getAllTransactions() {
		Session session = ConnectionUtil.getSession();
		List<BgtTransaction> cats = session.createCriteria(BgtTransaction.class).list();
		session.close();

		return cats;
	}

	public Serializable saveTransaction(BgtTransaction bgtTx) {
		Session session = ConnectionUtil.getSession();
		Transaction tx = null;
		Serializable s = null;
		try {
			tx = session.beginTransaction();
			s = session.save(bgtTx);
			System.out.println(bgtTx);
			tx.commit();
			return s;
		} catch (Exception ex) {
			if (tx != null) {
				Logger.getLogger(TransactionDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
				tx.rollback();
			}
			return null;
		} finally {
			session.close();
		}
	}

	public void deleteTransaction(BgtTransaction bgtTx) {
		Session session = ConnectionUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.delete(bgtTx);
			System.out.println(bgtTx);
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
