insert into rules(name)
values ('developer'),
       ('reporter');

insert into roles(name)
values ('admin'),
       ('worker');

insert into roles_rules(id_role, id_rule)
values (1, 1),
       (2, 2);

insert into users(name, id_role)
values ('Anna', 1),
       ('Sveta', 2);

insert into categories(name)
values ('high'),
       ('medium'),
       ('low');

insert into stats(name)
values ('open'),
       ('close');

insert into items(name, id_user, id_category, id_state)
values ('item1', 1, 1, 2),
       ('item2', 1, 2, 1);

insert into comments(name, id_item)
values ('qwerty java', 2);

insert into attaches(name, id_item)
values ('file_example', 1);