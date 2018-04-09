package com.ex.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ex.bgt.domain.User;
import com.ex.dao.UserDao;
import com.ex.dao.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {
	
	//public UserDaoImpl() {}

	public User getUserById(int id) {
		Session session = ConnectionUtil.getSession();
		User usr = (User) session.load(User.class, id);

		return usr;
	}

	public List<User> getAllUsers() {
		Session session = ConnectionUtil.getSession();
		List<User> users = session.createCriteria(User.class).list();
		session.close();
		return users;
	}

	public User getUserByEmail(String email) {
		Session session = ConnectionUtil.getSession();
		Criteria c = session.createCriteria(User.class);
		c.add(Restrictions.eq("email", email));
		User usr = (User) c.uniqueResult();
		return usr;
	}

	public Serializable saveUser(User usr) {
		Session session = ConnectionUtil.getSession();
		Transaction tx = null;
		Serializable s = null;

		try {
			tx = session.beginTransaction();
			s = session.save(usr);
			System.out.println(usr);
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

}
