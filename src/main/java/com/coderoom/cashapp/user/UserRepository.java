package com.coderoom.cashapp.user;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserAccount , Long> {
    Optional<UserAccount> findByUserName(String name);
}
