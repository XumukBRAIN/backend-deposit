package com.andersenlab.depositservice.models.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "agreement")
public class Agreement {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "agreement_number")
    private String agreementNumber;

    @ManyToOne
    @JoinColumn(name = "account_id")
    @ToString.Exclude
    private Account account;

    @Column(name = "interest_rate")
    private BigDecimal interestRate;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "initial_amount")
    private BigDecimal initialAmount;

    @Column(name = "current_balance")
    private BigDecimal currentBalance;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "auto_renewal")
    private boolean autoRenewal;

}
