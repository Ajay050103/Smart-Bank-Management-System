package com.model;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="transaction")
public class Transactions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long transId;
	
	@Column(nullable = false)
	private String accountNumber;

	@Column(nullable = false)
	private String type;
	
	@Column(nullable = false )
	private double ammount;
	
	private String description;
	
	@CreationTimestamp
	private Timestamp timeStamp;
	@Column(nullable = false)
	private double balance;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserAccountDetails user;
	
	public Transactions() {
		
	}

	public Transactions(String accountNumber, String type, double ammount, String description, Timestamp timeStamp,
			double balance, UserAccountDetails user) {
		super();
		this.accountNumber = accountNumber;
		this.type = type;
		this.ammount = ammount;
		this.description = description;
		this.timeStamp = timeStamp;
		this.balance = balance;
		this.user = user;
	}

	public long getTransId() {
		return transId;
	}

	public void setTransId(long transId) {
		this.transId = transId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmmount() {
		return ammount;
	}

	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public UserAccountDetails getUser() {
		return user;
	}

	public void setUser(UserAccountDetails user) {
		this.user = user;
	}
	
	
}
