# Write your MySQL query statement below

select a.question_id as survey_log from 

(select *, Count(*) as total from survey_log group by question_id) as t, 
(select *, Count(*) as answerNum from survey_log as s where s.action = 'answer' group by question_id) as a
    
where a.question_id = t.question_id
    
order by a.answerNum / t.total Desc limit 1;