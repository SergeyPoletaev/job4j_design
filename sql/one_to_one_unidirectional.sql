create table diplomas
(
    id     serial primary key,
    number int
);

create table pupils
(
    id         serial primary key,
    name       varchar(255),
    id_diploma int references diplomas (id) unique
);

insert into diplomas(number)
values (123),
       (456);

insert into pupils(name, id_diploma)
values ('Anna', 1),
       ('Peter', 2);