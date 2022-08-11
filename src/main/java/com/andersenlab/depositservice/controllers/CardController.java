package com.andersenlab.depositservice.controllers;

import com.andersenlab.depositservice.models.dto.CardDTO;
import com.andersenlab.depositservice.models.entity.Card;
import com.andersenlab.depositservice.models.mapStruct.CardMapper;
import com.andersenlab.depositservice.services.CardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping("/getAll")
    @ApiOperation("Все дебетовые карты!")
    public List<Card> getAllCard(){
        return cardService.getAllCards();
    }

    @GetMapping("/getOne/{cardNumber}")
    @ApiOperation("Найти дебетовую карту по номеру карты")
    public Card getCard(@PathVariable String cardNumber){
        return cardService.getCard(cardNumber);
    }

    @PostMapping("/create")
    @ApiOperation("Создание новой Дебетовой карты")
    public ResponseEntity<HttpStatus> createCard(@RequestBody @Valid CardDTO cardDTO){
        cardService.createCard(cardMapper.cardDTOToCard(cardDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
