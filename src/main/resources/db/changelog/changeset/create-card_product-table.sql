--liquibase formatted sql
--changeset Ivan Kudryashov:create_card_product_table

create table card_product(
                             id int primary key,
                             card_name varchar(30),
                             payment_system varchar(30),
                             cashback numeric(6,4),
                             co_brand varchar(30),
                             is_virtual boolean,
                             premium_status varchar(30),
                             service_price numeric(19,4),
                             product_price numeric(19,4),
                             currency_code varchar(3),
                             is_active boolean,
                             card_duration int
)

--rollback DROP TABLE IF EXISTS card_product CASCADE
