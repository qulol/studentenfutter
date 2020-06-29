-- auto-generated definition
create table if not exists recipe_season
(
    id_recipe_season integer
        constraint recipe_season_pk
            primary key autoincrement,
    id_recipe        integer
        references recipe,
    name             text
);
