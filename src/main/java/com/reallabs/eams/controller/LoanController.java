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

import com.reallabs.eams.model.Loan;
import com.reallabs.eams.service.LoanService;

@RestController
public class LoanController {
	
	@Autowired
	private LoanService loanService;
	
	@GetMapping("Loans")
	public List<Loan> getAllLoans() {
		return loanService.getAllLoans();		
	}
 
	@GetMapping(path="Loans/{loanId}", produces = "application/json")	
	public Optional<Loan> getLoan(@PathVariable("loanId") String loanId) {
		return loanService.getLoan(loanId);
		
	}
	
	@PostMapping("Loans")
	public void addLoan(@RequestBody Loan loan) {
		loanService.saveLoan(loan);
	}
	
	@PutMapping("Loans/{loanId}")
	public void updateLoan(@RequestBody Loan loan, @PathVariable("loanId") String loanId) {
		System.out.println("Loan:Object"+loan);
		loanService.updateLoan(loanId,loan);
	}
	
	@DeleteMapping("Loans/{loanId}")
	public void deleteLoan(@PathVariable("loanId") String loanId) {
		loanService.deleteLoan(loanId);
	}
}
