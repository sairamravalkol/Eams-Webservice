package com.reallabs.eams.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reallabs.eams.model.Account;
import com.reallabs.eams.model.Deposit;
import com.reallabs.eams.model.Loan;
import com.reallabs.eams.repository.DepositRepository;

@Service
public class DepositServiceImpl implements DepositService {

	private static final Double INTEREST_RATE = 2.0;
	private static final Double TIME = 1.0;
	private static final Double BASIC_AMOUNT = 200.0;
	@Autowired
	private DepositRepository depositRepository;
	@Autowired
	private AccountService accountService;
	@Autowired
	private LoanService loanService;

	@Override
	public List<Deposit> getAllDeposits() {
		List<Deposit> deposits = new ArrayList<>();
		depositRepository.findAll().forEach(deposits::add);
		return deposits;
	}

	@Override
	public Optional<Deposit> getDeposit(String depositId) {
		return depositRepository.findById(Long.valueOf(depositId));
	}

	@Override
	public void saveDeposit(Deposit deposit) {
		depositRepository.save(deposit);
	}

	@Override
	public void updateDeposit(String depositId, Deposit deposit) {
		depositRepository.save(deposit);
	}

	@Override
	public void deleteAccount(String depositId) {
		depositRepository.deleteById(Long.valueOf(depositId));

	}

	@Override
	public List<Deposit> getAllDepositsByAccountId(Account account) {
		return depositRepository.findByAccount(account);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Optional<Deposit> getDepositByAccountId(String accountId) {
		Deposit newDeposit = new Deposit();
		Optional<Account> account = accountService.getAccount(accountId);
		if (account.isPresent()) {
			
			Double loanTotal = 0.0;
			Date currentDate = new Date(System.currentTimeMillis());

			List<Loan> allLoansByAccountId = loanService.getAllLoansByAccountId(account.get());
			for (Loan loan : allLoansByAccountId) {
				if ((currentDate.getMonth() -1) == loan.getLastUpdate().getMonth()) {
					loanTotal = loanTotal+loan.getLoanAmt();
				}
				newDeposit.setLoanTotal(loanTotal);
				newDeposit.setBasic(BASIC_AMOUNT);
				newDeposit.setInterestTotal((loanTotal*TIME*INTEREST_RATE)/100);
				newDeposit.setTotal(BASIC_AMOUNT+loanTotal+(loanTotal*TIME*INTEREST_RATE)/100);
			}
			return Optional.of(newDeposit);

		}
		return Optional.of(newDeposit);

	}

}
