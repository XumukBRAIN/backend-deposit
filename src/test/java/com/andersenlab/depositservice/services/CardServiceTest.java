package com.andersenlab.depositservice.services;

import com.andersenlab.depositservice.TestMapperCard;
import com.andersenlab.depositservice.models.entity.Card;
import com.andersenlab.depositservice.repositories.CardRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class CardServiceTest {

    @Mock
    private CardRepository cardRepository;

    @InjectMocks
    private CardService cardService;

    @Test
    void getCardsByAccountClientIdAndCardIsActiveShouldReturnCardList(){
        UUID clientId = UUID.randomUUID();

        List<Card> expectedList = TestMapperCard.createCardList();

        when(cardRepository.findByAccountClientIdAndAccountItActiveTrue(clientId))
                .thenReturn(expectedList);

        List<Card> actualList = cardService.getCardsByAccountClientIdAndCardIsActive(clientId);

        assertEquals(expectedList, actualList);

        System.out.println("Method is work correctly");
    }
    @Test
    void getInfoDepositCard(){
        UUID cardId = UUID.randomUUID();

        Card expected = new Card();

        when(cardRepository.findCardByIdAndAccountItActiveTrue(cardId)).thenReturn(expected);

        Card result = cardService.getActiveCardInfoByCardId(cardId);

        assertEquals(expected, result);

        System.out.println("Method is work correctly");
    }

}
