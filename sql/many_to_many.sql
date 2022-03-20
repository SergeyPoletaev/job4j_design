create table doctors
(
    id   serial primary key,
    name varchar(255)
);

create table pacients
(
    id   serial primary key,
    name varchar(255)
);

create table doctors_pacients
(
    id         serial primary key,
    id_doctor  int references doctors (id),
    id_pacient int references pacients (id)
);

insert into doctors(name)
values ('Dantist'),
       ('GP');

insert into pacients(name)
values ('Anna'),
       ('Olga');

insert into doctors_pacients(id_doctor, id_pacient)
values (1, 1),
       (1, 2),
       (2, 2);