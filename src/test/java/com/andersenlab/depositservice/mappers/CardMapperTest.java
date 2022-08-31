package com.andersenlab.depositservice.mappers;

import com.andersenlab.depositservice.Fixtures;
import com.andersenlab.depositservice.models.mapStruct.CardMapper;
import lombok.var;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardMapperTest {

    private final CardMapper cardMapper = Mappers.getMapper(CardMapper.class);

    @Test
    void toCardDto(){
        var card = Fixtures.createCardTest();
        var cardDto = Fixtures.createCardDtoTest();

        var actualCardDto = cardMapper.toCardDTO(card);

        assertEquals(cardDto, actualCardDto);
    }

    @Test
    void toListCardDto(){
        var listCard = Fixtures.createListCardTest();
        var expectedListCardDto = Fixtures.createListCardDtoTest();

        var actualListCardDto = cardMapper.toListCardDTO(listCard);

        assertEquals(expectedListCardDto, actualListCardDto);
    }

}
