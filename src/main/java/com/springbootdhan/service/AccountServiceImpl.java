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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account updateAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account depositInAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account depositInAccountById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account depositInAccountByNumber(String number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account blockAccountById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account blockAccountByNumber(String numberStr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account unBlockAccountById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account unBlockAccountByNumber(String numberStr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean markAccountAsDeleted(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean markAccountByIdAsDeleted(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean markAccountByNumberAsDeleted(String number) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAccountFromDatabase(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAccountFromDatabaseById(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAccountFromDatabaseByNumber(String id) {
		// TODO Auto-generated method stub
		return false;
	}
}
