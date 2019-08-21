package com.reallabs.eams.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reallabs.eams.model.Account;
import com.reallabs.eams.model.Deposit;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Long>{
List<Deposit> findByAccount(Account account);
}
