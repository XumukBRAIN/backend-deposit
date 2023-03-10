--liquibase formatted sql
--changeset Ivan Kudryashov:create_agreement_table

create table agreement(
    id uuid primary key default uuid_generate_v4(),
    agreement_number varchar(20) not null unique,
    account_id uuid references account(id),
    product_id int references product(id),
    interest_rate numeric(6,4),
    start_date timestamp with time zone,
    end_date timestamp with time zone,
    initial_amount numeric(19,4),
    current_balance numeric(19,4),
    is_active boolean,
    auto_renewal boolean
)

--rollback DROP TABLE IF EXISTS agreement CASCADE
