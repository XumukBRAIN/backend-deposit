package com.andersenlab.depositservice.domain.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class ResponseCompletedDepositsDto {

    private final String currencyCode;
    private final Boolean isRevocable;
    private final Date startDate;
    private final Date endDate;
    private final String productName;
    private final String agreementId;
    private final BigDecimal currentBalance;
    private final Boolean autoRenewal;
    private final Boolean isCapitalization;
    private final BigDecimal interestRate;
    private final BigDecimal interestRateEarly;
    private final String schemaName;
    private final String accountNumber;

}
