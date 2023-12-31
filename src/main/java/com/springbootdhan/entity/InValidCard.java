package com.springbootdhan.entity;

public class InValidCard {
	private String cardNumber;

	public InValidCard() {
		super();
	}

	public InValidCard(String cardNumber) {
		super();
		this.cardNumber = cardNumber;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
}
