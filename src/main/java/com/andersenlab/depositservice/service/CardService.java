package com.andersenlab.depositservice.service;

import com.andersenlab.depositservice.domain.dto.ResponseCompletedCardsDto;

import java.util.List;

public interface CardService {
    List<ResponseCompletedCardsDto> getListOfDepositCard(String clientId);
}
