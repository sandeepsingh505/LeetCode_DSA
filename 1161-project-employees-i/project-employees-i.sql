# Write your MySQL query statement below
select a.project_id , Round(sum(b.experience_years)/count(a.employee_id),2) As average_years From Project a 
Left Join Employee b on a.employee_id = b.employee_id Group By a.project_id;