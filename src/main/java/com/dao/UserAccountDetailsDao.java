package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.model.Transactions;
import com.model.UserAccountDetails;

@Repository
public class UserAccountDetailsDao {
	SessionFactory sessionFactory;
	public UserAccountDetailsDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
//	---------------------------*************--------------------------------------
	public void saveUser(UserAccountDetails userAccountDetails) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.persist(userAccountDetails);
	}
// get All Transactions
	public List<Transactions> getAllTransactionsbyAdmin() {
	    Session session = sessionFactory.getCurrentSession();
	    return session.createSelectionQuery("FROM Transactions", Transactions.class)
	                   .getResultList();   
	}


	
	
}
