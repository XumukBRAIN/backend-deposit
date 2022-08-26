package com.andersenlab.depositservice.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "card_product")
public class CardProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private int id;

    @OneToOne(mappedBy = "cardProduct")
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
    private String currencyCode;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "card_duration")
    private int cardDuration;

    public boolean isIsActive() {
        return isActive;
    }
}
