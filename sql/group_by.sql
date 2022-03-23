create table devices
(
    id    serial primary key,
    name  varchar(255),
    price float
);

create table peoples
(
    id   serial primary key,
    name varchar(255)
);

create table devices_peoples
(
    id        serial primary key,
    id_device int references devices (id),
    id_people int references peoples (id)
);

insert into devices (name, price)
values ('player', 7500),
       ('tv', 1500),
       ('phone', 15000),
       ('laptop', 3000);

insert into peoples (name)
values ('Anna'),
       ('Sveta'),
       ('Masha'),
       ('Peter');

insert into devices_peoples (id_device, id_people)
values (1, 2),
       (1, 3),
       (2, 4),
       (3, 2),
       (4, 1),
       (4, 4);

select *
from peoples
         join devices_peoples on peoples.id = devices_peoples.id_people
         join devices on devices_peoples.id_device = devices.id;

select avg(price)
from devices;

select p.name, avg(d.price)
from peoples p
         join devices_peoples dp on p.id = dp.id_people
         join devices d on dp.id_device = d.id
group by p.name;

select p.name, avg(d.price)
from peoples p
         join devices_peoples dp on p.id = dp.id_people
         join devices d on dp.id_device = d.id
group by p.name
having avg(d.price) > 5000;