package com.andersenlab.depositservice.models.mapStruct;

import com.andersenlab.depositservice.models.dto.CardDTO;
import com.andersenlab.depositservice.models.entity.Card;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMapper {

    @Mapping(target = "cardId", source = "id")
    @Mapping(target = "accountId", source = "card.account.id")
    @Mapping(target = "transactionalLimit", source = "transactionalLimit")
    @Mapping(target = "cardProductId", source = "card.cardProduct.id")
    @Mapping(target = "accountNumber", source = "card.account.accountNumber")
    @Mapping(target = "currencyCode", source = "card.account.currencyCode")
    @Mapping(target = "currentBalance", source = "card.account.currentBalance")
    @Mapping(target = "paymentSystem", source = "card.cardProduct.paymentSystem")
    CardDTO toCardDTO(Card card);

    List<CardDTO> toListCardDTO(List<Card> cardList);

}
