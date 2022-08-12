package com.andersenlab.depositservice.models.dto;

import lombok.*;

import java.math.BigDecimal;


@ToString
@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardDTO {

    private String cardId;

    private String cardNumber;

    private BigDecimal transactional_limit;

    private String status;

    private String expiration_date;

    private String holder_name;

    private String digital_wallet;

    private boolean is_default;

    private String card_product_id;

    private String accountNumber;

    private String currencyCode;

    private BigDecimal currentBalance;

}
