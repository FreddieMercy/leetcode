# Write your MySQL query statement below
select * from
(select round(sqrt((rx-lx)*(rx-lx) + (ry-ly)*(ry-ly)), 2) as shortest from (

    (select x as lx, y as ly from point_2d) as l join
    (select x as rx, y as ry from point_2d) as r on concat(l.lx,l.ly) != concat(r.rx,r.ry)

) ) as t order by shortest limit 1;