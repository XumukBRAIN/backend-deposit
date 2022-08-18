package com.andersenlab.depositservice.services;

import com.andersenlab.depositservice.models.entity.Card;
import com.andersenlab.depositservice.repositories.CardRepository;
import com.andersenlab.depositservice.exception.CardNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;


    public List<Card> getCardsByAccountClientIdAndCardIsActive(UUID clientId){
        List<Card> cardList = cardRepository.findByAccountClientIdAndAccountItActiveTrue(clientId);

        if (cardList.isEmpty())
            throw new CardNotFoundException("Active cards with this clientId not found");

        return cardList;
    }

}
