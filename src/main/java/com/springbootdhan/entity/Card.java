package com.springbootdhan.entity;

import java.util.Date;

import com.springbootdhan.util.Formatter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Card {
	@Id
	private long id;
	@OneToOne(cascade = CascadeType.ALL)
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
	public Card() {
		super();
	}
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
		Date date = new Date();
		String year = Formatter.formatYear(date.getYear());
		String month = Formatter.formatTwo(date.getMonth());
		String day = Formatter.formatTwo(date.getDay());
		String hour = Formatter.formatTwo(date.getHours());
		String min = Formatter.formatTwo(date.getMinutes());
		String sec = Formatter.formatTwo(date.getSeconds());
		return String.format("99%s%s%s%s%s%s", year, month, day, hour, min, sec);
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
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
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public int getExpiryMonth() {
		return expiryMonth;
	}
	public void setExpiryMonth(int expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	public int getExpiryYear() {
		return expiryYear;
	}
	public void setExpiryYear(int expiryYear) {
		this.expiryYear = expiryYear;
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
}
