create table card_product(
    id int generated by default as identity primary key,
    card_name varchar(30),
    payment_system varchar(30),
    cashback numeric(6,4),
    co_brand varchar(30),
    is_virtual boolean,
    premium_status varchar(30),
    service_price numeric(19,4),
    product_price numeric(19,4),
    currency_code char(3),
    is_active boolean,
    card_duration int
)