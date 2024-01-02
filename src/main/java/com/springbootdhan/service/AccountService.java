package com.springbootdhan.service;

import java.util.List;

import com.springbootdhan.entity.Account;

public interface AccountService {

	//get
	public List<Account> getAllAccounts();
	public Account getAccountById(long id);
	public Account getAccountByNumber(String numberStr);
	//post:add
	public Account addAccount(Account account);
	//put
	public Account updateAccount(Account account);
	//patch:deposit
	public Account depositInAccount(Account account);
	public Account depositInAccountById(long id);
	public Account depositInAccountByNumber(String number);
	//patch:block
	public Account blockAccountById(long id);
	public Account blockAccountByNumber(String numberStr);
	//patch:unblock
	public Account unBlockAccountById(long id);
	public Account unBlockAccountByNumber(String numberStr);
	//patch:delete
	public boolean markAccountAsDeleted(Account account);
	public boolean markAccountByIdAsDeleted(long id);
	public boolean markAccountByNumberAsDeleted(String number);
	//delete
	public boolean deleteAccountFromDatabase(Account account);
	public boolean deleteAccountFromDatabaseById(long id);
	public boolean deleteAccountFromDatabaseByNumber(String id);
}
