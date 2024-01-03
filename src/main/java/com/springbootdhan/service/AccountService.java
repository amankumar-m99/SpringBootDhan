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
	public Account depositInAccount(Account account, float amount);
	public Account depositInAccountById(long id, float amount);
	public Account depositInAccountByNumber(String accountNumber, float amount);
	//patch:withdraw
	public Account withdrawFromAccount(Account account, float amount);
	public Account withdrawFromAccountById(long id, float amount);
	public Account withdrawFromAccountByNumber(String accountNumber, float amount);
	//patch:block
	public Account blockAccount(Account account);
	public Account blockAccountById(long id);
	public Account blockAccountByNumber(String accountNumber);
	//patch:unblock
	public Account unBlockAccount(Account account);
	public Account unBlockAccountById(long id);
	public Account unBlockAccountByNumber(String accountNumber);
	//patch:mark delete
	public Account markAccountAsDeleted(Account account);
	public Account markAccountByIdAsDeleted(long id);
	public Account markAccountByNumberAsDeleted(String accountNumber);
	//patch:undelete
	public Account unMarkAccountAsDeleted(Account account);
	public Account unMarkAccountByIdAsDeleted(long id);
	public Account unMarkAccountByNumberAsDeleted(String accountNumber);
	//delete
	public Account deleteAccountFromDatabase(Account account);
	public Account deleteAccountFromDatabaseById(long id);
	public Account deleteAccountFromDatabaseByNumber(String accountNumber);
}
