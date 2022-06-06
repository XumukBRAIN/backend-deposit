package com.andersenlab.depositservice.domain.mapper.impl;

import com.andersenlab.depositservice.domain.dto.ResponseCompletedCardsDto;
import com.andersenlab.depositservice.domain.entity.Card;
import com.andersenlab.depositservice.domain.mapper.CardMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CardMapperImpl implements CardMapper {
    public ResponseCompletedCardsDto cardToResponseCompletedCardsDto(Card card) {
        return new ResponseCompletedCardsDto().builder()
                .cardNumber(card.getCardNumber())
                .premiumStatus(card.getPremiumStatus())
                .paymentSystem(card.getPaymentSystem())
                .transactionLimit(card.getTransactionLimit())
                .status(card.getStatus())
                .expirationDate(card.getExpirationDate())
                .holderName(card.getHolderName())
                .virtualCard(card.isVirtualCard())
                .cashback(card.getCashback())
                .coBrand(card.getCoBrand())
                .digitalWallet(card.getDigitalWallet())
                .accountNumber(card.getAccount().getAccountNumber())
                .current_balance(String.valueOf(card.getAccount().getCurrentBalance()))
                .currencyCode(card.getAccount().getCurrencyCode())
                .build();
    }


    public List<ResponseCompletedCardsDto> createResponseCompletedCardsDto(List<Card> entities) {
        return entities
                .stream()
                .map(this::cardToResponseCompletedCardsDto)
                .toList();
    }
}
