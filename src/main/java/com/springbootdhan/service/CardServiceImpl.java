package com.springbootdhan.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootdhan.dao.CardDao;
import com.springbootdhan.entity.Card;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	private CardDao cardDao;

	@Override
	public List<Card> getAllCards() {
		List<Card> cards = cardDao.findAll();
		if(cards == null)
			return Collections.emptyList();
		Collections.reverse(cards);
		return cards;
	}

	@Override
	public Card getCardById(String id) {
		try {
			Long dbId = Long.parseLong(id);
			Card card = cardDao.getReferenceById(dbId);
			return card;
		}catch (NumberFormatException e) {
		}catch (EntityNotFoundException  e) {
		}
		return null;
	}

	public Card getCardByNumber(String id) {
		try {
			for(Card card:getAllCards()) {
				if(card.getCardNumber().equals(id)) {
					return card;
				}
			}
		}catch (NumberFormatException e) {
		}catch (EntityNotFoundException  e) {
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
	public Card blockCard(String id) {
		for(Card card:getAllCards()) {
			if(card.getCardNumber().equals(id)) {
				card.getInValidAttempts();
				card.setInValidAttempts(card.getInValidAttempts() + 1);
				updateCard(card);
				return card;
			}
		}
		return null;
		
	}

	@Override
	public void deleteCard(Card card) {
		cardDao.delete(card);
	}

	@Override
	public void deleteCard(String id) {
		cardDao.delete(getCardById(id));
	}

	public Card recordInvalidAttemopt(String id) {
		for(Card card:getAllCards()) {
			if(card.getCardNumber().equals(id)) {
				card.getInValidAttempts();
				card.setInValidAttempts(card.getInValidAttempts() + 1);
				updateCard(card);
				return card;
			}
		}
		return null;
	}
}
