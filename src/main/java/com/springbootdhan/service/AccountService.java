package com.springbootdhan.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootdhan.entity.Account;

public interface AccountService extends JpaRepository<Account, Integer> {}
