package com.springbootdhan.entity;

public class CardGet {
	private String cardNumber;

	public CardGet() {
		super();
	}

	public CardGet(String cardNumber) {
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
