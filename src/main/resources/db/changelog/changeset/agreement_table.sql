--liquibase formatted sql

--changeset Sholkov:agreement_table

CREATE TABLE agreement
(
    id VARCHAR(20) PRIMARY KEY,
    account_number VARCHAR(30),
    product_id UUID,
    interest_rate NUMERIC(6,4),
    start_date TIMESTAMP WITH TIME ZONE,
    end_date TIMESTAMP WITH TIME ZONE,
    initial_amount NUMERIC(19,4),
    current_balance NUMERIC(19,4),
    is_active BOOLEAN,
    auto_renewal BOOLEAN
);
ALTER TABLE agreement
    ADD CONSTRAINT agreement_product_fk FOREIGN KEY (product_id)
        REFERENCES product (id);

ALTER TABLE agreement
    ADD CONSTRAINT agreement_account_fk FOREIGN KEY (account_number)
        REFERENCES account (account_number)

--rollback DROP TABLE IF EXISTS agreement CASCADE