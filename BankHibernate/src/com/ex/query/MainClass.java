package com.ex.query;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ex.dao.util.ConnectionUtil;
import com.ex.domain.BankUser;

public class MainClass {
	public static void main(String[] args) {
		getUsernamesAndPasswords();
	}

	public static void getAllBankUsers() {
		Session session = ConnectionUtil.getSession();

		Query query = session.createQuery("from BankUser");
		List<BankUser> bankUsers = query.list();

		for (BankUser temp : bankUsers) {
			System.out.println(temp);
		}

		session.close();

	}

	public static void getUsernames() {
		Session session = ConnectionUtil.getSession();
		Query query = session.createQuery("select username from BankUser");
		List<String> usernames = query.list();

		System.out.println(usernames);

		session.close();
	}

	public static void getUsernamesAndPasswords() {
		Session session = ConnectionUtil.getSession();
		Query query = session.createQuery("select username, password from BankUser");
		List<Object[]> multipleVars = query.list();
		for (Object[] temp : multipleVars) {
			System.out.println(temp[0] + " --- " + temp[1]);

		}

		session.close();

	}

	public static void getBankUserByUsername(String username) {
		Session session = ConnectionUtil.getSession();

		Query query = session.createQuery("from BankUser where username = :usernameVar");
		query.setString("usernameVar", username);
		@SuppressWarnings("unchecked")
		List<BankUser> bankUsers = query.list();
		System.out.println(bankUsers.size());
		for (BankUser temp : bankUsers) {
			System.out.println(temp);
		}

		session.close();

	}

	public static void updatePasswordByUsername(String username, String password) {
		Session session = ConnectionUtil.getSession();
		Transaction tx = session.beginTransaction();

		String hql = "update BankUser set password=:pwdVar where username=:usrVar";
		Query query = session.createQuery(hql);
		query.setString("usrVar", username);
		query.setString("pwdVar", password);

		int numAffected = query.executeUpdate();

		System.out.println("Num rows affected: " + numAffected);

		tx.commit();
		session.close();

	}

}
