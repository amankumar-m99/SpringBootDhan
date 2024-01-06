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
	public Card getCardById(long id) {
		try {
			Card card = cardDao.getReferenceById(id);
			return card;
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
	public Card recordInvalidAttemptOnCard(Card card) {
		int invalidAttempts = card.getInValidAttempts() + 1;
		card.setInValidAttempts(invalidAttempts);
		if(invalidAttempts == 3)
			card.setIsBlocked(true);
		card = updateCard(card);
		return card;
	}

	@Override
	public Card recordInvalidAttemptOnCardById(long id) {
		Card card = getCardById(id);
		card = recordInvalidAttemptOnCard(card);
		return card;
	}

	@Override
	public Card recordInvalidAttemptOnCardByNumber(String cardNumber) {
		Card card = getCardByNumber(cardNumber);
		card = recordInvalidAttemptOnCard(card);
		return card;
	}

	@Override
	public Card resetInvalidAttemptOnCard(Card card) {
		card.setInValidAttempts(0);
		card.setIsBlocked(false);
		card = updateCard(card);
		return card;
	}

	@Override
	public Card resetInvalidAttemptOnCardById(long id) {
		Card card = getCardById(id);
		card = resetInvalidAttemptOnCard(card);
		return card;
	}

	@Override
	public Card resetInvalidAttemptOnCardByNumber(String cardNumber) {
		Card card = getCardByNumber(cardNumber);
		card = resetInvalidAttemptOnCard(card);
		return card;
	}

	@Override
	public Card changePin(Card card, String newPin) {
		card.setPin(newPin);
		card = updateCard(card);
		return card;
	}

	@Override
	public Card changePinById(long id, String newPin) {
		Card card = getCardById(id);
		card = changePin(card, newPin);
		return card;
	}

	@Override
	public Card changePinByNumber(String cardNumber, String newPin) {
		Card card = getCardByNumber(cardNumber);
		card = changePin(card, newPin);
		return card;
	}

	@Override
	public Card blockCard(Card card) {
		card.setIsBlocked(true);
		card = updateCard(card);
		return card;
		
	}

	@Override
	public Card blockCardById(long id) {
		Card card = getCardById(id);
		card = blockCard(card);
		return card;
	}

	@Override
	public Card blockCardByNumber(String cardNumber) {
		Card card = getCardByNumber(cardNumber);
		card = blockCard(card);
		return card;
	}

	@Override
	public Card unBlockCard(Card card) {
		card.setIsBlocked(false);
		card = updateCard(card);
		return card;
	}

	@Override
	public Card unBlockCardById(long id) {
		Card card = getCardById(id);
		card = unBlockCard(card);
		return card;
	}

	@Override
	public Card unBlockCardByNumber(String cardNumber) {
		Card card = getCardByNumber(cardNumber);
		card = unBlockCard(card);
		return card;
	}

	@Override
	public Card markCardAsDeleted(Card card) {
		card.setIsDeleted(true);
		card = updateCard(card);
		return card;
	}

	@Override
	public Card markCardByIdAsDeleted(long id) {
		Card card = getCardById(id);
		card = markCardAsDeleted(card);
		return card;
	}

	@Override
	public Card markCardByNumberAsDeleted(String cardNumber) {
		Card card = getCardByNumber(cardNumber);
		card = markCardAsDeleted(card);
		return card;
	}

	@Override
	public Card unMarkCardAsDeleted(Card card) {
		card.setIsDeleted(false);
		card = updateCard(card);
		return card;
	}

	@Override
	public Card unMarkCardByIdAsDeleted(long id) {
		Card card = getCardById(id);
		card = unMarkCardAsDeleted(card);
		return card;
	}

	@Override
	public Card unMarkCardByNumberAsDeleted(String cardNumber) {
		Card card = getCardByNumber(cardNumber);
		card = unMarkCardAsDeleted(card);
		return card;
	}

	@Override
	public Card deleteCardFromDatabase(Card card) {
		cardDao.delete(card);
		return card;
	}

	@Override
	public Card deleteCardFromDatabaseById(long id) {
		Card card = getCardById(id);
		card = deleteCardFromDatabase(card);
		return card;
	}

	@Override
	public Card deleteCardFromDatabaseByNumber(String cardNumber) {
		Card card = getCardByNumber(cardNumber);
		card = deleteCardFromDatabase(card);
		return card;
	}
}
