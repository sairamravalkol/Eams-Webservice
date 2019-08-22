package com.reallabs.eams.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reallabs.eams.model.Account;
import com.reallabs.eams.model.Deposit;
import com.reallabs.eams.repository.DepositRepository;

@Service
public class DepositServiceImpl implements DepositService {

	@Autowired
	private DepositRepository depositRepository;

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

}
