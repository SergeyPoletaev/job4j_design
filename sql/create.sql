create table roles
(
    id   serial primary key,
    name text
);

create table rules
(
    id   serial primary key,
    name text
);

create table roles_rules
(
    id      serial primary key,
    id_role int references roles (id),
    id_rule int references rules (id)
);

create table users
(
    id      serial primary key,
    name    text,
    id_role int references roles (id)
);

create table categories
(
    id   serial primary key,
    name text
);

create table stats
(
    id   serial primary key,
    name text
);

create table items
(
    id          serial primary key,
    name        text,
    id_user     int references users (id),
    id_category int references categories (id),
    id_state    int references stats (id)
);

create table comments
(
    id      serial primary key,
    name    text,
    id_item int references items (id)
);

create table attaches
(
    id      serial primary key,
    name    text,
    id_item int references items (id)
);