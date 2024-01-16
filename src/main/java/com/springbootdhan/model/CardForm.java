package com.springbootdhan.model;

public class CardForm {
	private String accountNumber;

	public CardForm() {
		super();
	}

	public CardForm(String accountNumber) {
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
