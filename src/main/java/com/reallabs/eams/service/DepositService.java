package com.reallabs.eams.service;

import java.util.List;
import java.util.Optional;

import com.reallabs.eams.model.Deposit;

public interface DepositService {

	List<Deposit> getAllDeposits();

	Optional<Deposit> getDeposit(String depositId);

	void saveDeposit(Deposit deposit);

	void updateDeposit(String depositId, Deposit deposit);

	void deleteAccount(String depositId);

}
