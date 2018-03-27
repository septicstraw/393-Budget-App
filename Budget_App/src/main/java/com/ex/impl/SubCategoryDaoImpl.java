package com.ex.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ex.bgt.domain.SubCategory;
import com.ex.dao.SubCategoryDao;
import com.ex.dao.util.ConnectionUtil;

public class SubCategoryDaoImpl implements SubCategoryDao {

	public SubCategory getSubCategoryById(int id) {
		Session session = ConnectionUtil.getSession();
		SubCategory cat = (SubCategory) session.load(SubCategory.class, id);
		session.close();

		return cat;
	}
	
	public SubCategory getSubCategoryByName(String name) {
		Session session = ConnectionUtil.getSession();
		Criteria c = session.createCriteria(SubCategory.class);
		c.add(Restrictions.eq("name", name));
		SubCategory cat = (SubCategory) c.uniqueResult();

		return cat;
	}

	public List<SubCategory> getAllSubCategories() {
		Session session = ConnectionUtil.getSession();
		List<SubCategory> cats = session.createCriteria(SubCategory.class).list();
		session.close();

		return cats;
	}

	public Serializable saveSubCategory(SubCategory subcat) {
		Session session = ConnectionUtil.getSession();
		Transaction tx = null;
		Serializable s = null;

		try {
			tx = session.beginTransaction();
			s = session.save(subcat);
			System.out.println(subcat);
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

	public void deleteSubCategory(SubCategory subcat) {
		Session session = ConnectionUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.delete(subcat);
			System.out.println(subcat);
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
