package com.rts.auth.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rts.auth.modal.Account;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {
	Optional<Account> findByUsername(String username);
}
