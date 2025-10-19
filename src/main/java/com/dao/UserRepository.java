package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.model.UserAccountDetails;

@Repository
public class UserRepository {
	
	SessionFactory sessionFactory;
	
	public UserRepository(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	

	public  UserAccountDetails getUserByAccountNumber(String accountNumber) {
		Session session = sessionFactory.getCurrentSession();
		Query<UserAccountDetails> query = session.createQuery("from UserAccountDetails where accountNumber = :accountNumber",UserAccountDetails.class);
		query.setParameter("accountNumber", accountNumber);
		return query.uniqueResult();
	}


	public void updateRegistration(String accountNumber) {
		Session session = sessionFactory.getCurrentSession();
		session.createMutationQuery("update UserAccountDetails set registered = :registered where accountNumber = :accountNumber")
		.setParameter("registered", true)
		.setParameter("accountNumber", accountNumber)
		.executeUpdate();
		
	}


	public void updatePassword(String accountNumber, String password) {
		Session session = sessionFactory.getCurrentSession();
		session.createMutationQuery("update UserAccountDetails set password = :password where accountNumber = :accountNumber")
		.setParameter("password", password)
		.setParameter("accountNumber", accountNumber)
		.executeUpdate();
		
	}
}