package com.andersenlab.depositservice.models.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "account")
public class Account {

    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonManagedReference
    private List<Card> cards;

    @OneToMany(mappedBy = "account")
    @ToString.Exclude
    private List<Agreement> agreements;

    @OneToOne(mappedBy = "account")
    @ToString.Exclude
    private Operation operation;

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "account_number")
    private String accountNumber;

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
