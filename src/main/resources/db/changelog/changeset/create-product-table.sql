--liquibase formatted sql
--changeset Ivan Kudryashov:create_product_table


CREATE TABLE product(
    id int primary key generated by default as identity,
    name VARCHAR(30),
    schema_name VARCHAR(30),
    interest_rate_early NUMERIC(6,4),
    is_capitalization BOOLEAN,
    amount_min NUMERIC(19,4),
    amount_max NUMERIC(19,4),
    currency_code CHAR(3),
    is_active BOOLEAN,
    is_revocable BOOLEAN,
    min_interest_rate NUMERIC(6,4),
    max_interest_rate NUMERIC(6,4),
    min_duration_months INTEGER,
    max_duration_months INTEGER,
    active_since DATE,
    active_until DATE
);

--rollback DROP TABLE IF EXISTS product CASCADE
