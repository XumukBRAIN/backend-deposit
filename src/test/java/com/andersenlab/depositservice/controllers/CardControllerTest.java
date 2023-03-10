package com.andersenlab.depositservice.controllers;

import com.andersenlab.depositservice.exception.BadRequestException;
import com.andersenlab.depositservice.exception.CardNotFoundException;
import com.andersenlab.depositservice.models.mapStruct.CardInfoMapper;
import com.andersenlab.depositservice.models.mapStruct.CardMapper;
import com.andersenlab.depositservice.repositories.CardRepository;
import com.andersenlab.depositservice.services.CardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(CardController.class)
class CardControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CardMapper cardMapper;

    @MockBean
    private CardInfoMapper cardInfoMapper;

    @MockBean
    private CardService cardService;

    @MockBean
    private CardRepository cardRepository;

    @Test
    void getAllCardsByClientIdAndCardIsActiveShouldReturnOK() throws Exception{
        when(cardMapper.toListCardDTO(anyList())).thenReturn(anyList());

        mockMvc.perform(get("/auth/deposit-cards/" + UUID.randomUUID()))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getInfoDepositCardShouldReturnOk() throws Exception{
        when(cardInfoMapper.toCardInfoDto(any())).thenReturn(any());

        String cardId = String.valueOf(UUID.randomUUID());

        mockMvc.perform(get("/auth/deposit-cards/")
                        .param("cardId", cardId))
                        .andDo(print())
                        .andExpect(status().isOk());
    }

    @Test
    void getAllCardsByClientIdAndCardIsActiveShouldReturn404() throws Exception{
        when(cardMapper.toListCardDTO(anyList()))
                .thenThrow(new CardNotFoundException("Active cards not found with this client ID"));

        mockMvc.perform(get("/auth/deposit-cards/" + UUID.randomUUID()))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void getInfoDepositCardShouldReturn404() throws Exception{
        when(cardInfoMapper.toCardInfoDto(any()))
                .thenThrow(new CardNotFoundException("Information about this card not found. Cause by: card with this ID doesn't exist."));

        String cardId = String.valueOf(UUID.randomUUID());

        mockMvc.perform(get("/auth/deposit-cards/").param("cardId", cardId))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void getAllCardsByClientIdAndCardIsActiveShouldReturn400() throws Exception{
        when(cardMapper.toListCardDTO(anyList()))
                .thenThrow(new BadRequestException("Bad request!"));
        mockMvc.perform(get("/auth/deposit-cards/" + UUID.randomUUID()))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void getInfoDepositCardShouldReturn400() throws Exception{
        when(cardInfoMapper.toCardInfoDto(any())).thenThrow(new BadRequestException("Bad request!"));

        String cardId = String.valueOf(UUID.randomUUID());

        mockMvc.perform(get("/auth/deposit-cards/").param("cardId", cardId))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void getAllCardsByClientIdAndCardIsActiveShouldUseCardMapperMethod() throws Exception{
        when(cardMapper.toListCardDTO(anyList())).thenReturn(anyList());

        mockMvc.perform(get("/auth/deposit-cards/" + UUID.randomUUID()))
                .andDo(print());

        verify(cardMapper, times(1)).toListCardDTO(anyList());

    }

    @Test void getInfoDepositCardShouldUseCardInfoMapperMethod() throws Exception{
        when(cardInfoMapper.toCardInfoDto(any())).thenReturn(any());

        String cardId = String.valueOf(UUID.randomUUID());

        mockMvc.perform(get("/auth/deposit-cards/").param("cardId", cardId))
                .andDo(print());

        verify(cardInfoMapper, times(1)
                .description("That's how many times this method has been called")).toCardInfoDto(any());

    }

}