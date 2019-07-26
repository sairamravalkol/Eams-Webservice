package com.reallabs.eams.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reallabs.eams.model.Deposit;

@Repository
public interface DepositRepository extends CrudRepository<Deposit, Long>{

}
