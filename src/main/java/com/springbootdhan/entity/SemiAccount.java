package com.springbootdhan.entity;

public class SemiAccount {
	private String accountHolderName;
	private float openingBalance;
	private boolean isCardRequested;
	public SemiAccount() {
		super();
	}
	public SemiAccount(String accountHolderName, float openingBalance, boolean isCardRequested) {
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
	public float getOpeningBalance() {
		return openingBalance;
	}
	public void setOpeningBalance(float openingBalance) {
		this.openingBalance = openingBalance;
	}
	public boolean isCardRequested() {
		return isCardRequested;
	}
	public void setCardRequested(boolean isCardRequested) {
		this.isCardRequested = isCardRequested;
	}
}
