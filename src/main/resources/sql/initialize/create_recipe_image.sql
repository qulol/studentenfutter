-- auto-generated definition
create table if not exists recipe_image
(
    id_recipe_image integer
        constraint recipe_image_pk
            primary key autoincrement,
    id_recipe       integer
        references recipe,
    content_type    text,
    content         blob
);
