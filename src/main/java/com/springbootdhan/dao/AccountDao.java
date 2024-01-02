package com.springbootdhan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootdhan.entity.Account;

public interface AccountDao extends JpaRepository<Account, Long>{}