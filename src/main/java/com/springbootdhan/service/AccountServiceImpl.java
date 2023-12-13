package com.springbootdhan.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootdhan.dao.AccountDao;
import com.springbootdhan.entity.Account;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountDao accountDao;

	@Override
	public List<Account> getAllAccounts() {
		List<Account> accounts = accountDao.findAll();
		if(accounts == null)
			return Collections.emptyList();
		return accounts;
	}

	@Override
	public Account getAccount(String id) {
		try {
			int dbId = Integer.parseInt(id);
			Account account = accountDao.getReferenceById(dbId);
			return account;
		}catch (NumberFormatException e) {
		}
		return null;
	}

	@Override
	public Account addAccount(Account account) {
		return accountDao.save(account);
	}

	@Override
	public Account updateAccount(Account account) {
		return accountDao.save(account);
	}

	@Override
	public void deleteAccount(Account account) {
		accountDao.delete(account);
	}

	@Override
	public void deleteAccount(String id) {
		accountDao.delete(getAccount(id));
	}
}
