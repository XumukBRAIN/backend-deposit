package com.andersenlab.depositservice.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
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
    private String card_name;

    @Column(name = "payment_system")
    private String payment_system;

    @Column(name = "cashback")
    private BigDecimal cashback;

    @Column(name = "co_brand")
    private String co_brand;

    @Column(name = "is_virtual")
    private boolean is_virtual;

    @Column(name = "premium_status")
    private String premium_status;

    @Column(name = "service_price")
    private BigDecimal service_price;

    @Column(name = "product_price")
    private BigDecimal product_price;

    @Column(name = "currency_code")
    private char currency_code;

    @Column(name = "card_duration")
    private int card_duration;

}
