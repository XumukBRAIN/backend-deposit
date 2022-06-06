package com.andersenlab.depositservice.service.impl;

import com.andersenlab.depositservice.domain.dto.ResponseCompletedCardsDto;
import com.andersenlab.depositservice.domain.entity.Card;
import com.andersenlab.depositservice.domain.exeption.InternalServerException;
import com.andersenlab.depositservice.domain.mapper.CardMapper;
import com.andersenlab.depositservice.repository.CardRepository;
import com.andersenlab.depositservice.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    private final CardMapper cardMapper;

    @Override
    public List<ResponseCompletedCardsDto> getListOfDepositCard(String account) {

        Optional<Card> card = cardRepository.findByAccount(account);
        if (card.isPresent()) {

            return (List<ResponseCompletedCardsDto>) cardMapper.cardToResponseCompletedCardsDto(card.get());
        }

        throw new InternalServerException("Card Not Found");
    }
}
