# Write your MySQL query statement below
select d.class from (select distinct * from courses) as d group by class having count(*) >=5;