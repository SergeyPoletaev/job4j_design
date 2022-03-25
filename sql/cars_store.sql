create table engines
(
    id   serial primary key,
    name text
);

create table gearboxes
(
    id   serial primary key,
    name text
);

create table carcases
(
    id   serial primary key,
    name text
);

create table cars
(
    id         serial primary key,
    name       text,
    id_engine  int references engines (id),
    id_gearbox int references gearboxes (id),
    id_carcase int references carcases (id)
);

insert into engines (name)
values ('petrol'),
       ('diesel'),
       ('electric'),
       ('combined');

insert into gearboxes (name)
values ('mechanic'),
       ('automatic'),
       ('robot'),
       ('variate');

insert into carcases (name)
values ('sedan'),
       ('SUV'),
       ('cabriolet');

insert into cars (name, id_engine, id_gearbox, id_carcase)
values ('alpha', 1, 2, 1),
       ('beta', 1, 1, 2),
       ('gamma', 2, 2, 1),
       ('volga', 1, 1, 2),
       ('UAZ', 1, 1, 1);

select c.name as car_model, e.name as engine, gb.name as gearbox, cc.name as carecase
from cars c
         join engines e on c.id_engine = e.id
         join gearboxes gb on c.id_gearbox = gb.id
         join carcases cc on c.id_carcase = cc.id;

select e.name as not_used_engines
from engines e
         left join cars c on c.id_engine = e.id
where c.name is null;

select gb.name as not_used_gearbox
from gearboxes gb
         left join cars c on c.id_engine = gb.id
where c.name is null;

select cc.name as not_used_carecase
from carcases cc
         left join cars c on c.id_engine = cc.id
where c.name is null;