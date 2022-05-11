package com.andersenlab.depositservice.repository;

import com.andersenlab.depositservice.domain.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, String> {
}
