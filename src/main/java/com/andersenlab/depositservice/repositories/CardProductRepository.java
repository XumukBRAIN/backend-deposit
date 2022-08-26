package com.andersenlab.depositservice.repositories;

import com.andersenlab.depositservice.models.entity.CardProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardProductRepository extends JpaRepository<CardProduct, Integer> {

    List<CardProduct> findCardProductByIsActiveIsTrue();

}
