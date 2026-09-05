# Write your MySQL query statement below
-- using dense rank()
select max(salary) as SecondHighestSalary From(select distinct salary, dense_rank()over(order by salary desc)as rnk from employee) employee where rnk = 2;