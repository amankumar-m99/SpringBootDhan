package com.springbootdhan.model;

public class DepositModel {
	private String accountNumber;
	private String amount;
	public DepositModel() {
		// TODO Auto-generated constructor stub
	}
	public DepositModel(String accountNumber, String amount) {
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
