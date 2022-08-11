package com.andersenlab.depositservice.controllers;

import com.andersenlab.depositservice.models.dto.CardDTO;
import com.andersenlab.depositservice.models.mapStruct.CardMapper;
import com.andersenlab.depositservice.services.CardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/*
    JSON - ответ должен содержать в себе:
        - все параметры карты пользователя из таблицы deposit-service.card;
        - account_number - номера текущего счета, к которому привязана карта, из таблицы account;
        - current_balance - остаток по счету из таблицы account;
        - currency_code - код валюты из таблицы account.
    Ответы от сервера могут быть следующие:
        - 200 OK;
        - 400 BAD REQUEST + BODY;
        - 401 UNAUTHORIZED + BODY;
        - 404 NOT_FOUND;
        - 500 INTERNAL SERVER ERROR + BODY
*/
@RestController
@RequestMapping(path = "auth/deposits")
@RequiredArgsConstructor
@Api("Контроллер для иллюстрации работы Swagger UI")
public class CardController {

    private final CardService cardService;
    private final CardMapper cardMapper;

    @GetMapping("/all/{clientId}")
    @ApiOperation("Метод для просмотра карт у пользователя по полю clientId - 2 попытка")
    public List<CardDTO> getAllCardsByAccount_clientId(@PathVariable UUID clientId){
        return cardMapper.toListCardDTO(cardService.getCardsByAccount_clientId(clientId));
    }

}
