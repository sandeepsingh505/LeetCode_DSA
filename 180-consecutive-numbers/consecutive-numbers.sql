# Write your MySQL query statement below
-- now solving using lag and lead 
select distinct num as ConsecutiveNums From (select num,lag(num,1)over(order by id) as Prev1,lag(num,2)over(order by id)as Prev2 From Logs)Logs where num = Prev1 And num= Prev2;