package com.andersenlab.depositservice.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardDTO {

    private String cardId;

    private String cardNumber;

    private String accountId;

    private BigDecimal transactionalLimit;

    private String status;

    private String expirationDate;

    private String holderName;

    private String digitalWallet;

    @JsonProperty("isDefault")
    private boolean isDefault;

    private String cardProductId;

    private String accountNumber;

    private String currencyCode;

    private BigDecimal currentBalance;

    private String paymentSystem;

    private LocalDate dateOfCreation;

}
