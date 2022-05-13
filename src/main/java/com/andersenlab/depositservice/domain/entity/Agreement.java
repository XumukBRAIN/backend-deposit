package com.andersenlab.depositservice.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "agreement")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Agreement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "account_number")
    private Account account;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "interest_rate")
    private BigDecimal interestRate;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "initial_amount")
    private BigDecimal initialAmount;

    @Column(name = "current_balance")
    private BigDecimal currentBalance;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "auto_renewal")
    private Boolean autoRenewal;

}
