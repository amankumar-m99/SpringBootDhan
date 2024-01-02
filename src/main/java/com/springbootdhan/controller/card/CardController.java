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
import com.springbootdhan.service.AccountService;
import com.springbootdhan.service.CardService;

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
		Card card = cardService.getCardById(id);
		if(card != null)
			return ResponseEntity.ok(card);
		return ResponseEntity.ofNullable(null);
	}

	@GetMapping("/cardbynumber/{id}")
	public ResponseEntity<Card> getCardByNumber(@PathVariable String id) {
		Card card = cardService.getCardByNumber(id);
		if(card != null)
			return ResponseEntity.ok(card);
		return ResponseEntity.ofNullable(null);
	}

	@PostMapping(path = "/card", consumes = "application/json")
	public Card addCard(@RequestBody CardForm cardForm) {
		Account account = accountService.getAccount(cardForm.getAccountNumber());
		if(account == null)
			return null;
		Card card = new Card(account);
		return cardService.addCard(card);
	}

	@PutMapping("/card")
	public Card updateCard(@RequestBody Card card) {
		return cardService.updateCard(card);
	}

	@PatchMapping(path = "/card/invalidattempts/{id}", consumes = "application/json")
	public Card recordInValidAttempts(@PathVariable String id) {
		return cardService.recordInvalidAttemopt(id);
	}

	@PatchMapping(path = "/card/block/{id}")
	public Card blockCard(@PathVariable String id) {
		return cardService.blockCard(id);
	}

	@DeleteMapping("/card/{id}")
	public ResponseEntity<HttpStatus> deleteCardById(@PathVariable String id) {
		try {
			Long.parseLong(id);
			cardService.deleteCard(id);
		}catch(NumberFormatException nfe) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
