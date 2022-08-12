package com.andersenlab.depositservice.models.mapStruct;

import com.andersenlab.depositservice.models.dto.CardDTO;
import com.andersenlab.depositservice.models.entity.Card;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMapper {

    @Mapping(target = "cardId", source = "id")
    @Mapping(target = "cardNumber", source = "cardNumber")
    @Mapping(target = "accountId", expression = "java(setAccountId(card))")
    @Mapping(target = "transactionalLimit", source = "transactionalLimit")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "expirationDate", source = "expirationDate")
    @Mapping(target = "holderName", source = "holderName")
    @Mapping(target = "digitalWallet", source = "digitalWallet")
    @Mapping(target = "itDefault", source = "itDefault")
    @Mapping(target = "cardProductId", expression = "java(setCardProductId(card))")
    @Mapping(target = "accountNumber", expression = "java(setAccountNumber(card))")
    @Mapping(target = "currencyCode", expression = "java(setAccountCurrencyCode(card))")
    @Mapping(target = "currentBalance", expression = "java(setAccountCurrentBalance(card))")
    CardDTO toCardDTO(Card card);

    List<CardDTO> toListCardDTO(List<Card> cardList);

    default String setCardProductId(Card card){
        return String.valueOf(card.getCardProduct().getId());
    }

    default String setAccountNumber(Card card){
        return card.getAccount().getAccountNumber();
    }

    default String setAccountCurrencyCode(Card card){
        return card.getAccount().getCurrencyCode();
    }

    default BigDecimal setAccountCurrentBalance(Card card){
        return card.getAccount().getCurrentBalance();
    }

    default String setAccountId(Card card){
        return String.valueOf(card.getAccount().getId());
    }

}
