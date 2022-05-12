package com.andersenlab.depositservice.service;

import com.andersenlab.depositservice.domain.dto.ResponseAvailableDepositsDto;
import com.andersenlab.depositservice.domain.dto.ResponseCompletedDepositsDto;

import java.util.Collection;

public interface DepositsService {

    Collection <ResponseCompletedDepositsDto> getCompleted (String clientId);

    Collection <ResponseAvailableDepositsDto> getAvailable (String clientId);

}
