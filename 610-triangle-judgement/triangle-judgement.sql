# Write your MySQL query statement below
select x,y,z, case when (x+y) > z And (y+z) > x And (z+x) > y Then 'Yes' Else 'No' End as Triangle 
From Triangle;