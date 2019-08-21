package com.reallabs.eams.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reallabs.eams.model.Loan;
import com.reallabs.eams.model.Account;
import java.util.List;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Long>{
List<Loan> findByAccount(Account account);

}
