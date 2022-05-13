package com.andersenlab.depositservice.domain.mapper.impl;

import com.andersenlab.depositservice.domain.dto.RequestPlacingNewDepositDto;
import com.andersenlab.depositservice.domain.dto.ResponseAvailableDepositsDto;
import com.andersenlab.depositservice.domain.dto.ResponseCompletedDepositsDto;
import com.andersenlab.depositservice.domain.entity.Account;
import com.andersenlab.depositservice.domain.entity.Agreement;
import com.andersenlab.depositservice.domain.entity.Product;
import com.andersenlab.depositservice.domain.mapper.DepositMapper;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Component
public class DepositMapperImpl implements DepositMapper {
    @Override
    public Collection<ResponseCompletedDepositsDto> accountToResponseCompletedDepositsDto(Account account) {
        Collection<ResponseCompletedDepositsDto> responses = new ArrayList<>();
        Set<Agreement> agreements = account.getAgreements();
        for (Agreement agreement :
                agreements) {

            responses.add(ResponseCompletedDepositsDto.builder()
                    .isRevocable(agreement.getProduct().isRevocable())
                    .productName(agreement.getProduct().getName())
                    .isCapitalization(agreement.getProduct().isCapitalization())
                    .interestRateEarly(agreement.getProduct().getInterestRateEarly())
                    .schemaName(agreement.getProduct().getSchemaName())
                    .startDate(agreement.getStartDate())
                    .endDate(agreement.getEndDate())
                    .agreement_id(String.valueOf(agreement.getId()))
                    .autoRenewal(agreement.getAutoRenewal())
                    .interestRate(agreement.getInterestRate())
                    .currencyCode(account.getCurrencyCode())
                    .currentBalance(account.getCurrentBalance())
                    .accountNumber(account.getAccountNumber())
                    .build()
            );
        }
        return responses;
    }

    @Override
    public Collection<ResponseAvailableDepositsDto> accountToResponseAvailableDepositsDto(Account account) {
        Collection<ResponseAvailableDepositsDto> responses = new ArrayList<>();
        Set<Agreement> agreements = account.getAgreements();
        for (Agreement agreement :
                agreements) {

            responses.add(ResponseAvailableDepositsDto.builder()
                    .productName(agreement.getProduct().getName())
                    .productId(String.valueOf(agreement.getProduct().getId()))
                    .minInterestRate(agreement.getProduct().getMinInterestRate())
                    .maxInterestRate(agreement.getProduct().getMaxInterestRate())
                    .interestRateEarly(agreement.getProduct().getInterestRateEarly())
                    .currencyCode(agreement.getProduct().getCurrencyCode())
                    .isRevocable(agreement.getProduct().isRevocable())
                    .schemaName(agreement.getProduct().getSchemaName())
                    .isCapitalization(agreement.getProduct().isCapitalization())
                    .minDurationMonths(agreement.getProduct().getMinDurationMonths())
                    .maxDurationMonths(agreement.getProduct().getMaxDurationMonths())
                    .amountMin(agreement.getProduct().getAmountMin())
                    .amountMax(agreement.getProduct().getAmountMax())
                    .build()
            );
        }
        return responses;
    }

    @Override
    public Agreement requestPlacingNewDepositDtoToAgreement(RequestPlacingNewDepositDto requestPlacingNewDepositDto) {


        return Agreement.builder()
                .account(Account.builder().accountNumber(requestPlacingNewDepositDto.getAccountNumber()).build())
                .product(Product.builder().id(UUID.fromString(requestPlacingNewDepositDto.getProductId())).build())
                .interestRate(requestPlacingNewDepositDto.getInterestRate())
                .startDate(new Date())
                .endDate(java.sql.Date.valueOf(LocalDate.now()
                        .plus(Duration.of(requestPlacingNewDepositDto.getDurationMonths().longValue(), ChronoUnit.MONTHS))))
                .initialAmount(requestPlacingNewDepositDto.getInitialAmount())
                .currentBalance(null)
                .isActive(false)
                .build();
    }

}
