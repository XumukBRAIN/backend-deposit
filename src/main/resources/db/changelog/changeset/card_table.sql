--liquibase formatted sql

--changeset Sholkov:card_table

CREATE TABLE card
(
    card_number CHAR(16) PRIMARY KEY,
    premium_status VARCHAR(30),
    payment_system VARCHAR(30),
    account_number VARCHAR(30),
    transaction_limit NUMERIC(19,4),
    status VARCHAR(30),
    expiration_date DATE,
    holder_name VARCHAR(50),
    virtual_card BOOLEAN,
    cashback NUMERIC(6,4),
    co_brand VARCHAR(30),
    digital_wallet VARCHAR
);

ALTER TABLE card
    ADD CONSTRAINT card_account_fk FOREIGN KEY (account_number)
        REFERENCES account (account_number);

--rollback DROP TABLE IF EXISTS card CASCADE