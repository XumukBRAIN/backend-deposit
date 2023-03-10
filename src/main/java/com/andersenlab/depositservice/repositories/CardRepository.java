package com.andersenlab.depositservice.repositories;

import com.andersenlab.depositservice.models.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CardRepository extends JpaRepository<Card, UUID> {

    List<Card> findByAccountClientIdAndAccountItActiveTrue(UUID clientId);

    Card findCardByIdAndAccountItActiveTrue(UUID cardId);
}
