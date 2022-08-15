package com.andersenlab.depositservice.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "card")
@Data
@Builder
public class Card {

    @Id
    @GeneratedValue(generator = "UUID")
    @EqualsAndHashCode.Exclude
    private UUID id;

    @Column(name = "card_number")
    private String cardNumber;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "card_product_id")
    @JsonIgnoreProperties
    private CardProduct cardProduct;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    @JsonBackReference
    private Account account;

    @Column(name = "transactional_limit")
    private BigDecimal transactionalLimit;

    @Column(name = "status")
    private String status;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(name = "holder_name")
    private String holderName;

    @Column(name = "digital_wallet")
    private String digitalWallet;

    @Column(name = "is_default")
    private boolean itDefault;

    public boolean isItDefault() {
        return itDefault;
    }

}
