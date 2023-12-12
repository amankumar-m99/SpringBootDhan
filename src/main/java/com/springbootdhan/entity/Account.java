package com.springbootdhan.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Account {
	@Id
	private long id;
	private String accountNumber;
	@OneToOne
	private Card card;
	private String accountHolderName;
	private String ifscCode;
	private float balance;
	private boolean isActive;
	private boolean isDeleted;
	public Account(String accountHolderName, float balance) {
		super();
		this.accountHolderName = accountHolderName;
		this.accountNumber = initAccountNumber();
		this.ifscCode = initIfscCode();
		this.balance = balance;
		this.isActive = true;
		this.isDeleted = false;
	}
	private String initAccountNumber() {
		Date date = new Date();
		String year = formatYear(date.getYear());
		String month = formatMonth(date.getMonth());
		String day = formatDay(date.getDay());
		String hour = formatHour(date.getHours());
		String min = formatMinutes(date.getMinutes());
		String sec = formatSeconds(date.getSeconds());
		return String.format("%s%s%s%s%s%s", year, month, day, hour, min, sec);
	}
	private String formatYear(int year) {
		return String.valueOf(year);
	}
	private String formatMonth(int month) {
		if(month < 10)
			return "0"+ String.valueOf(month);
		return String.valueOf(month);
	}
	private String formatDay(int day) {
		if(day < 10)
			return "0"+String.valueOf(day);
		return String.valueOf(day);
	}
	private String formatHour(int hour) {
		if(hour < 10)
			return "0"+String.valueOf(hour);
		return String.valueOf(hour);
	}
	private String formatMinutes(int minutes) {
		if(minutes < 10)
			return "0"+String.valueOf(minutes);
		return String.valueOf(minutes);
	}
	private String formatSeconds(int seconds) {
		if(seconds < 10)
			return "0"+String.valueOf(seconds);
		return String.valueOf(seconds);
	}
	private String initIfscCode() {
		return "MYBNK000123";
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public long getId() {
		return id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public String getIfscCode() {
		return ifscCode;
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
