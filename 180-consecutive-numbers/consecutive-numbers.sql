# Write your MySQL query statement below
-- JOin ke sath solve kr raha hoon 

select  distinct a.num as ConsecutiveNums From Logs a Join 
Logs b on b.id = a.id + 1 
Join Logs c on c.id = a.id + 2 
where a.num = b.num And b.num = c.num ;