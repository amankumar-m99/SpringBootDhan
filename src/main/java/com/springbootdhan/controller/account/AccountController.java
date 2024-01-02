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
import com.springbootdhan.model.AccountForm;
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

	@GetMapping("/account/id/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable String id) {
		Account account = accountService.getAccountById(Long.parseLong(id));
		if(account != null)
			return ResponseEntity.ok(account);
		return ResponseEntity.ofNullable(null);
	}

	@GetMapping("/account/number/{number}")
	public ResponseEntity<Account> getAccountByNumber(@PathVariable String numberStr) {
		Account account = accountService.getAccountByNumber(numberStr);
		if(account != null)
			return ResponseEntity.ok(account);
		return ResponseEntity.ofNullable(null);
	}

	@PostMapping(path = "/account", consumes = "application/json")
	public Account addAccount(@RequestBody AccountForm accountForm) {
		Account account = new Account(accountForm);
		account = accountService.addAccount(account);
		if(accountForm.isCardRequested()) {
			Card card = new Card(account);
			cardService.addCard(card);
		}
		return account;
	}

	@PutMapping("/account")
	public Account updateAccount(@RequestBody Account account) {
		return this.accountService.updateAccount(account);
	}

	@PutMapping("/account/block/{id}")
	public Account blockAccountByID(String id) {
		return accountService.blockAccountById(Long.parseLong(id));
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
