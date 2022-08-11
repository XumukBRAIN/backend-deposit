create table account(
    id uuid primary key default gen_random_uuid(),
    account_number varchar(30) not null unique,
    client_id uuid not null,
    currency_code char(3),
    current_balance numeric(19,4),
    open_date date,
    close_date date,
    is_active boolean,
    salary_project varchar(30),
    blocked_sum numeric(19,4)
)