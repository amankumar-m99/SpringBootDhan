package com.springbootdhan.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootdhan.dao.AccountDao;
import com.springbootdhan.entity.Account;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountDao accountDao;

	@Override
	public List<Account> getAllAccounts() {
		List<Account> accounts = accountDao.findAll();
		if(accounts == null)
			Collections.emptyList();
		return accounts;
	}

	@Override
	public Account getAccountById(long id) {
		try {
			Account account = accountDao.getReferenceById(id);
			return account;
		}catch (EntityNotFoundException e) {
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account getAccountByNumber(String numberStr) {
		for(Account account:getAllAccounts()) {
			if(account.getAccountNumber().equals(numberStr)) {
				return account;
			}
		}
		return null;
	}

	@Override
	public Account addAccount(Account account) {
		account = accountDao.save(account);
		return account;
	}

	@Override
	public Account updateAccount(Account account) {
		account = accountDao.save(account);
		return account;
	}

	@Override
	public Account depositInAccount(Account account, float amount) {
		account.setBalance(account.getBalance() + amount);
		account = updateAccount(account);
		return account;
	}

	@Override
	public Account depositInAccountById(long id, float amount) {
		Account account = getAccountById(id);
		account = updateAccount(account);
		return account;
	}

	@Override
	public Account depositInAccountByNumber(String accountNumber, float amount) {
		Account account = getAccountByNumber(accountNumber);
		account = depositInAccount(account, amount);
		return account;
	}

	@Override
	public Account withdrawFromAccount(Account account, float amount) {
		float accountBalance = account.getBalance();
		if(accountBalance < amount)
			return account;
		account.setBalance(accountBalance-amount);
		account = updateAccount(account);
		return account;
	}

	@Override
	public Account withdrawFromAccountById(long id, float amount) {
		Account account = getAccountById(id);
		account = withdrawFromAccount(account, amount);
		return account;
	}

	@Override
	public Account withdrawFromAccountByNumber(String accountNumber, float amount) {
		Account account = getAccountByNumber(accountNumber);
		account = withdrawFromAccount(account, amount);
		return account;
	}

	@Override
	public Account blockAccount(Account account) {
		account.setActive(false);
		account = updateAccount(account);
		return account;
	}

	@Override
	public Account blockAccountById(long id) {
		Account account = getAccountById(id);
		account = blockAccount(account);
		return account;
	}

	@Override
	public Account blockAccountByNumber(String accountNumber) {
		Account account = getAccountByNumber(accountNumber);
		account = blockAccount(account);
		return account;
	}

	@Override
	public Account unBlockAccount(Account account) {
		account.setActive(true);
		account = updateAccount(account);
		return account;
	}

	@Override
	public Account unBlockAccountById(long id) {
		Account account = getAccountById(id);
		account = unBlockAccount(account);
		return account;
	}

	@Override
	public Account unBlockAccountByNumber(String accountNumber) {
		Account account = getAccountByNumber(accountNumber);
		account = unBlockAccount(account);
		return account;
	}

	@Override
	public Account markAccountAsDeleted(Account account) {
		account.setDeleted(true);
		account = updateAccount(account);
		return account;
	}

	@Override
	public Account markAccountByIdAsDeleted(long id) {
		Account account = getAccountById(id);
		account = markAccountAsDeleted(account);
		return account;
	}

	@Override
	public Account markAccountByNumberAsDeleted(String accountNumber) {
		Account account = getAccountByNumber(accountNumber);
		account = markAccountAsDeleted(account);
		return account;
	}

	@Override
	public Account unMarkAccountAsDeleted(Account account) {
		account.setDeleted(false);
		account = updateAccount(account);
		return account;
	}

	@Override
	public Account unMarkAccountByIdAsDeleted(long id) {
		Account account = getAccountById(id);
		account = unMarkAccountAsDeleted(account);
		return account;
	}

	@Override
	public Account unMarkAccountByNumberAsDeleted(String accountNumber) {
		Account account = getAccountByNumber(accountNumber);
		account = unMarkAccountAsDeleted(account);
		return account;
	}

	@Override
	public Account deleteAccountFromDatabase(Account account) {
		accountDao.delete(account);
		return account;
	}

	@Override
	public Account deleteAccountFromDatabaseById(long id) {
		Account account = getAccountById(id);
		account = deleteAccountFromDatabase(account);
		return account;
	}

	@Override
	public Account deleteAccountFromDatabaseByNumber(String accountNumber) {
		Account account = getAccountByNumber(accountNumber);
		account = deleteAccountFromDatabase(account);
		return account;
	}
}
