--liquibase formatted sql
--changeset Ivan Kudryashov:create_card_table

create table card (
    id uuid primary key default uuid_generate_v4(),
    card_number char(16),
    account_id uuid references account(id),
    transactional_limit numeric(19,4),
    status varchar(30),
    expiration_date date,
    holder_name varchar(50),
    digital_wallet varchar(30),
    is_default boolean,
    card_product_id int references card_product(id)
)

--rollback DROP TABLE IF EXISTS card CASCADE
