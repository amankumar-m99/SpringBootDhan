package com.springbootdhan.controller.card;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootdhan.data.StaticData;
import com.springbootdhan.entity.Account;
import com.springbootdhan.entity.Card;
import com.springbootdhan.entity.CardGet;
import com.springbootdhan.entity.InValidCard;
import com.springbootdhan.entity.SemiCard;
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

	@GetMapping("/card")
	public ResponseEntity<Card> getCardByNumber(@RequestBody CardGet cardGet) {
		Card card = cardService.getCard(cardGet.getCardNumber());
		if(card != null)
			return ResponseEntity.ok(card);
		return ResponseEntity.ofNullable(null);
	}

	@GetMapping("/card/{id}")
	public ResponseEntity<Card> getCard(@PathVariable String id) {
		Card card = cardService.getCard(id);
		if(card != null)
			return ResponseEntity.ok(card);
		return ResponseEntity.ofNullable(null);
	}

	@PostMapping(path = "/card", consumes = "application/json")
	public Card addCard(@RequestBody SemiCard semiCard) {
		Account account = accountService.getAccount(semiCard.getAccountNumber());
		if(account == null)
			return null;
		Card card = new Card(account);
		return cardService.addCard(card);
	}

	@PutMapping("/card")
	public Card updateCard(@RequestBody Card card) {
//		addressService.updateAddress(person.getAddress());
//		return this.personService.updatePerson(person);
		return null;
	}

	@DeleteMapping("/card/{id}")
	public ResponseEntity<HttpStatus> deleteCardById(@PathVariable String id) {
		try {
//			Person person = personService.getPerson(Integer.parseInt(id));
//			this.addressService.deleteAddress(person.getAddress());
//			this.personService.deletePerson(person);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping(path = "/card/invalid", consumes = "application/json")
	public void recordInValidAttempts(@RequestBody InValidCard inValidCard) {
		cardService.recordInvalidAttemopt(inValidCard.getCardNumber());
	}
}
