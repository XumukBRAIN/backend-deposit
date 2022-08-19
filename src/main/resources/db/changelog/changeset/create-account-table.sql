--liquibase formatted sql
--changeset Ivan Kudryashov:create_account_table

CREATE
    EXTENSION IF NOT EXISTS "uuid-ossp";

create table account(
                        id uuid primary key default uuid_generate_v4(),
                        account_number varchar(30) not null unique,
                        client_id uuid not null,
                        currency_code varchar(3),
                        current_balance numeric(19,4),
                        open_date date,
                        close_date date,
                        is_active boolean,
                        salary_project varchar(30),
                        blocked_sum numeric(19,4)
)

--rollback DROP TABLE IF EXISTS account CASCADE
