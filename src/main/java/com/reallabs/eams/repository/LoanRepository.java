package com.reallabs.eams.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reallabs.eams.model.Loan;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Long>{

}
