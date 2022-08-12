package com.andersenlab.depositservice.models.entity;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Setter
@Getter
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
    private String schema_name;

    @Column(name = "interest_rate_early")
    private BigDecimal interest_rate_early;

    @Column(name = "is_capitalization")
    private boolean is_capitalization;

    @Column(name = "amount_min")
    private BigDecimal amount_min;

    @Column(name = "amount_max")
    private BigDecimal amount_max;

    @Column(name = "currency_code")
    private char currency_code;

    @Column(name = "is_active")
    private boolean is_active;

    @Column(name = "is_revocable")
    private boolean is_revocable;

    @Column(name = "min_interest_rate")
    private BigDecimal min_interest_rate;

    @Column(name = "max_interest_rate")
    private BigDecimal max_interest_rate;

    @Column(name = "min_duration_months")
    private int min_duration_months;

    @Column(name = "max_duration_months")
    private int max_duration_months;

    @Column(name = "active_since")
    private Date active_since;

    @Column(name = "active_until")
    private Date active_until;

}
