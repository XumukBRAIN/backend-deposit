package com.andersenlab.depositservice.mappers;

import com.andersenlab.depositservice.Fixtures;
import com.andersenlab.depositservice.models.mapStruct.CardProductMapper;
import lombok.var;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardProductMapperTest {

    private final CardProductMapper cardProductMapper = Mappers.getMapper(CardProductMapper.class);

    @Test
    void toCardProductDto(){
        var cardProduct = Fixtures.createCardProductTest();
        var cardProductDto = Fixtures.createCardProductDtoTest();

        var actualCardProductDto = cardProductMapper.toCardProductDto(cardProduct);

        assertEquals(cardProductDto, actualCardProductDto);
    }

    @Test
    void toListCardProductDto(){
        var listCardProduct = Fixtures.createListCardProductTest();
        var listCardProductDto = Fixtures.createListCardProductDtoTest();

        var actualListCardProductDto = cardProductMapper.toCardProductDtoList(listCardProduct);

        assertEquals(listCardProductDto, actualListCardProductDto);
    }

}
