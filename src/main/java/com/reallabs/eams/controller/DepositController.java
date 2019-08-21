package com.reallabs.eams.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.reallabs.eams.model.Account;
import com.reallabs.eams.model.Deposit;
import com.reallabs.eams.service.AccountService;
import com.reallabs.eams.service.DepositService;

@RestController
public class DepositController {

	@Autowired
	private DepositService depositService;
	@Autowired
	private AccountService accountService;

	@GetMapping("Deposits")
	public List<Deposit> getAllDeposits() {
		return depositService.getAllDeposits();
	}

	@GetMapping("Accounts/{accountId}/Deposits")
	public List<Deposit> getAllDepositsByAccount(@PathVariable("accountId") String accountId) {
		Account account = accountService.getAccount(accountId).get();
		return depositService.getAllDepositsByAccountId(account);
	}

	@GetMapping("Deposits/{depositId}")
	public Optional<Deposit> getDeposit(@PathVariable("depositId") String depositId) {
		return depositService.getDeposit(depositId);
	}

	@PostMapping("Accounts/{accountId}/Deposits")
	public void addDeposit(@PathVariable("accountId") String accountId, @RequestBody Deposit deposit) {
		Account account = accountService.getAccount(accountId).get();
		deposit.setAccount(account);
		depositService.saveDeposit(deposit);

	}

	@PutMapping("Accounts/{accountId}/Deposits/{depositId}")
	public void updateDeposit(@RequestBody Deposit deposit, @PathVariable("depositId") String depositId,
			@PathVariable("accountId") String accountId) {
		Account account = accountService.getAccount(accountId).get();
		deposit.setAccount(account);

		depositService.updateDeposit(depositId, deposit);
	}

	@DeleteMapping("Accounts/{accountId}/Deposits/{depositId}")
	public ResponseEntity<?> deleteDeposit(@PathVariable("depositId") String depositId,
			@PathVariable("accountId") String accountId) {
		depositService.deleteAccount(depositId);
		return ResponseEntity.noContent().build();
	}
}
