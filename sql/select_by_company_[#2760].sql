-- 1. В одном запросе получить:
-- - имена всех person, которые не состоят в компании с id = 5;
-- - название компании для каждого человека

-- var.1
select p.name, c.name
from person p
         join (select * from company c where c.id != 5) c on p.company_id = c.id;
-- var.2
select p.name, c.name
from person p
         join company c on p.company_id = c.id
where c.id != 5;

-- 2. Необходимо выбрать название компании с максимальным количеством человек + количество человек в этой компании
-- (нужно учесть, что таких компаний может быть несколько)

select company.name, cc.cnt
from (select *
      from (select company_id, count(company_id) as cnt
            from person
            group by company_id) as c
      where cnt = (select max(c.cnt)
                   from (select company_id, count(company_id) as cnt
                         from person
                         group by company_id) as c)) as cc
         join company on cc.company_id = company.id;


