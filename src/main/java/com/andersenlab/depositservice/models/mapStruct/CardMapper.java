package com.andersenlab.depositservice.models.mapStruct;

import com.andersenlab.depositservice.models.dto.CardDTO;
import com.andersenlab.depositservice.models.entity.Card;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper {

    Card cardDTOToCard(CardDTO cardDTO);

}
