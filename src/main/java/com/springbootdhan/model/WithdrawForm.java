package com.springbootdhan.model;

public class WithdrawForm {
	private String accountNumber;
	private String amount;
	public WithdrawForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WithdrawForm(String accountNumber, String amount) {
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
