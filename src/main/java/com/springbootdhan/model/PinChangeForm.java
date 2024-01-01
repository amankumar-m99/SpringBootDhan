package com.springbootdhan.model;

public class PinChangeForm {
	private String cardNumber;
	private String pin;
	public PinChangeForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PinChangeForm(String cardNumber, String pin) {
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
