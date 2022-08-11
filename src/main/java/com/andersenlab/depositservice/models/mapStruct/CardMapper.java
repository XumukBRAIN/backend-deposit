package com.andersenlab.depositservice.models.mapStruct;

import com.andersenlab.depositservice.models.dto.CardDTO;
import com.andersenlab.depositservice.models.entity.Account;
import com.andersenlab.depositservice.models.entity.Card;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMapper {

    @Mapping(target = "cardNumber", source = "card.cardNumber")
    @Mapping(target = "cardProduct", source = "card.cardProduct")
    @Mapping(target = "account", source = "card.account")
    @Mapping(target = "transactional_limit", source = "card.transactional_limit")
    @Mapping(target = "status", source = "card.status")
    @Mapping(target = "expiration_date", source = "card.expiration_date")
    @Mapping(target = "holder_name", source = "card.holder_name")
    @Mapping(target = "digital_wallet", source = "card.digital_wallet")
    @Mapping(target = "is_default", source = "card.is_default")
    @Mapping(target = "accountNumber", source = "account.accountNumber")
    @Mapping(target = "currencyCode", source = "account.currencyCode")
    @Mapping(target = "currentBalance", source = "account.currentBalance")
    CardDTO cardsToCardsDTO(Card card, Account account);

    List<CardDTO> toListCardDTO(List<Card> cardList);
}
