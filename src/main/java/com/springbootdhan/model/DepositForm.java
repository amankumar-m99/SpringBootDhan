package com.springbootdhan.model;

public class DepositForm {
	private String accountNumber;
	private String amount;
	public DepositForm() {
		// TODO Auto-generated constructor stub
	}
	public DepositForm(String accountNumber, String amount) {
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
