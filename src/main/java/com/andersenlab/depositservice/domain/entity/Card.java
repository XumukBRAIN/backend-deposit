package com.andersenlab.depositservice.domain.entity;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "card")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")

public class Card {

    @ManyToOne
    @JoinColumn(name = "account_number")
    private Account account;

    @Id
    @EqualsAndHashCode.Exclude
    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "premium_status")
    private String premiumStatus;

    @Column(name = "payment_system")
    private String paymentSystem;

    @Column(name = "transaction_limit")
    private BigDecimal transactionLimit;

    @Column(name = "status")
    private String status;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(name = "holder_name")
    private String holderName;

    @Column(name = "virtual_card")
    private boolean virtualCard;

    @Column(name = "cashback")
    private BigDecimal cashback;

    @Column(name = "co-brand")
    private String coBrand;

    @Column(name = "digital_wallet")
    private String digitalWallet;

}
