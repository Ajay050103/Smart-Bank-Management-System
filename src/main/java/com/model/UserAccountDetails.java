package com.model;

import java.util.List;
import jakarta.persistence.*;
@Entity
@Table(name="user_account_details")
public class UserAccountDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(unique = true, nullable = false)
	private String accountNumber;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false , unique = true )
	private String email;
	
	@Column(nullable = false, columnDefinition = "DECIMAL(15,2) DEFAULT 0.00")
	private double balance;
	
	@Column(nullable=false ,unique=true)
	private String aadharNumber;

	private String otp;

	private boolean registered;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Transactions> transactions;
//	constructor 
	public UserAccountDetails() {
		
	}
	public UserAccountDetails(String accountNumber, String password, String name, String email, double balance,
		String aadharNumber, String otp, boolean registered, List<Transactions> transactions) {
		super();
		this.accountNumber = accountNumber;
		this.password = password;
		this.name = name;
		this.email = email;
		this.balance = balance;
		this.aadharNumber = aadharNumber;
		this.otp = otp;
		this.registered = registered;
		this.transactions = transactions;
	}
//  getters and setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public boolean isRegistered() {
		return registered;
	}
	public void setRegistered(boolean registered) {
		this.registered = registered;
	}
	public List<Transactions> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transactions> transactions) {
		this.transactions = transactions;
	}
	

	

}