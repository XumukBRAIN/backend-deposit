package com.andersenlab.depositservice.controllers;

import com.andersenlab.depositservice.models.mapStruct.CardMapper;
import com.andersenlab.depositservice.repositories.CardRepository;
import com.andersenlab.depositservice.services.CardService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.UUID;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@ContextConfiguration(classes = {CardController.class, CardService.class, CardRepository.class})
@WebMvcTest
class CardControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CardMapper cardMapper;

    @MockBean
    private CardService cardService;

    private WebApplicationContext webApplicationContext;

    @MockBean
    private CardRepository cardRepository;

    @Before(value = "setup")
    public void setUp() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void getCardByClientIdShouldUseCardServiceMethod() throws Exception {
        UUID clientId = UUID.fromString("dc15b7fc-4099-4775-933a-eba5ad7b62dd");
        when(cardService.getCardsByAccount_clientIdAndCardIsActive(clientId)).thenReturn(cardService.getCardsByAccount_clientIdAndCardIsActive(clientId));

        mockMvc.perform(get("/auth/deposit-cards/")
                        .param("clientId", String.valueOf(clientId)))
                .andDo(print());
        verify(cardService, times(1)).getCardsByAccount_clientIdAndCardIsActive(clientId);
    }

}