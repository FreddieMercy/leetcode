# Write your MySQL query statement below
#select distinct x.Num as ConsecutiveNums from Logs x, Logs y, Logs z where (x.Id + 1 = y.Id and x.Num = y.Num) and (x.Id + 2 = z.Id and x.Num = z.Num);