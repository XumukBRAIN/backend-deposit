package com.andersenlab.depositservice.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseEarlyReturnDepositDto {

    private final String agreement_id;
    private final String accountNumber;

}
