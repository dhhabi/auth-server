package com.rts.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rts.auth.modal.Account;
import com.rts.auth.repository.AccountRepository;

@Service
public class AccountDetailsService implements UserDetailsService {

	private final AccountRepository accountRepository;
	
	@Autowired
	public AccountDetailsService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return accountRepository.findByUsername(username)
				.map( (Account account) -> new User(account.getUsername(), account.getPassword(), 
						account.isActive(),account.isActive(),account.isActive(),account.isActive(),
						AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER")))
				.orElseThrow(() -> new UsernameNotFoundException("oops! username not found"));
	}

}
