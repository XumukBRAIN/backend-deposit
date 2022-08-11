package com.andersenlab.depositservice.repositories;

import com.andersenlab.depositservice.models.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CardRepository extends JpaRepository<Card, UUID> {

    @Query(value = "select c.cardNumber, c.cardProduct, c.account, c.transactional_limit, c.status, c.expiration_date, c.holder_name, c.digital_wallet, c.is_default, " +
            "c.account.accountNumber, c.account.currencyCode, c.account.currentBalance " +
            "from Card c where c.account.clientId=:clientId")
    List<Card> findCardsByAccount_ClientId(@Param(value = "clientId") UUID clientId);

}
