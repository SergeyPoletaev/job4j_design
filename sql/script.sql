create table users
(
    id      serial primary key,
    name    varchar(255),
    age     integer,
    status  boolean,
    address text
);

insert into users(name, age, status, address)
values ('anna', 12, true, '141320, Peresvet');

update users
set age    = 20,
    status = false;

delete
from users;