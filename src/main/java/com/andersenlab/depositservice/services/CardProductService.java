package com.andersenlab.depositservice.services;

import com.andersenlab.depositservice.models.entity.CardProduct;
import com.andersenlab.depositservice.repositories.CardProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardProductService {

    private final CardProductRepository cardProductRepository;

    public List<CardProduct> getAllCardProducts(){
        return cardProductRepository.findCardProductByIsActiveIsTrue();
    }

}
