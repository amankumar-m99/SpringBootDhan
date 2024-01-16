package com.springbootdhan.model;

public class ATMCardDetails {
	private int validityPeriod;
	private boolean immediateActive;
	public ATMCardDetails() {
		super();
	}
	public ATMCardDetails(int validityPeriod, boolean immediateActive) {
		super();
		this.validityPeriod = validityPeriod;
		this.immediateActive = immediateActive;
	}
	public int getValidityPeriod() {
		return validityPeriod;
	}
	public void setValidityPeriod(int validityPeriod) {
		this.validityPeriod = validityPeriod;
	}
	public boolean isImmediateActive() {
		return immediateActive;
	}
	public void setImmediateActive(boolean immediateActive) {
		this.immediateActive = immediateActive;
	}
}
