package com.andersenlab.depositservice.controllers;

import com.andersenlab.depositservice.models.dto.CardDTO;
import com.andersenlab.depositservice.models.dto.CardInfoDTO;
import com.andersenlab.depositservice.models.entity.Card;
import com.andersenlab.depositservice.models.mapStruct.CardInfoMapper;
import com.andersenlab.depositservice.models.mapStruct.CardMapper;
import com.andersenlab.depositservice.services.CardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "auth/deposit-cards")
@RequiredArgsConstructor
@Api("DS-5._Get_user card_list")
public class CardController {

    private final CardService cardService;
    private final CardMapper cardMapper;
    private final CardInfoMapper cardInfoMapper;

    @GetMapping(path = "/{clientId}")
    @ApiOperation("The method for viewing the user's cards by the ClientID. " + " ClientID field must be UUID! " +
            " And cards  must be active! ")
    public ResponseEntity<List<CardDTO>> getAllCardsByClientIdAndCardIsActive(@PathVariable UUID clientId){
        List<Card> cardList = cardService.getCardsByAccountClientIdAndCardIsActive(clientId);
        return ResponseEntity.ok(cardMapper.toListCardDTO(cardList));
    }

    @GetMapping()
    @ApiOperation("The method for viewing the card's info by the CardId. " + " CardId field must be UUID! " +
            " And card must be active! ")
    public ResponseEntity<CardInfoDTO> getInfoDepositCard(@RequestParam UUID cardId){
        Card card = cardService.getActiveCardInfoByCardId(cardId);
        return ResponseEntity.ok(cardInfoMapper.toCardInfoDto(card));
    }

}
