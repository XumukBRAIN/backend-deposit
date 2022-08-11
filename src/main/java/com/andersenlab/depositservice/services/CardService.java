package com.andersenlab.depositservice.services;

import com.andersenlab.depositservice.models.entity.Card;
import com.andersenlab.depositservice.repositories.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    public List<Card> getAllCards(){
        return cardRepository.findAll();
    }

    public Card getCard(String cardNumber){
        return cardRepository.findByCardNumber(cardNumber);
    }

    @Transactional
    public void createCard(Card card){
        cardRepository.save(card);
    }



}
