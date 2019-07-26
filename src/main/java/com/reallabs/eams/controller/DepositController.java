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

import com.reallabs.eams.model.Deposit;
import com.reallabs.eams.service.DepositService;

@RestController
public class DepositController {
	
	@Autowired
	private DepositService depositService;
	
	@GetMapping("Deposits")
	public List<Deposit> getAllDeposits() {
		return depositService.getAllDeposits();		
	}
 
	@GetMapping(path="Deposits/{depositId}", produces = "application/json")	
	public Optional<Deposit> getDeposit(@PathVariable("depositId") String depositId) {
		return depositService.getDeposit(depositId);
		
	}
	
	@PostMapping("Deposits")
	public void addDeposit(@RequestBody Deposit deposit) {
		depositService.saveDeposit(deposit);
	}
	
	@PutMapping("Deposits/{depositId}")
	public void updateDeposit(@RequestBody Deposit deposit,@PathVariable("depositId") String depositId) {
		depositService.updateDeposit(depositId,deposit);
	}
	
	@DeleteMapping("Deposits/{depositId}")
	public void deleteDeposit(@PathVariable("depositId") String depositId) {
		depositService.deleteAccount(depositId);
	}
}
