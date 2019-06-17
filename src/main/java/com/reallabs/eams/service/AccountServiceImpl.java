package com.reallabs.eams.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reallabs.eams.model.Account;
import com.reallabs.eams.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public List<Account> getAllAccounts() {
		List<Account> accounts = new ArrayList<>();
		accountRepository.findAll().forEach(accounts::add);
		return accounts;
	}

	@Override
	public Optional<Account> getAccount(String accountId) {
		return accountRepository.findById(Long.valueOf(accountId));
	}

	@Override
	public void saveAccount(Account account) {
		accountRepository.save(account);

	}

	@Override
	public void updateAccount(String accountId, Account account) {
		accountRepository.save(account);

	}

	@Override
	public void deleteAccount(String accountId) {
		accountRepository.deleteById(Long.valueOf(accountId));
	}

}
