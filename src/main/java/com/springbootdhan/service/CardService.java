package com.springbootdhan.service;

import java.util.List;

import com.springbootdhan.entity.Card;

public interface CardService {

	public List<Card> getAllCards();
	public Card getCardById(String id);
	public Card getCardByNumber(String id);
	public Card addCard(Card card);
	public Card updateCard(Card card);
	public Card blockCard(String id);
	public void deleteCard(Card card);
	public void deleteCard(String id);
	public Card recordInvalidAttemopt(String id);
}