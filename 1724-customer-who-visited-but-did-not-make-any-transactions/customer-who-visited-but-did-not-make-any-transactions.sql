# Write your MySQL query statement below
SELECT V.customer_id,Count(V.visit_id) AS count_no_trans FROM Visits V 
LEFT JOIN Transactions T ON V.visit_id = T.visit_id 
where T.visit_id is null Group By V.Customer_id;