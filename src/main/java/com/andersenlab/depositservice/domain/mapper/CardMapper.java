package com.andersenlab.depositservice.domain.mapper;

import com.andersenlab.depositservice.domain.dto.ResponseCompletedCardsDto;
import com.andersenlab.depositservice.domain.entity.Card;

public interface CardMapper {

    ResponseCompletedCardsDto cardToResponseCompletedCardsDto(Card card);

}
