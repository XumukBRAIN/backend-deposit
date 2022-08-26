package com.andersenlab.depositservice.models.dto;

import com.andersenlab.depositservice.models.entity.Card;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardProductDto {

    private int id;

    private String cardName;

    private String paymentSystem;

    private BigDecimal cashback;

    private String coBrand;

    @JsonProperty("isVirtual")
    private boolean isVirtual;

    private String premiumStatus;

    private BigDecimal servicePrice;

    private BigDecimal productPrice;

    private String currencyCode;

    @JsonProperty("isActive")
    private boolean isActive;

    private int cardDuration;

}
