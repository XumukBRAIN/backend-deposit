package com.andersenlab.depositservice.services;

import com.andersenlab.depositservice.models.entity.Card;
import com.andersenlab.depositservice.repositories.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    public List<Card> getCardsByAccountClientIdAndCardIsActive(UUID clientId){
        return cardRepository.findByAccountClientIdAndAccountItActiveTrue(clientId);
    }

    public Card getActiveCardInfoByCardId(UUID cardId) {
        return cardRepository.findCardByIdAndAccountItActiveTrue(cardId);
    }

}
