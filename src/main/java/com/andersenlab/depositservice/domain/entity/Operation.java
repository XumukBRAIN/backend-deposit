package com.andersenlab.depositservice.domain.entity;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "operation")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")

public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Exclude
    private UUID id;

    @OneToOne
    @JoinColumn(name = "operation_type_id")
    private OperationType operationType;

    @ManyToOne
    @JoinColumn(name = "account_number")
    private Account account;

    @Column(name = "account_number")
    private String cardNumber;

    @Column(name = "completed_at")
    private Date completedAt;

    @Column(name = "sum")
    private BigDecimal sum;

    @Column(name = "details")
    private String details;

    @Column(name = "currency_code")
    private String currencyCode;


}
