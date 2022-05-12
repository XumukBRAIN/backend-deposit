package com.andersenlab.depositservice.service;

import com.andersenlab.depositservice.domain.dto.ResponseCompletedDepositsDto;

import java.util.Collection;

public interface DepositsService {

    Collection <ResponseCompletedDepositsDto> getDeposits (String clientId);

}
