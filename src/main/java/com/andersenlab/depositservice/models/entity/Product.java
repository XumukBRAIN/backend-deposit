package com.andersenlab.depositservice.models.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@ToString
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private int id;

    @OneToOne(mappedBy = "product")
    @ToString.Exclude
    private Agreement agreement;

    @Column(name = "name")
    private String name;

    @Column(name = "schema_name")
    private String schemaName;

    @Column(name = "interest_rate_early")
    private BigDecimal interestRateEarly;

    @Column(name = "is_capitalization")
    private boolean isCapitalization;

    @Column(name = "amount_min")
    private BigDecimal amountMin;

    @Column(name = "amount_max")
    private BigDecimal amountMax;

    @Column(name = "currency_code")
    private char currencyCode;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "is_revocable")
    private boolean isRevocable;

    @Column(name = "min_interest_rate")
    private BigDecimal minInterestRate;

    @Column(name = "max_interest_rate")
    private BigDecimal maxInterestRate;

    @Column(name = "min_duration_months")
    private int minDurationMonths;

    @Column(name = "max_duration_months")
    private int maxDurationMonths;

    @Column(name = "active_since")
    private Date activeSince;

    @Column(name = "active_until")
    private Date activeUntil;

}
