package com.springbootdhan.service;

import java.util.List;

import com.springbootdhan.entity.Card;

public interface CardService {

	//get
	public List<Card> getAllCards();
	public Card getCardById(long id);
	public Card getCardByNumber(String id);
	//post:
	public Card addCard(Card card);
	//put:
	public Card updateCard(Card card);
	//patch:invalid attempts
	public Card recordInvalidAttemptOnCard(Card card);
	public Card recordInvalidAttemptOnCardById(long id);
	public Card recordInvalidAttemptOnCardByNumber(String cardNumber);
	//patch:block
	public Card blockCard(Card card);
	public Card blockCardById(long id);
	public Card blockCardByNumber(String cardNumber);
	//patch:unblock
	public Card unBlockCard(Card card);
	public Card unBlockCardById(long id);
	public Card unBlockCardByNumber(String cardNumber);
	//patch:mark delete
	public Card markCardAsDeleted(Card card);
	public Card markCardByIdAsDeleted(long id);
	public Card markCardByNumberAsDeleted(String cardNumber);
	//patch:mark undelete
	public Card unMarkCardAsDeleted(Card card);
	public Card unMarkCardByIdAsDeleted(long id);
	public Card unMarkCardByNumberAsDeleted(String cardNumber);
	//patch:delete
	public Card deleteCardFromDatabase(Card card);
	public Card deleteCardFromDatabaseById(long id);
	public Card deleteCardFromDatabaseByNumber(String cardNumber);
}