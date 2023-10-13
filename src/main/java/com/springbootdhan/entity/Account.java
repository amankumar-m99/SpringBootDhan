package com.springbootdhan.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {
	@Id
	private long id;
	private String accountNumber;
	private Card card;
	private String accountHolderFName;
	private String accountHolderMName;
	private String accountHolderLName;
	private String ifscCode;
	private float balance;
	private boolean isActive;
	private boolean isDeleted;
	public Account(String accountHolderFName, String accountHolderMName, String accountHolderLName, float balance) {
		super();
		this.accountHolderFName = accountHolderFName;
		this.accountHolderMName = accountHolderMName;
		this.accountHolderLName = accountHolderLName;
		this.accountNumber = initAccountNumber();
		this.ifscCode = initIfscCode();
		this.balance = balance;
		this.isActive = true;
		this.isDeleted = false;
	}
	private String initAccountNumber() {
		// TODO Auto-generated method stub
		return null;
	}
	private String initIfscCode() {
		// TODO Auto-generated method stub
		return null;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public String getAccountHolderFName() {
		return accountHolderFName;
	}
	public void setAccountHolderFName(String accountHolderFName) {
		this.accountHolderFName = accountHolderFName;
	}
	public String getAccountHolderMName() {
		return accountHolderMName;
	}
	public void setAccountHolderMName(String accountHolderMName) {
		this.accountHolderMName = accountHolderMName;
	}
	public String getAccountHolderLName() {
		return accountHolderLName;
	}
	public void setAccountHolderLName(String accountHolderLName) {
		this.accountHolderLName = accountHolderLName;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public long getId() {
		return id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
}
