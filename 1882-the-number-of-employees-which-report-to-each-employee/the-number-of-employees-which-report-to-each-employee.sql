# Write your MySQL query statement below
select a.employee_id,a.name ,count(b.employee_id) as reports_count,Round(avg(b.age),0) as average_age From employees a Join Employees b on a.employee_id = b.reports_to 
Group by a.employee_id,a.name order by a.employee_id;