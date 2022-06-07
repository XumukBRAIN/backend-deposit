package com.andersenlab.depositservice.repository;

import com.andersenlab.depositservice.domain.entity.Account;
import com.andersenlab.depositservice.domain.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, String> {

    List<Card> findByAccount(Account account);
}
