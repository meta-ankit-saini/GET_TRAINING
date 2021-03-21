#Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.
Select producttable.productid AS ID , producttable.title AS Title ,count(subcategorytable.productid ) AS Count_Category
From producttable INNER JOIN subcategorytable 
ON producttable.productid = subcategorytable.productid
GROUP BY subcategorytable.productid HAVING count(subcategorytable.productid ) > 1;

#Display Count of products as per below price range:
select newtable.range , count(*) FROM
(select case 
when price between 0 and 100 then '0-100'
when price between 101 and 500 then '101-500'
else 'Above 500'
end as 'Range'
from producttable)newtable
group by newtable.range;


#Display the Categories along with number of products under each category.
SELECT  subcategorytable.productid AS ID , subcategorytable.title AS Title ,count(producttable.productid ) AS No_Of_Product
From subcategorytable INNER JOIN producttable 
ON producttable.productid = subcategorytable.productid
GROUP BY producttable.productid;