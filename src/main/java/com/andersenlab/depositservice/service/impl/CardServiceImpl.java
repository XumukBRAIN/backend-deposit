package com.andersenlab.depositservice.service.impl;

import com.andersenlab.depositservice.domain.dto.ResponseCompletedCardsDto;
import com.andersenlab.depositservice.domain.entity.Account;
import com.andersenlab.depositservice.domain.entity.Card;
import com.andersenlab.depositservice.domain.exeption.InternalServerException;
import com.andersenlab.depositservice.domain.mapper.CardMapper;
import com.andersenlab.depositservice.repository.CardRepository;
import com.andersenlab.depositservice.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    private final CardMapper cardMapper;

    @Override
    public List<ResponseCompletedCardsDto> getListOfDepositCard(String account) {

        Account account1 = new Account();
        account1.setAccountNumber(account);

        List<Card> cardListByAcc = cardRepository.findByAccount(account1);

        if (!CollectionUtils.isEmpty(cardListByAcc)) {
            return cardListByAcc.stream()
                    .map(cardMapper::cardToResponseCompletedCardsDto)
                    .collect(Collectors.toList());
        }

        throw new  InternalServerException("Card Not Found");
    }
}

