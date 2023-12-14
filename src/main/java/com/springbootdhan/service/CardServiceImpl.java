package com.springbootdhan.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootdhan.dao.CardDao;
import com.springbootdhan.entity.Card;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	private CardDao cardDao;

	@Override
	public List<Card> getAllCards() {
		List<Card> cards = cardDao.findAll();
		if(cards == null)
			return Collections.emptyList();
		return cards;
	}

	@Override
	public Card getCard(String id) {
		try {
			int dbId = Integer.parseInt(id);
			Card card = cardDao.getReferenceById(dbId);
			return card;
		}catch (NumberFormatException e) {
		}
		return null;
	}

	@Override
	public Card addCard(Card card) {
		return cardDao.save(card);
	}

	@Override
	public Card updateCard(Card card) {
		return cardDao.save(card);
	}

	@Override
	public void deleteCard(Card card) {
		cardDao.delete(card);
	}

	@Override
	public void deleteCard(String id) {
		cardDao.delete(getCard(id));
	}
}