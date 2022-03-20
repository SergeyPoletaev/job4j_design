create table cats
(
    id   serial primary key,
    name varchar(255)
);

create table kittens
(
    id     serial primary key,
    name   varchar(255),
    id_cat int references cats (id)
);

insert into cats(name)
values ('Murka');

insert into kittens(name, id_cat)
values ('Timka', 1);