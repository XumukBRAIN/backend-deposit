package com.andersenlab.depositservice.domain.dto;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ResponseAvailableDepositsDto {

    private final String productName;
    private final String productId;
    private final BigDecimal minInterestRate;
    private final BigDecimal maxInterestRate;
    private final BigDecimal interestRateEarly;
    private final String currencyCode;
    private final Boolean isRevocable;
    private final String schemaName;
    private final Boolean isCapitalization;
    private final Integer minDurationMonths;
    private final Integer maxDurationMonths;
    private final BigDecimal amountMin;
    private final BigDecimal amountMax;

}
