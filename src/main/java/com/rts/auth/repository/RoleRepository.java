package com.rts.auth.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rts.auth.modal.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
	Optional<Role> findByName(String rn);
}