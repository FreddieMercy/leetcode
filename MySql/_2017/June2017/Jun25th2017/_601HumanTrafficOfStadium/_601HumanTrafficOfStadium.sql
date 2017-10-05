# Write your MySQL query statement below
select distinct x.id, x.date, x.people from (select * from stadium where people >=100) x, (select * from stadium where people >=100) y, (select * from stadium where people >=100) z where (x.id = y.id+1 and x.id = z.id+2) or (x.id = y.id-1 and x.id = z.id-2) or (x.id = y.id-1 and x.id = z.id+1) order by id;
