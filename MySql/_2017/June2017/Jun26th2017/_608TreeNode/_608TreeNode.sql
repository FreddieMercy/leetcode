# Write your MySQL query statement below

select id, case
                 when tree.id in (select e.id from tree e where e.p_id is NULL)
                 then
                    "Root"
            
                 when tree.id in (select t.id from tree t where t.id =tree.id and t.id in (select s.p_id from tree s))
                 then
                    "Inner"
                 else
                    "Leaf"
           end as Type from tree order by id;