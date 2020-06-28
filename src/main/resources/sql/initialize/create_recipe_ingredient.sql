-- auto-generated definition
create table if not exists recipe_ingredient
(
    id_recipe_entity integer
        primary key autoincrement,
    id_recipe        integer
        references recipe,
    amount           numeric,
    unit             text,
    ingredient       text
);

