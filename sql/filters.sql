create table type
(
    id   serial primary key,
    name text
);

create table product
(
    id           serial primary key,
    name         text,
    type_id      int references type (id),
    expired_date date,
    price        float
);

insert into type (name)
values ('Сыр'),
       ('Молоко'),
       ('Мясо');

insert into product(name, type_id, expired_date, price)
values ('Сыр моцарелла', 1, '24.03.2022', 145),
       ('Сыр российский', 1, '15.02.2022', 224),
       ('Сыр плавленный', 1, '18.01.2022', 597),
       ('Перемороженный сыр', 1, '27.03.2022', 99),
       ('Замороженное молоко', 2, '29.03.2022', 56),
       ('Сгущеное молоко', 2, '30.05.2022', 48),
       ('Топленое молоко', 2, '27.03.2022', 97),
       ('Котлеты', 3, '11.01.2019', 462);

select type.name, product.name, expired_date, price
from type
         join product on type.id = product.type_id
where type.name = 'Сыр';

select name, expired_date, price
from product
where name like '%мороженное%';

select name, expired_date, price
from product
where expired_date < current_date;

select name, expired_date, price
from product
where price = (select max(price) from product);

select type.name, count(type_id)
from type
         join product on type.id = product.type_id
group by type_id, type.name;

select product.name, expired_date, price
from type
         join product on type.id = product.type_id
where type.name = 'Сыр'
   or type.name = 'Молоко';

select type.name, count(type_id)
from type
         join product on type.id = product.type_id
group by type_id, type.name
having count(type_id) < 10;

select type.name, product.name
from type
         join product on type.id = product.type_id
order by type.name;