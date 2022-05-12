package com.andersenlab.depositservice.repository;

import com.andersenlab.depositservice.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, String> {

    Optional<Account> findByClientId(UUID clientId);
}
