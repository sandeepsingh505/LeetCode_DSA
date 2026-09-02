# Write your MySQL query statement below
select product.product_name, Sales.year,sales.price from sales Left Join 
Product on sales.product_id = product.product_id;