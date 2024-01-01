package com.springbootdhan.controller.account;

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
import com.springbootdhan.entity.SemiAccount;
import com.springbootdhan.service.AccountService;
import com.springbootdhan.service.CardService;

@CrossOrigin(origins = StaticData.origins)
@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private CardService cardService;

	@GetMapping("/accounts")
	public List<Account> getAllAccounts() {
		return accountService.getAllAccounts();
	}

	@GetMapping("/account/{id}")
	public ResponseEntity<Account> getAccount(@PathVariable String id) {
		Account account = accountService.getAccount(id);
		if(account != null)
			return ResponseEntity.ok(account);
		return ResponseEntity.ofNullable(null);
	}

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

	@PutMapping("/account")
	public Account updateAccount(@RequestBody Account account) {
		return this.accountService.updateAccount(account);
	}

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
}
