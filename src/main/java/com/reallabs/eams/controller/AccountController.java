package com.reallabs.eams.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.reallabs.eams.model.Account;
import com.reallabs.eams.service.AccountService;

@RestController
public class AccountController {
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	private AccountService accountService;

	@GetMapping("Accounts")
	public List<Account> getAllAccounts() {
		List<Account> allAccounts = accountService.getAllAccounts();
		logger.info("Account List::", allAccounts);
		return allAccounts;
	}

	@GetMapping("Accounts/{accountId}")
	public  Account getAccount(@PathVariable("accountId") String accountId) {
		return accountService.getAccount(accountId).orElseThrow(()->new ResourceNotFoundException("Id Not Found"));
		
	}

	@PostMapping("Accounts")
	public void addAccount(@RequestBody Account account) {
		accountService.saveAccount(account);
	}

	@PutMapping("Accounts/{accountId}")
	public void updateAccount(@RequestBody Account account, @PathVariable("accountId") String accountId) {
		accountService.updateAccount(accountId, account);
	}

	@DeleteMapping("Accounts/{accountId}")
	public void deleteAccount(@PathVariable("accountId") String accountId) {
		accountService.deleteAccount(accountId);
	}
}
