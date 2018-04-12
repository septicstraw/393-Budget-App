package com.ex.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ex.bgt.domain.Category;
import com.ex.dao.CategoryDao;
import com.ex.dao.util.ConnectionUtil;

public class CategoryDaoImpl implements CategoryDao {

	public Category getCategoryById(int id) {
		Session session = ConnectionUtil.getSessionFactory().openSession();
		Category cat = (Category) session.load(Category.class, id);
		
		return cat;
	}
	
	public Category getCategoryByName(String name) {
		Session session = ConnectionUtil.getSessionFactory().openSession();
		Criteria c = session.createCriteria(Category.class);
		c.add(Restrictions.eq("name", name));
		Category cat = (Category) c.uniqueResult();

		return cat;
	}

	public List<Category> getAllCategories() {
		Session session = ConnectionUtil.getSessionFactory().openSession();
		List<Category> cats = session.createCriteria(Category.class).list();
		session.close();

		return cats;
	}

	public Serializable saveCategory(Category category) {
		Session session = ConnectionUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Serializable s = null;

		try {
			tx = session.beginTransaction();
			s = session.save(category);
			System.out.println(category);
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
	
	public void updateCategory(Category category) {
		Session session = ConnectionUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.merge(category);
			System.out.println(category);
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
	}

	public void deleteCategory(Category category) {
		Session session = ConnectionUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.delete(category);
			System.out.println(category);
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
