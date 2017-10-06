SELECT
    SUM(insurance.TIV_2016) AS TIV_2016
FROM
    insurance
WHERE
    insurance.TIV_2015 IN
    (
      SELECT
        TIV_2015
      FROM
        insurance
      GROUP BY TIV_2015
      HAVING COUNT(*) > 1
    )
    AND CONCAT(LAT, LON) IN
    (
      SELECT
        CONCAT(LAT, LON)
      FROM
        insurance
      GROUP BY LAT , LON
      HAVING COUNT(*) = 1
    )
;


/*

# Write your MySQL query statement below
select ROUND(sum(b.TIV_2016), 2) as TIV_2016 from 

(select * from 
 
 (select * from insurance group by LAT having count(*) = 1) 
 
 as a group by a.LON having count(*) = 1) as b
 
 group by b.TIV_2015 having count(*) > 1;

*/