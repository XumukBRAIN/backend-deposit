package com.andersenlab.depositservice.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "operation_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")

public class OperationType {

    @Id
    @EqualsAndHashCode.Exclude
    @Column(name = "type")
    private String type;

    @Column(name = "is_debit")
    private boolean isDebit;
}
