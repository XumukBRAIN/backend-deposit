package com.andersenlab.depositservice.domain.entity;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "operation")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Operation {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @EqualsAndHashCode.Exclude
    private UUID id;

    @OneToOne
    @JoinColumn(name = "operation_type_id")
    private OperationType operationType;

    @ManyToOne
    @JoinColumn(name = "account_number")
    private Account account;

    @Column(name = "completed_at")
    private Date completedAt;

    @Column(name = "sum")
    private BigDecimal sum;

    @Column(name = "details")
    private String details;

    @Column(name = "currency_code")
    private String currencyCode;


}
