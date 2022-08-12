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
@ToString
@Setter
@Getter
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
    private String agreement_number;

    @ManyToOne
    @JoinColumn(name = "account_id")
    @ToString.Exclude
    private Account account;

    @Column(name = "interest_rate")
    private BigDecimal interest_rate;

    @Column(name = "start_date")
    private LocalDateTime start_date;

    @Column(name = "end_date")
    private LocalDateTime end_date;

    @Column(name = "initial_amount")
    private BigDecimal initial_amount;

    @Column(name = "current_balance")
    private BigDecimal current_balance;

    @Column(name = "is_active")
    private boolean is_active;

    @Column(name = "auto_renewal")
    private boolean auto_renewal;

}
