--liquibase formatted sql

--changeset Sholkov:operation_table

CREATE TABLE operation
(
    id UUID PRIMARY KEY,
    account_number VARCHAR(30),
    completed_at TIMESTAMP WITH TIME ZONE,
    sum NUMERIC(19,4),
    details TEXT,
    currency_code CHAR(3),
    operation_type_id VARCHAR(30)
);
ALTER TABLE operation
    ADD CONSTRAINT operation_account_fk FOREIGN KEY (account_number)
        REFERENCES account (account_number);

ALTER TABLE operation
    ADD CONSTRAINT operation_operation_type_fk FOREIGN KEY (operation_type_id)
        REFERENCES operation_type (type);

--rollback DROP TABLE IF EXISTS operation CASCADE