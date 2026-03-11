# Write your MySQL query statement below
WITH max_salary AS (SELECT departmentId, MAX(salary) AS max_sal
FROM Employee GROUP BY departmentId)
SELECT d.name AS Department, e.name AS Employee,e.salary AS Salary
FROM Employee e
JOIN max_salary m ON e.departmentId = m.departmentId AND e.salary = m.max_sal JOIN Department d ON e.departmentId = d.id;