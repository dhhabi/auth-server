package com.rts.auth;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.rts.auth.modal.Account;
import com.rts.auth.modal.Role;
import com.rts.auth.repository.AccountRepository;
import com.rts.auth.service.AccountDetailsService;

@SpringBootApplication
public class AuthServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}
	
	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserDetailsService userDetailsService) throws Exception {
		builder.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
}


@Component
class SampleAccountCLR implements CommandLineRunner {

	private final AccountRepository accountRepository;

	@Autowired
	private AccountDetailsService ads;
	
	@Autowired
	public SampleAccountCLR(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
		
	@Override
	public void run(String... args) throws Exception {
		accountRepository.deleteAll();
		Stream.of("preet,spring","walter,spring")
		.map(x -> x.split(","))
		.forEach(tuple -> accountRepository.save(new Account(tuple[0], new BCryptPasswordEncoder().encode(tuple[1]), true, new HashSet<>(Arrays.asList(new Role("ROLE_USER"), new Role("ROLE_ADMIN"))))));
		
		accountRepository.findByUsername("preet")
		.map(account -> account.toString())
		.ifPresent(a -> System.out.println(a));

		System.out.println(ads.loadUserByUsername("preet").getUsername());

	}

}