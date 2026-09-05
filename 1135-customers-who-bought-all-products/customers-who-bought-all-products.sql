# Write your MySQL query statement below
select a.customer_id From Customer a  Join Product b 
Group By a.customer_id  Having count(distinct a.product_key) = count(distinct b.product_key);