package com.springbootdhan.controller.account;

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
import com.springbootdhan.model.AccountForm;
import com.springbootdhan.model.AccountNumber;
import com.springbootdhan.model.DepositForm;
import com.springbootdhan.model.FundTransferForm;
import com.springbootdhan.model.WithdrawForm;
import com.springbootdhan.service.AccountService;
import com.springbootdhan.service.CardService;
import com.springbootdhan.util.Validator;

@CrossOrigin(origins = StaticData.origins)
@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private CardService cardService;

	/*===== Get Mappings =====*/

	@GetMapping("/accounts")
	public List<Account> getAllAccounts() {
		return accountService.getAllAccounts();
	}

	@GetMapping("/account/id/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable String id) {
		try {
			long dbId = Long.parseLong(id);
			Account account = accountService.getAccountById(dbId);
			if(account != null)
				return ResponseEntity.ok(account);
		}catch (Exception e) {
		}
		return ResponseEntity.ofNullable(null);
	}

	@GetMapping("/account/number/{accountNumber}")
	public ResponseEntity<Account> getAccountByNumber(@PathVariable String accountNumber) {
		if(!Validator.isStringNumeric(accountNumber))
			return ResponseEntity.ofNullable(null);
		Account account = accountService.getAccountByNumber(accountNumber);
		if(account != null)
			return ResponseEntity.ok(account);
		return ResponseEntity.ofNullable(null);
	}

	/*===== Post Mappings =====*/

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

	/*===== Put Mappings =====*/

	@PutMapping("/account")
	public Account updateAccount(@RequestBody Account account) {
		return this.accountService.updateAccount(account);
	}

	/*===== Patch Mappings =====*/

	//patch : deposit
	@PatchMapping("/account/deposit")
	public Account depositById(@RequestBody DepositForm depositForm) {
		String accountNumber = depositForm.getAccountNumber();
		String amountStr = depositForm.getAmount();
		if(!Validator.isStringNumeric(amountStr))
			return null;
		int amount = Integer.parseInt(amountStr);
		Account account = accountService.depositInAccountByNumber(accountNumber, amount);
		return account;
	}

	//patch : withdraw
	@PatchMapping("/account/withdraw")
	public Account withdraw(@RequestBody WithdrawForm withdrawForm) {
		String accountNumber = withdrawForm.getAccountNumber();
		String amountStr = withdrawForm.getAmount();
		if(!Validator.isStringNumeric(amountStr))
			return null;
		int amount = Integer.parseInt(amountStr);
		Account account = accountService.withdrawFromAccountByNumber(accountNumber, amount);
		return account;
	}

	//patch : fundTransfer
	@PatchMapping("/account/fund-transfer")
	public Account fundTransfer(@RequestBody FundTransferForm fundTransferForm) {
		if(!Validator.isStringNumeric(fundTransferForm.getAmount())) {
			return null;
		}
		float amount = Integer.parseInt(fundTransferForm.getAmount());
		String senderAccountNumber = fundTransferForm.getSenderAccountNumber();
		String receiverAccountNumber = fundTransferForm.getReceiverAccountNumber();
		Account senderAccount = accountService.getAccountByNumber(senderAccountNumber);
		Account receiverAccount = accountService.getAccountByNumber(receiverAccountNumber);
		if(senderAccount.getBalance() < amount)
			return null;
		accountService.withdrawFromAccount(senderAccount, amount);
		accountService.depositInAccount(receiverAccount, amount);
		return senderAccount;
	}

	//patch : block
	@PatchMapping("/account/block")
	public Account blockAccountByID(@RequestBody AccountNumber accountNumber) {
		return accountService.blockAccountByNumber(accountNumber.getAccountNumber());
	}

	//patch : unblock
	@PatchMapping("/account/unblock")
	public Account unBlockAccountByID(@RequestBody AccountNumber accountNumber) {
		return accountService.unBlockAccountByNumber(accountNumber.getAccountNumber());
	}

	//patch: mark delete
	@PatchMapping("/account/mark-delete")
	public Account markDelete(@RequestBody AccountNumber accountNumber) {
		return accountService.markAccountByNumberAsDeleted(accountNumber.getAccountNumber());
	}

	//patch: mark undelete
	@PatchMapping("/account/mark-undelete")
	public Account markUndelete(@RequestBody AccountNumber accountNumber) {
		return accountService.unMarkAccountByNumberAsDeleted(accountNumber.getAccountNumber());
	}

	//delete:by Id

	@DeleteMapping("/account/id/{id}")
	public ResponseEntity<HttpStatus> deleteAccountById(@PathVariable String id) {
		try {
			if(!Validator.isStringNumeric(id))
				return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
			accountService.deleteAccountFromDatabaseById(Long.parseLong(id));
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	//delete:by number

	@DeleteMapping("/account/number/{accountNumber}")
	public ResponseEntity<HttpStatus> deleteAccountByNumber(@PathVariable String accountNumber) {
		try {
			if(!Validator.isStringNumeric(accountNumber))
				return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
			accountService.deleteAccountFromDatabaseByNumber(accountNumber);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
