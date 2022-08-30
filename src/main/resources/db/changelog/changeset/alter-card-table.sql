--liquibase formatted sql
--changeset Ivan Kudryashov:alter_card_table

alter table card
    add date_of_creation date

--rollback DROP TABLE IF EXISTS card CASCADE