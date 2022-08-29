package com.andersenlab.depositservice.controllers;

import com.andersenlab.depositservice.models.dto.CardProductDto;
import com.andersenlab.depositservice.models.entity.CardProduct;
import com.andersenlab.depositservice.models.mapStruct.CardProductMapper;
import com.andersenlab.depositservice.services.CardProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "auth/deposit-cards")
@RequiredArgsConstructor
@Api("US-4.3")
@CrossOrigin
public class CardProductController {

    private final CardProductService cardProductService;
    private final CardProductMapper cardProductMapper;

    @GetMapping("/card-products")
    @ApiOperation("The method for viewing the all card products.")
    public ResponseEntity<List<CardProductDto>> getAllCardProducts(){
        List<CardProduct> cardProductList = cardProductService.getAllCardProducts();
        return ResponseEntity.ok(cardProductMapper.toCardProductDtoList(cardProductList));
    }

}
