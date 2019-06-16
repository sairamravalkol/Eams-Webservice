package com.reallabs.eams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reallabs.eams.model.Account;

@Repository
public interface AccountRepository  extends JpaRepository<Account, Long>{

}
