package com.andersenlab.depositservice.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@ToString
@Entity
@Table(name = "card_product")
public class CardProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private int id;

    @OneToOne(mappedBy = "cardProduct", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonIgnoreProperties
    private Card card;

    @Column(name = "card_name")
    private String cardName;

    @Column(name = "payment_system")
    private String paymentSystem;

    @Column(name = "cashback")
    private BigDecimal cashback;

    @Column(name = "co_brand")
    private String coBrand;

    @Column(name = "is_virtual")
    private boolean isVirtual;

    @Column(name = "premium_status")
    private String premiumStatus;

    @Column(name = "service_price")
    private BigDecimal servicePrice;

    @Column(name = "product_price")
    private BigDecimal productPrice;

    @Column(name = "currency_code")
    private char currencyCode;

    @Column(name = "card_duration")
    private int cardDuration;

}
