package com.springbootdhan.model;

public class AccountForm {
	private String accountHolderName;
	private int openingBalance;
	private boolean isCardRequested;
	public AccountForm() {
		super();
	}
	public AccountForm(String accountHolderName, int openingBalance, boolean isCardRequested) {
		super();
		this.accountHolderName = accountHolderName;
		this.openingBalance = openingBalance;
		this.isCardRequested = isCardRequested;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public int getOpeningBalance() {
		return openingBalance;
	}
	public void setOpeningBalance(int openingBalance) {
		this.openingBalance = openingBalance;
	}
	public boolean isCardRequested() {
		return isCardRequested;
	}
	public void setIsCardRequested(boolean isCardRequested) {
		this.isCardRequested = isCardRequested;
	}
}
