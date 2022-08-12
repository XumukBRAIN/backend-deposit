package com.andersenlab.depositservice.services;

import com.andersenlab.depositservice.models.entity.Card;
import com.andersenlab.depositservice.repositories.CardRepository;
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
        return cardRepository.findByAccount_ClientId(client_id);
    }

}
