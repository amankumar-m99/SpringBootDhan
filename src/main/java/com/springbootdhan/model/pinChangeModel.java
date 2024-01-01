package com.springbootdhan.model;

public class pinChangeModel {
	private String cardNumber;
	private String pin;
	public pinChangeModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public pinChangeModel(String cardNumber, String pin) {
		super();
		this.cardNumber = cardNumber;
		this.pin = pin;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	
}
