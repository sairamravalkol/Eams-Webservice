package com.reallabs.eams.service;

import java.util.List;
import java.util.Optional;

import com.reallabs.eams.model.Account;


public interface AccountService {
	
	public List<Account> getAllAccounts();
	public Optional<Account> getAccount(String accountId);
	public void saveAccount(Account account);
	public void updateAccount(String accountId, Account account);
	public void deleteAccount(String accountId);

}
