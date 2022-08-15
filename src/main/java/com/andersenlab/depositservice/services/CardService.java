package com.andersenlab.depositservice.services;

import com.andersenlab.depositservice.models.entity.Card;
import com.andersenlab.depositservice.repositories.CardRepository;
import com.andersenlab.depositservice.exception.CardNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    @Transactional(readOnly = true)
    public List<Card> getCardsByAccount_clientId(UUID client_id){
        List<Card> cardList = cardRepository.findByAccount_ClientId(client_id);

        if(cardList.isEmpty())
            throw new CardNotFoundException("Cards with this clientId not found");

        return cardList;
    }

}
