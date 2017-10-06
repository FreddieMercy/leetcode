# Write your MySQL query statement below
select id as id, count(*) as num from(
select * from
        (select requester_id as id from request_accepted) as a union all #union -> is unique (set), union all -> is all (bag)
        (select accepter_id from request_accepted)
) as c group by id order by num desc limit 1 ;