package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.LoanDao;
import com.dao.UserAccountDetailsDao;
import com.dao.UserRepository;
import com.model.LoanApplication;
import com.model.Transactions;
import com.model.UserAccountDetails;

@Service
@Transactional
public class LoanService {

	private static final double DEFAULT_ANNUAL_INTEREST_RATE = 10.0;

	@Autowired
	private LoanDao loanDao;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserAccountDetailsDao userAccountDetailsDao;

	public boolean applyForLoan(String accountNumber, double loanAmount, String loanType, int tenureMonths,
			double monthlyIncome, String purpose) {
		if (loanAmount <= 0 || tenureMonths <= 0 || monthlyIncome <= 0) {
			return false;
		}
		UserAccountDetails user = userRepository.getUserByAccountNumber(accountNumber);
		if (user == null || !user.isRegistered()) {
			return false;
		}
		if (loanDao.hasPendingLoan(accountNumber)) {
			return false;
		}

		LoanApplication loan = new LoanApplication();
		loan.setAccountNumber(accountNumber);
		loan.setLoanAmount(loanAmount);
		loan.setLoanType(loanType);
		loan.setTenureMonths(tenureMonths);
		loan.setMonthlyIncome(monthlyIncome);
		loan.setPurpose(purpose);
		loan.setStatus("PENDING");
		loan.setUser(user);
		loanDao.save(loan);
		return true;
	}

	public List<LoanApplication> getLoansByAccount(String accountNumber) {
		return loanDao.findByAccountNumber(accountNumber);
	}

	public List<LoanApplication> getAllLoans() {
		return loanDao.findAll();
	}

	public boolean approveLoan(long loanId, String remarks) {
		LoanApplication loan = loanDao.findById(loanId);
		if (loan == null || !"PENDING".equals(loan.getStatus())) {
			return false;
		}

		UserAccountDetails user = userRepository.getUserByAccountNumber(loan.getAccountNumber());
		if (user == null) {
			return false;
		}

		double emi = calculateEmi(loan.getLoanAmount(), DEFAULT_ANNUAL_INTEREST_RATE, loan.getTenureMonths());
		loan.setStatus("APPROVED");
		loan.setInterestRate(DEFAULT_ANNUAL_INTEREST_RATE);
		loan.setEmiAmount(emi);
		loan.setAdminRemarks(remarks != null && !remarks.isBlank() ? remarks : "Loan approved");

		double balance = user.getBalance();
		user.setBalance(balance + loan.getLoanAmount());

		List<Transactions> transList = new ArrayList<>();
		Transactions transaction = new Transactions();
		transaction.setAccountNumber(loan.getAccountNumber());
		transaction.setAmmount(loan.getLoanAmount());
		transaction.setDescription("Loan Disbursement - Loan ID " + loan.getLoanId());
		transaction.setType("CREDIT");
		transaction.setBalance(balance + loan.getLoanAmount());
		transaction.setUser(user);
		transList.add(transaction);
		user.setTransactions(transList);

		userAccountDetailsDao.saveUser(user);
		loanDao.update(loan);
		return true;
	}

	public boolean rejectLoan(long loanId, String remarks) {
		LoanApplication loan = loanDao.findById(loanId);
		if (loan == null || !"PENDING".equals(loan.getStatus())) {
			return false;
		}
		loan.setStatus("REJECTED");
		loan.setAdminRemarks(remarks != null && !remarks.isBlank() ? remarks : "Loan rejected");
		loanDao.update(loan);
		return true;
	}

	public double calculateEmi(double principal, double annualRatePercent, int months) {
		if (months <= 0) {
			return 0;
		}
		double monthlyRate = annualRatePercent / 12 / 100;
		if (monthlyRate == 0) {
			return Math.round((principal / months) * 100.0) / 100.0;
		}
		double factor = Math.pow(1 + monthlyRate, months);
		double emi = (principal * monthlyRate * factor) / (factor - 1);
		return Math.round(emi * 100.0) / 100.0;
	}
}
