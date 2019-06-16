package com.reallabs.eams.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reallabs.eams.model.Account;
import com.reallabs.eams.repository.AccountRepository;

@RestController
public class AccountController {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@GetMapping("getAllAccounts")
	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
		
	}
 
}
