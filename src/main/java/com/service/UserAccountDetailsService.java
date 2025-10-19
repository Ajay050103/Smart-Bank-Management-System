package com.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dao.UserAccountDetailsDao;
import com.dao.UserRepository;
import com.model.Transactions;
import com.model.UserAccountDetails;
@Service
@Transactional
public class UserAccountDetailsService {
	@Autowired
	UserAccountDetailsDao userAccountDetailsDao;
	@Autowired
	UserRepository userRepository;
	
	public  void saveNewUser(UserAccountDetails userAccountDetails) {
		userAccountDetailsDao.saveUser(userAccountDetails);
	}
	
//	credit
	public boolean creditByAdmin(String accountNumber, long amount, String description) {
		UserAccountDetails user = userRepository.getUserByAccountNumber(accountNumber);
		if (user == null) {
		return false ;
		}
		else{
			double balance = user.getBalance();
		user.setBalance(balance+ amount);
		List<Transactions> transList = new ArrayList<Transactions>();
		Transactions transaction = new Transactions();
		transaction.setAccountNumber(accountNumber);
		transaction.setAmmount(amount);
		transaction.setDescription(description);
		transaction.setType("CREDIT");
		transaction.setBalance(balance+amount);
		transaction.setUser(user);
//		add transaction to list
		transList.add(transaction);
		user.setTransactions(transList);
		userAccountDetailsDao.saveUser(user);
		return true; 
		}	
	}
//debit
	public boolean debititByAdmin(String accountNumber, long amount, String description) {
		UserAccountDetails user = userRepository.getUserByAccountNumber(accountNumber);
		if (user == null) {
		return false ;
		}
		else{
			if (user.getBalance()>=amount) {
				double balance = user.getBalance();
				user.setBalance(balance-amount);
				List<Transactions> transList = new ArrayList<Transactions>();
				Transactions transaction = new Transactions();
				transaction.setAccountNumber(accountNumber);
				transaction.setAmmount(amount);
				transaction.setDescription(description);
				transaction.setType("DEBIT");
				transaction.setUser(user);
				transaction.setBalance(balance-amount);
//				add transaction to list
				transList.add(transaction);
				user.setTransactions(transList);
				userAccountDetailsDao.saveUser(user);	
				return true; 
				}
			else {
				return false;
			}	
			}
		
	}
//All	a/c History 

	public List<Transactions> getAllTransactionsbyAdmin() {	 
		return userAccountDetailsDao.getAllTransactionsbyAdmin();
	}
//statement
	public List<Transactions> getUserStatement(String accountNumber) {
		UserAccountDetails user = userRepository.getUserByAccountNumber(accountNumber);
		return user.getTransactions();
	}

}
