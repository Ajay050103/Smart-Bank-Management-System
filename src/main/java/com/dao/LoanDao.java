package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.model.LoanApplication;

@Repository
public class LoanDao {

	private SessionFactory sessionFactory;

	public LoanDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(LoanApplication loan) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(loan);
	}

	public void update(LoanApplication loan) {
		Session session = sessionFactory.getCurrentSession();
		session.merge(loan);
	}

	public LoanApplication findById(long loanId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(LoanApplication.class, loanId);
	}

	public List<LoanApplication> findByAccountNumber(String accountNumber) {
		Session session = sessionFactory.getCurrentSession();
		return session
				.createQuery("from LoanApplication where accountNumber = :accountNumber order by appliedDate desc",
						LoanApplication.class)
				.setParameter("accountNumber", accountNumber)
				.getResultList();
	}

	public List<LoanApplication> findAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from LoanApplication order by appliedDate desc", LoanApplication.class)
				.getResultList();
	}

	public boolean hasPendingLoan(String accountNumber) {
		Session session = sessionFactory.getCurrentSession();
		Long count = session.createQuery(
				"select count(l) from LoanApplication l where accountNumber = :accountNumber and status = 'PENDING'",
				Long.class)
				.setParameter("accountNumber", accountNumber)
				.uniqueResult();
		return count != null && count > 0;
	}
}
