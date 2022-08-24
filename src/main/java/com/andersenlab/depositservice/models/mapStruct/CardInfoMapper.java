package com.andersenlab.depositservice.models.mapStruct;

import com.andersenlab.depositservice.models.dto.CardInfoDTO;
import com.andersenlab.depositservice.models.entity.Card;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CardInfoMapper {

    @Mapping(target = "currentBalance", source = "card.account.currentBalance")
    @Mapping(target = "currencyCode", source = "card.account.currencyCode")
    @Mapping(target = "accountNumber", source = "card.account.accountNumber")
    CardInfoDTO toCardInfoDto(Card card);

}
