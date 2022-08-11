package com.andersenlab.depositservice.models.dto;

import com.andersenlab.depositservice.models.entity.Account;
import com.andersenlab.depositservice.models.entity.CardProduct;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;


@ToString
@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardDTO {

    private String cardNumber;

    private CardProduct cardProduct;

    private Account account;

    private BigDecimal transactional_limit;

    private String status;

    private Date expiration_date;

    private String holder_name;

    private String digital_wallet;

    private boolean is_default;

    private String accountNumber;

    private String currencyCode;

    private BigDecimal currentBalance;

}
