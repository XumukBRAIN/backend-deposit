package com.andersenlab.depositservice.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class RequestPlacingNewDepositDto {

    private final String productId;
    private final BigDecimal initialAmount;
    private final String accountNumber;
    private final Boolean autoRenewal;
    private final BigDecimal interestRate;
    private final BigDecimal durationMonths;

}
