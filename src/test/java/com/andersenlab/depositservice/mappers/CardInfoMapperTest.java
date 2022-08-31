package com.andersenlab.depositservice.mappers;

import com.andersenlab.depositservice.Fixtures;
import com.andersenlab.depositservice.models.mapStruct.CardInfoMapper;
import lombok.var;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardInfoMapperTest {

    private final CardInfoMapper cardInfoMapper = Mappers.getMapper(CardInfoMapper.class);

    @Test
    void toCardInfoDto(){
        var cardInfo = Fixtures.createCardInfoTest();
        var expectedCardInfoDto = Fixtures.createCardInfoDtoTest();

        var actualCardInfoDto = cardInfoMapper.toCardInfoDto(cardInfo);

        assertEquals(expectedCardInfoDto, actualCardInfoDto);
    }

}
