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

select c.name, count(*)
from person p
         join company c
              on p.company_id = c.id
group by c.name
having count(*) = (select count(company_id) as cnt
                   from person
                   group by company_id
                   order by cnt desc
                   limit 1);
