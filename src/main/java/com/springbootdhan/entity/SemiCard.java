package com.springbootdhan.entity;

public class SemiCard {
	private String accountNumber;

	public SemiCard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SemiCard(String accountNumber) {
		super();
		this.accountNumber = accountNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
}
