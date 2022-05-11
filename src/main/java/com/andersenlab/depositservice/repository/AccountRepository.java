package com.andersenlab.depositservice.repository;

import com.andersenlab.depositservice.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {

}
