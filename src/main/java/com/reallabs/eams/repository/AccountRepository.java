package com.reallabs.eams.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reallabs.eams.model.Account;

@Repository
public interface AccountRepository  extends CrudRepository<Account, Long>{

}
