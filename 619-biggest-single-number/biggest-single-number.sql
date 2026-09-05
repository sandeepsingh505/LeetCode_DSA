# Write your MySQL query statement below
select max(num) as num From(Select num  from MyNumbers Group By num Having count(*) = 1) MyNumbers;