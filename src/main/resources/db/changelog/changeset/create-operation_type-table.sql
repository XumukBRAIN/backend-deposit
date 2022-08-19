--liquibase formatted sql
--changeset Ivan Kudryashov:create_operation_type_table

CREATE TABLE operation_type(
                               id int primary key,
                               type VARCHAR(30),
                               is_debit BOOLEAN
);

--rollback DROP TABLE IF EXISTS operation_type CASCADE
