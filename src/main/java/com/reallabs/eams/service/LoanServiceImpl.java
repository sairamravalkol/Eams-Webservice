package com.reallabs.eams.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reallabs.eams.model.Account;
import com.reallabs.eams.model.Loan;
import com.reallabs.eams.repository.LoanRepository;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	private LoanRepository loanRepository;

	@Override
	public List<Loan> getAllLoans() {
		List<Loan> loans = new ArrayList<>();
		loanRepository.findAll().forEach(loans::add);
		return loans;
	}
	
	public List<Loan> getAllLoansByAccountId(Account account) {
		return loanRepository.findByAccount(account);
		
	}

	@Override
	public Optional<Loan> getLoan(String loanId) {
		 return loanRepository.findById(Long.valueOf(loanId));		 
	}

	@Override
	public void saveLoan(Loan loan) {
		loanRepository.save(loan);
	}
	@Override
	public void updateLoan(String loanId, Loan loan) {
		loanRepository.save(loan);
	}

	@Override
	public void deleteLoan(String loanId) {
		loanRepository.deleteById(Long.valueOf(loanId));

	}

}
