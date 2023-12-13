package com.springbootdhan.entity;

import java.util.Date;

import com.springbootdhan.util.Formatter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String accountNumber;
	@OneToOne
	private Card card;
	private String accountHolderName;
	private String ifscCode;
	private float balance;
	@Temporal(TemporalType.DATE)
	private Date dateOfOpening;
	private boolean isActive;
	private boolean isDeleted;
	public Account() {
		super();
	}
	public Account(SemiAccount semiAccount) {
		super();
		this.accountHolderName = semiAccount.getAccountHolderName();
		this.accountNumber = initAccountNumber();
		if(semiAccount.isCardRequested())
			this.card = new Card(this);
		this.ifscCode = initIfscCode();
		this.balance = semiAccount.getOpeningBalance();
		this.isActive = true;
		this.isDeleted = false;
	}
	private String initAccountNumber() {
		Date date = new Date();
		String year = Formatter.formatYear(date.getYear());
		String month = Formatter.formatTwo(date.getMonth());
		String day = Formatter.formatTwo(date.getDay());
		String hour = Formatter.formatTwo(date.getHours());
		String min = Formatter.formatTwo(date.getMinutes());
		String sec = Formatter.formatTwo(date.getSeconds());
		return String.format("%s%s%s%s%s%s", year, month, day, hour, min, sec);
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
	public Date getDateOfOpening() {
		return dateOfOpening;
	}
	public void setDateOfOpening(Date dateOfOpening) {
		this.dateOfOpening = dateOfOpening;
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
