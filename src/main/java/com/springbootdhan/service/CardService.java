package com.springbootdhan.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootdhan.entity.Card;

public interface CardService extends JpaRepository<Card, Integer>{}