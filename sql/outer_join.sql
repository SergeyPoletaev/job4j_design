create table departments
(
    name text primary key
);

create table emploers
(
    name             text,
    name_departments text references departments (name)
);

insert into departments(name)
values ('FSB'),
       ('FBI'),
       ('MVD'),
       ('MO'),
       ('DDF');

insert into emploers (name, name_departments)
values ('Ivan', 'FSB'),
       ('Anna', 'FBI'),
       ('Sveta', 'MVD'),
       ('Peter', null),
       ('Olga', null);

select *
from departments
         left join emploers e on departments.name = e.name_departments;
select *
from departments
         right join emploers e on departments.name = e.name_departments;
select *
from departments
         full join emploers e on departments.name = e.name_departments;
select *
from departments
         cross join emploers;

select departments.name
from departments
         left join emploers e on departments.name = e.name_departments
where name_departments is null;

select *
from departments d
         left join emploers e on d.name = e.name_departments;
select d.name, e.name, name_departments
from emploers e
         right join departments d on d.name = e.name_departments;

create table teens
(
    name   text,
    gender varchar(1)
);

insert into teens (name, gender)
values ('Anna', 'F'),
       ('Sveta', 'F'),
       ('Peter', 'M'),
       ('Kolya', 'M');

select *
from teens t1
         cross join teens t2
where t1.gender != t2.gender;