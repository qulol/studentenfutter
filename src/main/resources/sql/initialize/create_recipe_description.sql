-- auto-generated definition
create table if not exists recipe_description
(
    id_recipe_description integer
        constraint recipe_description_pk
            primary key autoincrement,
    id_recipe             integer,
    id                    integer,
    description           text
);