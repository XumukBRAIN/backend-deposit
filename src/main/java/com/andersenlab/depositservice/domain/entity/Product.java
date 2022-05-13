package com.andersenlab.depositservice.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    private UUID id;

    @Column(name = "name")
    private String Name;

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
    private String currencyCode;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "is_revocable")
    private boolean isRevocable;

    @Column(name = "min_interest_rate")
    private BigDecimal minInterestRate;

    @Column(name = "max_interest_rate")
    private BigDecimal maxInterestRate;

    @Column(name = "min_duration_months")
    private Integer minDurationMonths;

    @Column(name = "max_duration_months")
    private Integer maxDurationMonths;

    @Column(name = "active_since")
    private LocalDate activeSince;

    @Column(name = "active_until")
    private LocalDate activeUntil;

}
