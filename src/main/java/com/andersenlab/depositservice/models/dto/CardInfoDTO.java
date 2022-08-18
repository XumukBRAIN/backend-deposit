package com.andersenlab.depositservice.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardInfoDTO {

    private String cardNumber;

    private BigDecimal currentBalance;

    private LocalDate expirationDate;

    private String currencyCode;

    private String holderName;

    private String status;

}
