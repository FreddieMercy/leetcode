# Write your MySQL query statement below

select c.Name as Name from (
    select * from Vote group by CandidateId Order By Count(*) Desc Limit 1
) as p, Candidate as c where p.CandidateId = c.id;