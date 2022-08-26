package com.andersenlab.depositservice.controllers;

import com.andersenlab.depositservice.exception.BadRequestException;
import com.andersenlab.depositservice.exception.CardProductNotFoundException;
import com.andersenlab.depositservice.models.mapStruct.CardProductMapper;
import com.andersenlab.depositservice.repositories.CardProductRepository;
import com.andersenlab.depositservice.services.CardProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CardProductController.class)
public class CardProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CardProductRepository cardProductRepository;

    @MockBean
    private CardProductService cardProductService;

    @MockBean
    private CardProductMapper cardProductMapper;

    @Test
    void getAllCardProductsShouldReturn404() throws Exception{
        when(cardProductMapper.toCardProductDtoList(anyList()))
                .thenThrow(new CardProductNotFoundException("Card products doesn't exist!"));

        mockMvc.perform(get("/auth/deposit-cards/card-products"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void getAllCardProductsShouldReturn400() throws Exception{
        when(cardProductMapper.toCardProductDtoList(anyList()))
                .thenThrow(new BadRequestException("Bad request!"));

        mockMvc.perform(get("/auth/deposit-cards/card-products"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

}
