# Write your MySQL query statement below
with cte as(
    select num,
    lead(num, 1) over(order by id) num1,
    lead(num, 2) over(order by id) num2
    from logs
)
select DISTINCT num as consecutiveNums
from cte
where num = num1 and num1= num2
