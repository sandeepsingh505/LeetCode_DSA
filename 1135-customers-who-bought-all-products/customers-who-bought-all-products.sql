# Write your MySQL query statement below
select customer_id from Customer Group By customer_id Having count(distinct product_key) = (select count(*) from Product) ;