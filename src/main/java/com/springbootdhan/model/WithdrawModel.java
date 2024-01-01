package com.springbootdhan.model;

public class WithdrawModel {
	private String accountNumber;
	private String amount;
	public WithdrawModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WithdrawModel(String accountNumber, String amount) {
		super();
		this.accountNumber = accountNumber;
		this.amount = amount;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
}
