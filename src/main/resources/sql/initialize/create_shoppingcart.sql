-- auto-generated definition
create table if not exists shoppingcart
(
    id_shoppingcart integer
        constraint shoppingcart_pk
            primary key autoincrement,
    id_user         integer
        references user,
    ingredient      text,
    unit            text,
    amount          numeric
);