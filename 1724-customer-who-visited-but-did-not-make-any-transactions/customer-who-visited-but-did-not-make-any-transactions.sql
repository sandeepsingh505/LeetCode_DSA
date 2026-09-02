# Write your MySQL query statement below
select visits.customer_id ,count(*) as count_no_trans from visits
left join Transactions on visits.visit_id = Transactions.visit_id
where transactions.visit_id is Null Group By Visits.customer_id;