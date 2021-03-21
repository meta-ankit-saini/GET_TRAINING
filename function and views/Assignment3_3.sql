#Display Shopper’s information along with number of orders he/she placed during last 30 days.
SELECT name AS Name , shoppertable.shopperid as ID , shippingaddress AS Address
FROM shoppertable LEFT JOIN ordertable
ON shoppertable.shopperid = ordertable.shopperid 
WHERE shoppertable.shopperid NOT IN (SELECT DISTINCT ordertable.shopperid FROM ordertable
WHERE ordertable.orderdate >= curdate() -30);

#Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.
SELECT shoppertable.name AS Name , shoppertable.shopperid as ID , SUM(ordertable.quantity * producttable.price) AS Revenue
FROM ((shoppertable 
LEFT JOIN ordertable ON shoppertable.shopperid = ordertable.shopperid) 
LEFT JOIN producttable ON ordertable.productid  = producttable.productid)
WHERE ordertable.orderdate >= (DATE_SUB( CURDATE(), INTERVAL 30 DAY))
GROUP BY shoppertable.name
ORDER BY ordertable.quantity * producttable.price DESC
LIMIT 10; 

#Display top 20 Products which are ordered most in last 60 days along with numbers.
SELECT producttable.title AS Title , producttable.productid as ID , SUM(ordertable.quantity) AS Ordered_Number
FROM ordertable
LEFT JOIN producttable ON ordertable.productid  = producttable.productid
WHERE ordertable.orderdate >= (DATE_SUB( CURDATE(), INTERVAL 2 MONTH))
GROUP BY ordertable.productid
ORDER BY SUM(ordertable.quantity) DESC
LIMIT 20;

#Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.
SELECT month(ordertable.orderdate) as Month, SUM(ordertable.quantity * producttable.price) AS Revenue
FROM ordertable 
LEFT JOIN producttable ON ordertable.productid  = producttable.productid
WHERE ordertable.orderdate >= (DATE_SUB( CURDATE(), INTERVAL 6 MONTH))
GROUP BY Month
ORDER BY ordertable.orderdate;


#Mark the products as Inactive which are not ordered in last 90 days.

#select status from producttable;

SET SQL_SAFE_UPDATES = 0;

UPDATE producttable
SET producttable.status = "INACTIVE"
WHERE producttable.productid NOT IN ( 
    SELECT DISTINCT ordertable.productid 
    FROM ordertable
    WHERE ordertable.orderdate >= (DATE_SUB( CURDATE(), INTERVAL 90 DAY))
    );

#select status from producttable;


#Given a category search keyword, display all the Products present in this category/categories.
SELECT producttable.title AS Title, subcategorytable.title as Category 
FROM producttable INNER JOIN subcategorytable
ON subcategorytable.productid = producttable.productid
WHERE subcategorytable.title LIKE "%Acc%" ;


#setting returned true
UPDATE ordertable
SET ordertable.returned = true
WHERE ordertable.productid between 0 and 5;

#Display top 10 Items which were cancelled most.
SELECT producttable.title AS Product_Name, count(ordertable.productid) as Cancelled_Time
FROM producttable
LEFT JOIN ordertable
ON producttable.productid = ordertable.productid
WHERE ordertable.returned = true
GROUP BY ordertable.productid 
ORDER BY Cancelled_Time DESC
LIMIT 10;