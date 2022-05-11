CREATE TABLE company
(
    id   integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

INSERT INTO company
VALUES (1, 'BMV'),
       (2, 'VAZ'),
       (3, 'GAZ'),
       (4, 'UAZ'),
       (5, 'VOLGA');

CREATE TABLE person
(
    id         integer NOT NULL,
    name       character varying,
    company_id integer references company (id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

INSERT INTO person
VALUES (1, 'Vasya', 1),
       (2, 'Petya', 2),
       (3, 'Anna', 3),
       (4, 'Sveta', 4),
       (5, 'Masha', 5),
       (6, 'Kirill', 2),
       (7, 'Oleg', 5);