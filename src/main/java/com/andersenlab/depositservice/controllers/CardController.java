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

@RestController
@RequestMapping(path = "auth/deposits")
@RequiredArgsConstructor
@Api("DS-5._Получить_список_карт_Пользователя")
public class CardController {

    private final CardService cardService;
    private final CardMapper cardMapper;

    @GetMapping("/all/{clientId}")
    @ApiOperation("Метод для просмотра карт у пользователя по полю clientId. " +
            "clientId должен быть обязательно UUID! ")
    public List<CardDTO> getAllCardsByAccount_clientId(@PathVariable UUID clientId){
        return cardMapper.toListCardDTO(cardService.getCardsByAccount_clientId(clientId));
    }
}
