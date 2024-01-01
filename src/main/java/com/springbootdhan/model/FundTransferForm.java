package com.springbootdhan.model;

public class FundTransferForm {
	private String fromAccountNumber;
	private String toAccountNumber;
	private String amount;
	public FundTransferForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FundTransferForm(String fromAccountNumber, String toAccountNumber, String amount) {
		super();
		this.fromAccountNumber = fromAccountNumber;
		this.toAccountNumber = toAccountNumber;
		this.amount = amount;
	}
	public String getFromAccountNumber() {
		return fromAccountNumber;
	}
	public void setFromAccountNumber(String fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}
	public String getToAccountNumber() {
		return toAccountNumber;
	}
	public void setToAccountNumber(String toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
}
