# Write your MySQL query statement below
select Employee.name, Bonus.bonus from Employee
Left Join Bonus on Employee.empId = Bonus.empId
where bonus < 1000 or bonus is Null;