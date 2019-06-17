package com.reallabs.eams.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("Accounts")
	public List<Account> getAllAccounts() {
		return accountService.getAllAccounts();		
	}
 
	@GetMapping("Accounts/{accountId}")
	public Optional<Account> getAccount(@PathVariable("accountId") String accountId) {
		return accountService.getAccount(accountId);
		
	}
	
	@PostMapping("Accounts")
	public void addAccount(@RequestBody Account account) {
		accountService.saveAccount(account);
	}
	
	@PutMapping("Accounts/{accountId}")
	public void updateAccount(@RequestBody Account account,@PathVariable("accountId") String accountId) {
		accountService.updateAccount(accountId,account);
	}
	
	@DeleteMapping("Accounts/{accountId}")
	public void deleteAccount(@PathVariable("accountId") String accountId) {
		accountService.deleteAccount(accountId);
	}
}
