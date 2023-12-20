package com.springbootdhan.controller;

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

import com.springbootdhan.entity.Account;
import com.springbootdhan.entity.Card;
import com.springbootdhan.entity.SemiAccount;
import com.springbootdhan.entity.SemiCard;
import com.springbootdhan.service.AccountService;
import com.springbootdhan.service.CardService;

@RestController
public class MainController {
	private static final String origin="http://localhost:4200";

	@Autowired
	private AccountService accountService;

	@Autowired
	private CardService cardService;

	/** Get mappings**/
	
	@CrossOrigin(origins = origin)
	@GetMapping("/home")
	public String home() {
		return "ATM is working";
	}

	@CrossOrigin(origins = origin)
	@GetMapping("/accounts")
	public List<Account> getAllAccounts() {
		return accountService.getAllAccounts();
	}

	@CrossOrigin(origins = origin)
	@GetMapping("/account/{id}")
	public ResponseEntity<Account> getAccount(@PathVariable String id) {
		Account account = accountService.getAccount(id);
		if(account != null)
			return ResponseEntity.ok(account);
		return ResponseEntity.ofNullable(null);
	}

	@CrossOrigin(origins = origin)
	@GetMapping("/cards")
	public ResponseEntity<List<Card>> getAllCards() {
		List<Card> cards = cardService.getAllCards();
		return ResponseEntity.ok(cards);
	}

	@CrossOrigin(origins = origin)
	@GetMapping("/card/{id}")
	public ResponseEntity<Card> getCard(@PathVariable String id) {
		Card card = cardService.getCard(id);
		if(card != null)
			return ResponseEntity.ok(card);
		return ResponseEntity.ofNullable(null);
	}

	/* -- Post Mappings -- */

	@CrossOrigin(origins = origin)
	@PostMapping(path = "/account", consumes = "application/json")
	public Account addAccount(@RequestBody SemiAccount semiAccount) {
		Account account = new Account(semiAccount);
		account = accountService.addAccount(account);
		if(semiAccount.isCardRequested()) {
			Card card = new Card(account);
			cardService.addCard(card);
		}
		return account;
	}

	@CrossOrigin(origins = origin)
	@PostMapping(path = "/card", consumes = "application/json")
	public Card addCard(@RequestBody SemiCard semiCard) {
		Account account = accountService.getAccount(semiCard.getAccountNumber());
		if(account == null)
			return null;
		Card card = new Card(account);
		return cardService.addCard(card);
	}

	/* -- Put Mappings -- */

	@CrossOrigin(origins = origin)
	@PutMapping("/account")
	public Account updateAccount(@RequestBody Account account) {
//		addressService.updateAddress(person.getAddress());
//		return this.personService.updatePerson(person);
		return null;
	}

	@CrossOrigin(origins = origin)
	@PutMapping("/card")
	public Card updateCard(@RequestBody Card card) {
//		addressService.updateAddress(person.getAddress());
//		return this.personService.updatePerson(person);
		return null;
	}

	/* -- Delete Mappings -- */

	@CrossOrigin(origins = origin)
	@DeleteMapping("/account/{id}")
	public ResponseEntity<HttpStatus> deleteAccountById(@PathVariable String id) {
		try {
//			Person person = personService.getPerson(Integer.parseInt(id));
//			this.addressService.deleteAddress(person.getAddress());
//			this.personService.deletePerson(person);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@CrossOrigin(origins = origin)
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
}
