package com.springbootdhan.controller.card;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootdhan.data.StaticData;
import com.springbootdhan.entity.Account;
import com.springbootdhan.entity.Card;
import com.springbootdhan.model.CardForm;
import com.springbootdhan.model.CardId;
import com.springbootdhan.model.CardNumber;
import com.springbootdhan.service.AccountService;
import com.springbootdhan.service.CardService;
import com.springbootdhan.util.Validator;

@CrossOrigin(origins = StaticData.origins)
@RestController
public class CardController {

	@Autowired
	private CardService cardService;

	@Autowired
	private AccountService accountService;

	@GetMapping("/cards")
	public ResponseEntity<List<Card>> getAllCards() {
		List<Card> cards = cardService.getAllCards();
		return ResponseEntity.ok(cards);
	}

	@GetMapping("/cardbyid/{id}")
	public ResponseEntity<Card> getCardById(@PathVariable String id) {
		if(!Validator.isStringNumeric(id))
			return ResponseEntity.ofNullable(null);
		Card card = cardService.getCardById(Long.parseLong(id));
		if(card != null)
			return ResponseEntity.ok(card);
		return ResponseEntity.ofNullable(null);
	}

	@GetMapping("/cardbynumber/{cardNumber}")
	public ResponseEntity<Card> getCardByNumber(@PathVariable String cardNumber) {
		if(!Validator.isStringNumeric(cardNumber))
			return ResponseEntity.ofNullable(null);
		Card card = cardService.getCardByNumber(cardNumber);
		if(card != null)
			return ResponseEntity.ok(card);
		return ResponseEntity.ofNullable(null);
	}

	@PostMapping(path = "/card", consumes = "application/json")
	public Card addCard(@RequestBody CardForm cardForm) {
		Account account = accountService.getAccountByNumber(cardForm.getAccountNumber());
		if(account == null)
			return null;
		Card card = new Card(account);
		return cardService.addCard(card);
	}

	@PutMapping("/card")
	public Card updateCard(@RequestBody Card card) {
		return cardService.updateCard(card);
	}

	//patch:invalid attempts
	@PatchMapping(path = "/card/id/invalidattempts", consumes = "application/json")
	public Card recordInValidAttemptsById(@RequestBody CardId cardId) {
		return cardService.recordInvalidAttemptOnCardById(cardId.getId());
	}

	@PatchMapping(path = "/card/number/invalidattempts", consumes = "application/json")
	public Card recordInValidAttemptsByNumber(@RequestBody CardNumber cardNumber) {
		if(!Validator.isStringNumeric(cardNumber.getCardNumber()))
			return null;
		return cardService.recordInvalidAttemptOnCardByNumber(cardNumber.getCardNumber());
	}

	//patch:block
	@PatchMapping(path = "/card/id/block/")
	public Card blockCardById(@RequestBody CardId cardId) {
		return cardService.blockCardById(cardId.getId());
	}

	@PatchMapping(path = "/card/number/block/")
	public Card blockCardByNumber(@RequestBody CardNumber cardNumber) {
		if(!Validator.isStringNumeric(cardNumber.getCardNumber()))
			return null;
		return cardService.blockCardByNumber(cardNumber.getCardNumber());
	}

	//patch:unblock
	@PatchMapping(path = "/card/id/unblock/")
	public Card unBlockCardById(@RequestBody CardId cardId) {
		return cardService.unBlockCardById(cardId.getId());
	}

	@PatchMapping(path = "/card/number/unblock/")
	public Card unBlockCardByNumber(@RequestBody CardNumber cardNumber) {
		if (!Validator.isStringNumeric(cardNumber.getCardNumber()))
			return null;
		return cardService.unBlockCardByNumber(cardNumber.getCardNumber());
	}

	//patch:mark delete
	@PatchMapping(path="/card/id/mark-delete/")
	public Card markCardByIdAsDeleted(@RequestBody CardId cardId) {
		return cardService.markCardByIdAsDeleted(cardId.getId());
	}

	@PatchMapping(path="/card/number/mark-delete/")
	public Card markCardByNumberAsDeleted(@RequestBody CardNumber cardNumber) {
		if(!Validator.isStringNumeric(cardNumber.getCardNumber()))
			return null;
		return cardService.markCardByNumberAsDeleted(cardNumber.getCardNumber());
	}

	//patch:unmark delete
	@PatchMapping(path = "/card/id/unmark-delete/")
	public Card unMarkCardByIdAsDeleted(@RequestBody CardId cardId) {
		return cardService.unMarkCardByIdAsDeleted(cardId.getId());
	}

	@PatchMapping(path = "/card/number/unmark-delete/")
	public Card unMarkCardByNumberAsDeleted(@RequestBody CardNumber cardNumber) {
		if (!Validator.isStringNumeric(cardNumber.getCardNumber()))
			return null;
		return cardService.unMarkCardByNumberAsDeleted(cardNumber.getCardNumber());
	}

	//delete from database
	@DeleteMapping("/card/id/{id}")
	public ResponseEntity<HttpStatus> deleteCardById(@PathVariable String id) {
		if(!Validator.isStringNumeric(id))
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		cardService.deleteCardFromDatabaseById(Long.parseLong(id));
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/card/number/{id}")
	public ResponseEntity<HttpStatus> deleteCardByNumber(@PathVariable String cardNumber) {
		if(!Validator.isStringNumeric(cardNumber))
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		cardService.deleteCardFromDatabaseByNumber(cardNumber);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
