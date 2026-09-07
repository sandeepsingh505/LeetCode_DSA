# Write your MySQL query statement below
select  employee_id ,department_id From Employee a where primary_flag = 'Y' OR (select count(*) from employee b where a.employee_id = b.employee_id) = 1;