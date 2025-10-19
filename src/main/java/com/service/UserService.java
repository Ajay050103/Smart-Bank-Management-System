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
public class UserService {
	@Autowired
	UserRepository userRepository; 
	@Autowired
	UserAccountDetailsDao userAccountDetailsDao;
//register user
	public boolean getUserByAccountNumber(String accountNumber, String password) {
		UserAccountDetails userDetails = userRepository.getUserByAccountNumber(accountNumber);
		if(userDetails== null) {
			return false;	
		}
		else {
			boolean check = userDetails.getPassword().equals(password);
			if(check) {
				userRepository.updateRegistration(accountNumber);
			}
			return check;
			
		}
	}
//update password
	public boolean changePassword(String newPassword, String confirmPassword, String accountNumber) {
		if (newPassword ==null || confirmPassword==null ) {
			return false;
		}
		else {
			if(newPassword.equals(confirmPassword)) {
			userRepository.updatePassword (accountNumber,newPassword);
			return true;
			}
			else{
				return false;
			}
		}
	}
//	login check
	public String loginCheck(String accountNumber, String password) {
		UserAccountDetails userDetails = userRepository.getUserByAccountNumber(accountNumber);
		if (userDetails==null) {
			return "loginpage";
		}
		else {
			if(userDetails.getPassword().equals(password) && userDetails.isRegistered()) {
				return "useraccount";
			}
			else if(userDetails.getPassword().equals(password)== false) {
				return"loginpage";
			}
			else {
				return "userregister";
			}
		}
	}
//	send money by user to account number
	public boolean userAmountTransfer(String senderAcNo, double amount, String receiverAcNo) {
		UserAccountDetails sender = userRepository.getUserByAccountNumber(senderAcNo);
		if (sender==null) {
			return false;
		}
		else {
			if(sender.getBalance()>=amount) {
//	credit to receiver account
				UserAccountDetails receiver = userRepository.getUserByAccountNumber(receiverAcNo);
				double balance = receiver.getBalance();
				receiver.setBalance(balance+amount);
				List<Transactions>transReceiverList = new ArrayList<>();
				Transactions transaction =new Transactions();
				transaction.setAccountNumber(receiverAcNo);
				transaction.setAmmount(amount);
				transaction.setDescription("Recived from Account");
				transaction.setUser(receiver);
				transaction.setType("CREDIT");
				transaction.setBalance(balance+amount);
				transReceiverList.add(transaction);
				receiver.setTransactions(transReceiverList);
				userAccountDetailsDao.saveUser(receiver);
//	debit from sender account	
				double balance2 = sender.getBalance();
				sender.setBalance(balance2-amount);
				List<Transactions>transSenderList = new ArrayList<>();
				Transactions trans=new Transactions();
				trans.setAccountNumber(senderAcNo);
				trans.setAmmount(amount);
				trans.setDescription("Transfer To Account");
				trans.setUser(sender);
				trans.setType("DEBIT");
				trans.setBalance(balance2-amount);
				transSenderList.add(trans);
				sender.setTransactions(transSenderList);
				userAccountDetailsDao.saveUser(sender);
				return true;
			}
			else {
				return false;
			}
		}
	}
	
//	check user balance
	public double getBalance(String accountNumber) {
		UserAccountDetails user = userRepository.getUserByAccountNumber(accountNumber);
		return user.getBalance();
	}
	
//transaction	History
	public List<Transactions> getHistory(String accountNuumber) {
		UserAccountDetails user = userRepository.getUserByAccountNumber(accountNuumber);
		List<Transactions> transactions = user.getTransactions();
		return transactions;
	}	
	

	
	
}
