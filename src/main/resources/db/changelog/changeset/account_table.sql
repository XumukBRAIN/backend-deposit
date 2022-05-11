--liquibase formatted sql

--changeset Sholkov:account_table

CREATE TABLE account
(
    account_number VARCHAR (30) PRIMARY KEY,
    client_id UUID,
    currency_code CHAR (3),
    current_balance NUMERIC (19,4),
    open_date DATE,
    close_date DATE,
    is_active BOOLEAN,
    salary_project VARCHAR (30)
);

--rollback DROP TABLE IF EXISTS account CASCADE