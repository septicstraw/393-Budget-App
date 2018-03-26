package com.ex.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import static org.hibernate.criterion.Restrictions.*;

import com.ex.dao.util.ConnectionUtil;
import com.ex.domain.BankUser;

public class MainClass {
	public static void main(String[] args) {
		
		Session session = ConnectionUtil.getSession();
		
		Criteria criteria = session.createCriteria(BankUser.class);
		
//		criteria.add(ilike("username", "%a%"))
//				.add(isNotNull("password"));
		
		
		criteria.add(or(ilike("username", "%o%"),isNull("password")));
		
		List<BankUser> bankUsers = criteria.list();
		
		for(BankUser temp: bankUsers){
			System.out.println(temp);
		}
		
		System.out.println("size: " + bankUsers.size());
		
		
		session.close();
		
	}
}
