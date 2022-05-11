--liquibase formatted sql

--changeset Sholkov:operation_type_table

CREATE TABLE operation_type
(
    type VARCHAR(30) PRIMARY KEY,
    is_debit BOOLEAN
);

--rollback DROP TABLE IF EXISTS operation_type CASCADE