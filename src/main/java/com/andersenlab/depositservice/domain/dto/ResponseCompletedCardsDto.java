package com.andersenlab.depositservice.domain.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ResponseCompletedCardsDto {

    private  String cardNumber;
    private  String premiumStatus;
    private  String paymentSystem;
    private  BigDecimal transactionLimit;
    private  String status;
    private  LocalDate expirationDate;
    private  String holderName;
    private  Boolean virtualCard;
    private  BigDecimal cashback;
    private  String coBrand;
    private  String digitalWallet;
    private  String accountNumber;
    private  String current_balance;
    private  String currencyCode;

}
