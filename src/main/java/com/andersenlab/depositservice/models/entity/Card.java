package com.andersenlab.depositservice.models.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "card")
@Data
@Builder
@ToString
@Getter
@Setter
public class Card {

    @Id
    @GeneratedValue(generator = "UUID")
    @EqualsAndHashCode.Exclude
    private UUID id;

    @Column(name = "card_number")
    private String cardNumber;

    @OneToOne
    @JoinColumn(name = "card_product_id")
    private CardProduct cardProduct;

    @ManyToOne
    @JoinColumn(name = "account_id")
    @ToString.Exclude
    private Account account;

    @Column(name = "transactional_limit")
    private BigDecimal transactional_limit;

    @Column(name = "status")
    private String status;

    @Column(name = "expiration_date")
    private Date expiration_date;

    @Column(name = "holder_name")
    private String holder_name;

    @Column(name = "digital_wallet")
    private String digital_wallet;

    @Column(name = "is_default")
    private boolean is_default;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCard_number() {
        return cardNumber;
    }

    public void setCard_number(String card_number) {
        this.cardNumber = card_number;
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
