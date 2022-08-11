package com.andersenlab.depositservice.models.dto;

import com.andersenlab.depositservice.models.entity.Account;
import com.andersenlab.depositservice.models.entity.CardProduct;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@ToString
public class CardDTO {

    private String card_number;

    private CardProduct cardProduct;

    private Account account;

    private BigDecimal transactional_limit;

    private String status;

    private Date expiration_date;

    private String holder_name;

    private String digital_wallet;

    private boolean is_default;

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public CardProduct getCardProduct() {
        return cardProduct;
    }

    public void setCardProduct(CardProduct cardProduct) {
        this.cardProduct = cardProduct;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public BigDecimal getTransactional_limit() {
        return transactional_limit;
    }

    public void setTransactional_limit(BigDecimal transactional_limit) {
        this.transactional_limit = transactional_limit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }

    public String getHolder_name() {
        return holder_name;
    }

    public void setHolder_name(String holder_name) {
        this.holder_name = holder_name;
    }

    public String getDigital_wallet() {
        return digital_wallet;
    }

    public void setDigital_wallet(String digital_wallet) {
        this.digital_wallet = digital_wallet;
    }

    public boolean isIs_default() {
        return is_default;
    }

    public void setIs_default(boolean is_default) {
        this.is_default = is_default;
    }
}
