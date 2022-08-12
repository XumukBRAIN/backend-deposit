package com.andersenlab.depositservice.models.mapStruct;

import com.andersenlab.depositservice.models.dto.CardDTO;
import com.andersenlab.depositservice.models.entity.Account;
import com.andersenlab.depositservice.models.entity.Card;
import com.andersenlab.depositservice.models.entity.CardProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMapper {

    @Mapping(target = "cardId", source = "card.id")
    @Mapping(target = "cardNumber", source = "card.cardNumber")
    @Mapping(target = "transactional_limit", source = "card.transactional_limit")
    @Mapping(target = "status", source = "card.status")
    @Mapping(target = "expiration_date", source = "card.expiration_date")
    @Mapping(target = "holder_name", source = "card.holder_name")
    @Mapping(target = "digital_wallet", source = "card.digital_wallet")
    @Mapping(target = "is_default", source = "card.is_default")
    @Mapping(target = "card_product_id", source = "cardProduct.id")
    @Mapping(target = "accountNumber", source = "account.accountNumber")
    @Mapping(target = "currencyCode", source = "account.currencyCode")
    @Mapping(target = "currentBalance", source = "account.currentBalance")
    CardDTO cardsToCardsDTO(Card card, Account account, CardProduct cardProduct);

    @Mapping(target = "cardId", source = "id")
    @Mapping(target = "cardNumber", source = "cardNumber")
    @Mapping(target = "transactional_limit", source = "transactional_limit")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "expiration_date", source = "expiration_date")
    @Mapping(target = "holder_name", source = "holder_name")
    @Mapping(target = "digital_wallet", source = "digital_wallet")
    @Mapping(target = "is_default", source = "is_default")
    @Mapping(target = "card_product_id", expression = "java(setCardProductId(card))")
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

    default String setAccountCurrentBalance(Card card){
        return String.valueOf(card.getAccount().getCurrentBalance());
    }

}
