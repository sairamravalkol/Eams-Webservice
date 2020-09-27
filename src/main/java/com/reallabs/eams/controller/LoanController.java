package com.reallabs.eams.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.reallabs.eams.model.Loan;
import com.reallabs.eams.service.AccountService;
import com.reallabs.eams.service.LoanService;

@RestController
public class LoanController {

	@Autowired
	private LoanService loanService;
	@Autowired
	private AccountService accountService;

	@GetMapping("Loans")
	public List<Loan> getAllLoans() {
		return loanService.getAllLoans();
	}

	@GetMapping("Accounts/{accountId}/Loans")
	public List<Loan> getAllLoansByAccountId(@PathVariable("accountId") String accountId) {
		Optional<Account> account = accountService.getAccount(accountId);
		List<Loan> loans = new ArrayList<>();
		if (account.isPresent()) {
			loanService.getAllLoansByAccountId(account.get()).forEach(loans::add);
		}
		return loans;

	}

	@GetMapping("Accounts/{accountId}/Loans/{loanId}")
	public Optional<Loan> getLoan(@PathVariable("loanId") String loanId) {
		return loanService.getLoan(loanId);

	}

	@PostMapping("Accounts/{accountId}/Loans")
	public ResponseEntity<String> addLoan(@RequestBody Loan loan, @PathVariable("accountId") String accountId) {
		Optional<Account> account = accountService.getAccount(accountId);
		if (account.isPresent()) {
			loan.setAccount(account.get());
		}
		loan.setAccId(account.get().getAccountId());
		loan.setAccountName(account.get().getAccountName());
		loanService.saveLoan(loan);
		return new ResponseEntity<>("Created", HttpStatus.CREATED);
	}

	@PutMapping("Accounts/{accountId}/Loans/{loanId}")
	public ResponseEntity<String> updateLoan(@RequestBody Loan loan, @PathVariable("loanId") String loanId,
			@PathVariable("accountId") String accountId) {
		Optional<Account> account = accountService.getAccount(accountId);
		if (account.isPresent()) {
			loan.setAccount(account.get());			
			loanService.saveLoan(loan);
			return new ResponseEntity<>("Accepted", HttpStatus.ACCEPTED);
		}
		
		return new ResponseEntity<>("Loan Not Found for Id"
				+ ""
				+ "::"+loanId+
				" ", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("Accounts/{accountId}/Loans/{loanId}")
	public ResponseEntity<String> deleteLoan(@PathVariable("loanId") String loanId) {
		Optional<Loan> loan = loanService.getLoan(loanId);
		if (loan.isPresent()) {
			loanService.deleteLoan(loanId);
			return new ResponseEntity<>("Deleted", HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>("Loan Not Found for Id"
					+ ""
					+ "::"+loanId+
					" ", HttpStatus.NOT_FOUND);
		}

	}
}
