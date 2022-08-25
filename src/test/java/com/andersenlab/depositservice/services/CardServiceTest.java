package com.andersenlab.depositservice.services;

import com.andersenlab.depositservice.TestMapperCard;
import com.andersenlab.depositservice.exception.CardNotFoundException;
import com.andersenlab.depositservice.models.entity.Card;
import com.andersenlab.depositservice.repositories.CardRepository;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
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
    }
    @Test
    void getInfoDepositCard(){
        UUID cardId = UUID.randomUUID();

        Card cardExp = cardService.getActiveCardInfoByCardId(cardId);

        when(cardRepository.findCardByIdAndAccountItActiveTrue(cardId))
                .thenReturn(any());

        Card cardAct = cardService.getActiveCardInfoByCardId(cardId);

        assertEquals(cardExp, cardAct);
    }

    @Test
    void findCardsByClientIdShouldThrownException() {
        UUID clientId = UUID.randomUUID();

        when(cardRepository.findByAccountClientIdAndAccountItActiveTrue(clientId))
                .thenThrow(new CardNotFoundException("Information about this card not found. Cause by: card with this ID doesn't exist."));

        ThrowableAssert.ThrowingCallable throwingCallable =
                () -> cardService.getCardsByAccountClientIdAndCardIsActive(clientId);

        assertThatThrownBy(throwingCallable).isInstanceOf(CardNotFoundException.class);
    }

    @Test
    void getInfoDepositCardShouldThrownException(){
        UUID cardId = UUID.randomUUID();

        when(cardRepository.findCardByIdAndAccountItActiveTrue(cardId))
                .thenThrow(new CardNotFoundException("Information about this card not found. Cause by: card with this ID doesn't exist."));

        ThrowableAssert.ThrowingCallable throwingCallable = () -> cardService.getActiveCardInfoByCardId(cardId);

        assertThatThrownBy(throwingCallable).isInstanceOf(CardNotFoundException.class);
    }

}
