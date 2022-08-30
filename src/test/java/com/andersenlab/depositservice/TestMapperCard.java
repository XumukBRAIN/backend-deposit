package com.andersenlab.depositservice;

import com.andersenlab.depositservice.models.entity.Card;
import com.andersenlab.depositservice.models.entity.CardProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TestMapperCard {
    public static List<Card> createCardList() {

        List<Card> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Card().builder()
                    .id(UUID.randomUUID())
                    .build());
        }
        return list;


    }

    public static List<CardProduct> createProductList(){
        List<CardProduct> productList = new ArrayList<>();
        for (int i = 0; i < 13; i++){
            productList.add(new CardProduct().builder()
                    .id(1)
                    .build());
        }
        return productList;
    }

}
