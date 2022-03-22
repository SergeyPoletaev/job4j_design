create table owners
(
    id   serial primary key,
    name text
);

create table aircrafts
(
    id       serial primary key,
    model    text,
    range    int,
    id_owner int references owners (id)
);

insert into owners (name)
values ('Aeroflot'),
       ('Siberia'),
       ('Pobeda');

insert into aircrafts (model, range, id_owner)
values ('SU9', 6000, 1),
       ('SU10', 3500, 2),
       ('SU11', 11000, 3);

select *
from owners as o
         join aircrafts as a on o.id = a.id_owner;

select o.id, o.name, a.range
from owners as o
         join aircrafts as a on o.id = a.id_owner;

select a.model, o.name
from owners as o
         join aircrafts as a on o.id = a.id_owner;

