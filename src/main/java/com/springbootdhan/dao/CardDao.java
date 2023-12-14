package com.springbootdhan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootdhan.entity.Card;

public interface CardDao extends JpaRepository<Card, Long>{}