package com.springbootdhan.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springbootdhan.util.Formatter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;

@Entity
public class Card {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@OneToOne
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
	@Transient
	private static final int EXPIRY_YEAR_DURATION = 8;
	public Card() {
		super();
	}
	public Card(Account account) {
		super();
		this.account = account;
//		this.account.setCard(this);
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
	@SuppressWarnings("deprecation")
	private int initExpiryMonth() {
		return new Date().getMonth()+1;
	}
	@SuppressWarnings("deprecation")
	private int initExpiryYear() {
		return (new Date().getYear() + 1900) + EXPIRY_YEAR_DURATION;
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
	public boolean getIsBlocked() {
		return isBlocked;
	}
	public void setIsBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
}
