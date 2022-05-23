package com.andersenlab.depositservice.service;

import com.andersenlab.depositservice.domain.dto.RequestPlacingNewDepositDto;
import com.andersenlab.depositservice.domain.dto.ResponseAvailableDepositsDto;
import com.andersenlab.depositservice.domain.dto.ResponseCompletedDepositsDto;

import java.util.Collection;

public interface DepositService {

    Collection<ResponseCompletedDepositsDto> getCompleted(String clientId);

    Collection<ResponseAvailableDepositsDto> getAvailable(String clientId);

    Boolean postPlacing(String clientId, RequestPlacingNewDepositDto requestPlacingNewDepositDto);

    String updateEarlyReturnDepositsDto(String clientId);

}
