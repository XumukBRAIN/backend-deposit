package com.andersenlab.depositservice;

import com.andersenlab.depositservice.models.dto.CardDTO;
import com.andersenlab.depositservice.models.dto.CardInfoDTO;
import com.andersenlab.depositservice.models.dto.CardProductDto;
import com.andersenlab.depositservice.models.entity.Account;
import com.andersenlab.depositservice.models.entity.Card;
import com.andersenlab.depositservice.models.entity.CardProduct;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Fixtures {
    public static CardProduct createCardProductTest() {
        return CardProduct.builder()
                .id(1)
                .cardDuration(1)
                .cardName("cardName")
                .cashback(BigDecimal.valueOf(12.3))
                .currencyCode("USD")
                .isActive(true)
                .isVirtual(false)
                .coBrand("VTB")
                .premiumStatus("yes")
                .productPrice(BigDecimal.valueOf(12.3))
                .servicePrice(BigDecimal.valueOf(12.1))
                .paymentSystem("masterCard")
                .build();
    }

    public static CardProductDto createCardProductDtoTest() {
        return CardProductDto.builder()
                .id(1)
                .cardDuration(1)
                .cardName("cardName")
                .cashback(BigDecimal.valueOf(12.3))
                .currencyCode("USD")
                .isActive(true)
                .isVirtual(false)
                .coBrand("VTB")
                .premiumStatus("yes")
                .productPrice(BigDecimal.valueOf(12.3))
                .servicePrice(BigDecimal.valueOf(12.1))
                .paymentSystem("masterCard")
                .build();
    }

    public static List<CardProduct> createListCardProductTest() {
        List<CardProduct> list = new ArrayList<>();
        list.add(CardProduct.builder()
                .id(1)
                .cardDuration(1)
                .cardName("cardName")
                .cashback(BigDecimal.valueOf(12.3))
                .currencyCode("USD")
                .isActive(true)
                .isVirtual(false)
                .coBrand("VTB")
                .premiumStatus("yes")
                .productPrice(BigDecimal.valueOf(12.3))
                .servicePrice(BigDecimal.valueOf(12.1))
                .paymentSystem("masterCard")
                .build());
        return list;
    }

    public static List<CardProductDto> createListCardProductDtoTest() {
        List<CardProductDto> list = new ArrayList<>();
        list.add(CardProductDto.builder()
                .id(1)
                .cardDuration(1)
                .cardName("cardName")
                .cashback(BigDecimal.valueOf(12.3))
                .currencyCode("USD")
                .isActive(true)
                .isVirtual(false)
                .coBrand("VTB")
                .premiumStatus("yes")
                .productPrice(BigDecimal.valueOf(12.3))
                .servicePrice(BigDecimal.valueOf(12.1))
                .paymentSystem("masterCard")
                .build());
        return list;
    }

    public static Card createCardInfoTest() {
        return Card.builder()
                .cardNumber("1234123412341234")
                .expirationDate(LocalDate.now())
                .holderName("Ivan")
                .status("Status")
                .account(Account.builder()
                        .currencyCode("USD")
                        .accountNumber("1111")
                        .currentBalance(BigDecimal.valueOf(12.1))
                        .build())
                .build();
    }


    public static CardInfoDTO createCardInfoDtoTest() {
        return CardInfoDTO.builder()
                .cardNumber("1234123412341234")
                .expirationDate(LocalDate.now())
                .holderName("Ivan")
                .status("Status")
                .currentBalance(BigDecimal.valueOf(12.1))
                .currencyCode("USD")
                .accountNumber("1111")
                .build();
    }

    public static Card createCardTest() {
        return Card.builder()
                .id(UUID.fromString("123e4567-e89b-12d3-a456-426614174000"))
                .cardNumber("1111")
                .account(Account.builder()
                        .id(UUID.fromString("cde898da-372c-4694-ad10-83180fb852a1"))
                        .accountNumber("1111")
                        .currencyCode("USD")
                        .currentBalance(BigDecimal.valueOf(12.1))
                        .build())
                .expirationDate(LocalDate.now())
                .transactionalLimit(BigDecimal.valueOf(12.1))
                .status("Status")
                .holderName("Ivan")
                .digitalWallet("Digital wallet")
                .cardProduct(CardProduct.builder()
                        .id(1)
                        .paymentSystem("MasterCard")
                        .build())
                .build();
    }


    public static CardDTO createCardDtoTest() {
        return CardDTO.builder()
                .cardId(("123e4567-e89b-12d3-a456-426614174000"))
                .cardNumber("1111")
                .accountId("cde898da-372c-4694-ad10-83180fb852a1")
                .accountNumber("1111")
                .currencyCode("USD")
                .currentBalance(BigDecimal.valueOf(12.1))
                .expirationDate(String.valueOf(LocalDate.now()))
                .transactionalLimit(BigDecimal.valueOf(12.1))
                .status("Status")
                .holderName("Ivan")
                .digitalWallet("Digital wallet")
                .cardProductId(String.valueOf(1))
                .paymentSystem("MasterCard")
                .build();
    }

    public static List<Card> createListCardTest() {
        List<Card> list = new ArrayList<>();
        list.add(Card.builder()
                .id(UUID.fromString("123e4567-e89b-12d3-a456-426614174000"))
                .cardNumber("1111")
                .account(Account.builder()
                        .id(UUID.fromString("cde898da-372c-4694-ad10-83180fb852a1"))
                        .accountNumber("1111")
                        .currencyCode("USD")
                        .currentBalance(BigDecimal.valueOf(12.1))
                        .build())
                .expirationDate(LocalDate.now())
                .transactionalLimit(BigDecimal.valueOf(12.1))
                .status("Status")
                .holderName("Ivan")
                .digitalWallet("Digital wallet")
                .cardProduct(CardProduct.builder()
                        .id(1)
                        .paymentSystem("MasterCard")
                        .build())
                .build());
        return list;
    }


    public static List<CardDTO> createListCardDtoTest() {
        List<CardDTO> list = new ArrayList<>();
        list.add(CardDTO.builder()
                .cardId(("123e4567-e89b-12d3-a456-426614174000"))
                .cardNumber("1111")
                .accountId("cde898da-372c-4694-ad10-83180fb852a1")
                .accountNumber("1111")
                .currencyCode("USD")
                .currentBalance(BigDecimal.valueOf(12.1))
                .expirationDate(String.valueOf(LocalDate.now()))
                .transactionalLimit(BigDecimal.valueOf(12.1))
                .status("Status")
                .holderName("Ivan")
                .digitalWallet("Digital wallet")
                .cardProductId(String.valueOf(1))
                .paymentSystem("MasterCard")
                .build());
        return list;
    }

}
