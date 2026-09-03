# Write your MySQL query statement below
select  b.contest_id , Round(count(a.user_id) * 100/ (select count(*) from Users),2) As percentage From Users a 
inner Join  Register b on a.user_id = b.user_id Group By b.contest_id Order By percentage desc, b.contest_id asc ;