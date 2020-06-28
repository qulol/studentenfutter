-- auto-generated definition
create table if not exists recipe
(
    id_recipe integer
        primary key autoincrement,
    author    text,
    name      VARCHAR,
    category  text
);
