# Write your MySQL query statement below
select activity_date as day,count(distinct user_id) As active_users from Activity 
where activity_date Between '2019-06-28' And '2019-07-27' Group By activity_date;