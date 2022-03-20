create table dnkcodes
(
    id   serial primary key,
    code text
);

create table animals
(
    id   serial primary key,
    name varchar(255)
);

create table dnkcodes_animals
(
    id         serial primary key,
    id_dnkcode int references dnkcodes (id) unique,
    id_animal  int references animals (id) unique
);

insert into dnkcodes(code)
values ('qwerty123'),
       ('asdfg456');
insert into animals(name)
values ('Murka'),
       ('Timka');

insert into dnkcodes_animals(id_dnkcode, id_animal)
values (1, 1),
       (2, 2);