package com.springbootdhan.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Card {
	@Id
	private long id;
	@OneToOne
	private Account account;
	private String cardNumber;
	private String pin;
	private String cvv;
	private int expiryMonth;
	private int expiryYear;
	private int inValidAttempts;
	private boolean isBlocked;
	private boolean isActive;
	private boolean isDeleted;
	public Card(Account account) {
		super();
		this.account = account;
		this.account.setCard(this);
		cardNumber = initCardNumber();
		pin = initPin();
		cvv = initCvv();
		expiryMonth = initExpiryMonth();
		expiryYear = initExpiryYear();
		inValidAttempts = 0;
		isBlocked = false;
		isActive = true;
		isDeleted = false;
	}
	private String initCardNumber() {
		
		return null;
	}
	private String initPin() {
		return "1234";
	}
	private String initCvv() {
		return "256";
	}
	private int initExpiryMonth() {
		return new Date().getMonth();
	}
	private int initExpiryYear() {
		return new Date().getYear() + 8;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public int getInValidAttempts() {
		return inValidAttempts;
	}
	public void setInValidAttempts(int inValidAttempts) {
		this.inValidAttempts = inValidAttempts;
	}
	public boolean isBlocked() {
		return isBlocked;
	}
	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public long getId() {
		return id;
	}
	public Account getAccount() {
		return account;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public String getCvv() {
		return cvv;
	}
	public int getExpiryMonth() {
		return expiryMonth;
	}
	public int getExpiryYear() {
		return expiryYear;
	}
}
