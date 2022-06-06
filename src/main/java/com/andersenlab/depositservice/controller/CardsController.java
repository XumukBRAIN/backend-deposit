package com.andersenlab.depositservice.controller;

import com.andersenlab.depositservice.domain.dto.ResponseCompletedCardsDto;
import com.andersenlab.depositservice.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("cards")
public class CardsController {

    private final CardService cardService;

    @GetMapping("active-products")
    public ResponseEntity<Collection<ResponseCompletedCardsDto>> getListOfDepositCard(@RequestParam String account) {

        return ResponseEntity.ok(cardService.getListOfDepositCard(account));

    }

}
