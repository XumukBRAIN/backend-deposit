package com.andersenlab.depositservice.models.dto;

import lombok.*;

import java.math.BigDecimal;


@ToString
@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardDTO {

    private String cardId;

    private String cardNumber;

    private BigDecimal transactionalLimit;

    private String status;

    private String expirationDate;

    private String holderName;

    private String digitalWallet;

    private boolean isDefault;

    private String cardProductId;

    private String accountNumber;

    private String currencyCode;

    private BigDecimal currentBalance;

}
