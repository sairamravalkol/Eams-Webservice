package com.reallabs.eams.service;

import java.util.List;
import java.util.Optional;

import com.reallabs.eams.model.Loan;

public interface LoanService {

	List<Loan> getAllLoans();

	Optional<Loan> getLoan(String loanId);

	void saveLoan(Loan loan);

	void updateLoan(String loanId,Loan loan);

	void deleteLoan(String loanId);

}
