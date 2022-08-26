package com.andersenlab.depositservice.models.mapStruct;

import com.andersenlab.depositservice.models.dto.CardProductDto;
import com.andersenlab.depositservice.models.entity.CardProduct;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardProductMapper {


    CardProductDto toCardProductDto(CardProduct cardProduct);

    List<CardProductDto> toCardProductDtoList(List<CardProduct> list);
}
