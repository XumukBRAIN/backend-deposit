package com.andersenlab.depositservice.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "account")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")

public class Account {

    @OneToMany(mappedBy = "account")
    private Set<Agreement> agreements;

    @Id
    @Column(name = "account_number")
    private String accountNumber;

    @OneToMany(mappedBy = "account")
    private Set<Card> cards;

    @OneToMany(mappedBy = "account")
    private Set<Operation> operations;

    @Column(name = "client_id")
    private UUID clientId;

    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "current_balance")
    private BigDecimal currentBalance;

    @Column(name = "open_date")
    private LocalDate openDate;

    @Column(name = "close_date")
    private LocalDate closeDate;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "salary_project")
    private String salaryProject;


}
