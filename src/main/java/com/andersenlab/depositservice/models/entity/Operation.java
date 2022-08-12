package com.andersenlab.depositservice.models.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "operation")
public class Operation {

    @Id
    @GeneratedValue(generator = "UUID")
    @EqualsAndHashCode.Exclude
    private UUID id;

    @OneToOne
    @JoinColumn(name = "account_id")
    @ToString.Exclude
    private Account account;

    @OneToOne
    @JoinColumn(name = "operation_type_id")
    @ToString.Exclude
    private OperationType operationType;

    @Column(name = "completed_at")
    private LocalDate completed_at;

    @Column(name = "sum")
    private BigDecimal sum;

    @Column(name = "details")
    private String details;

    @Column(name = "currency_code")
    private char currency_code;

}
