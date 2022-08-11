CREATE TABLE operation
(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    account_id uuid references account(id),
    account_number VARCHAR(30),
    completed_at TIMESTAMP WITH TIME ZONE,
    sum NUMERIC(19,4),
    details TEXT,
    currency_code CHAR(3),
    operation_type_id int references operation_type(id)
)
