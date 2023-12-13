package com.springbootdhan.service;

import java.util.List;

import com.springbootdhan.entity.Account;

public interface AccountService {

	public List<Account> getAllAccounts();
	public Account getAccount(String id);
	public Account addAccount(Account account);
	public Account updateAccount(Account account);
	public void deleteAccount(Account account);
	public void deleteAccount(String id);
}
