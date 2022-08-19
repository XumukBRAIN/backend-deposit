--liquibase formatted sql
--changeset Ivan Kudryashov:create_operation_table

CREATE TABLE operation(
                          id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                          account_id uuid references account(id),
                          account_number VARCHAR(30),
                          completed_at TIMESTAMP WITH TIME ZONE,
                          sum NUMERIC(19,4),
                          details TEXT,
                          currency_code CHAR(3),
                          operation_type_id int references operation_type(id)
)

--rollback DROP TABLE IF EXISTS operation CASCADE
