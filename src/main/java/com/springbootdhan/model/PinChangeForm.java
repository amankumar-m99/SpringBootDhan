package com.springbootdhan.model;

public class PinChangeForm {
	private String cardNumber;
	private String newPin;
	public PinChangeForm() {
		super();
	}
	public PinChangeForm(String cardNumber, String newPin) {
		super();
		this.cardNumber = cardNumber;
		this.newPin = newPin;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getNewPin() {
		return newPin;
	}
	public void setNewPin(String pin) {
		this.newPin = pin;
	}
	
}
