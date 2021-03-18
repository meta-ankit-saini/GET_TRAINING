#Display Recent 50 Orders placed (Id, Order Date, Order Total).
SELECT  ordertable.orderid , producttable.title AS Name, ordertable.orderdate, ordertable.quantity * producttable.price AS Total
FROM ordertable , producttable
WHERE ordertable.productid = producttable.productid
ORDER BY orderdate DESC
LIMIT 5;

#Display 10 most expensive Orders.
SELECT producttable.title AS Name, ordertable.orderid , ordertable.orderdate, ordertable.quantity * producttable.price AS Total
FROM ordertable , producttable
WHERE ordertable.productid = producttable.productid
ORDER BY ordertable.quantity * producttable.price DESC
LIMIT 5;

#Display all the Orders which are placed more than 10 days old and one or more items from those 
#orders are still not shipped.
SELECT producttable.title AS Name, ordertable.orderid , ordertable.orderdate, ordertable.quantity * producttable.price AS Total
FROM ordertable , producttable
WHERE ordertable.productid = producttable.productid AND ordertable.orderdate >= curdate() -10 AND ordertable.shipped = FALSE
ORDER BY ordertable.orderdate;



#Display list of shoppers which haven't ordered anything since last month.
SELECT shoppertable.name AS Name, ordertable.orderid AS ID 
FROM ordertable , shoppertable
WHERE ordertable.shopperid = shoppertable.shopperid 
AND ordertable.shopperid NOT IN (SELECT ordertable.shopperid FROM ordertable WHERE ordertable.orderdate >= curdate() - 30)
ORDER BY ordertable.orderdate;



#Display list of shopper along with orders placed by them in last 15 days. 
SELECT shoppertable.name AS Name, shoppertable.shopperid AS ID , ordertable.orderid 
, ordertable.orderdate , producttable.title AS ProductName 
FROM ordertable , shoppertable , producttable
WHERE ordertable.shopperid = shoppertable.shopperid AND  ordertable.productid = producttable.productid
AND ordertable.shopperid IN (SELECT ordertable.shopperid FROM ordertable WHERE ordertable.orderdate >= curdate() - 15)
ORDER BY ordertable.orderdate;



#Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1020))
SELECT producttable.title AS Name, ordertable.orderid , ordertable.orderdate, ordertable.quantity * producttable.price AS Total
FROM ordertable , producttable
WHERE ordertable.productid = producttable.productid and shipped = TRUE;


#Display list of order items along with order placed date which fall between Rs 20 to Rs 50 price.
SELECT producttable.title AS Name, ordertable.orderid , ordertable.orderdate, ordertable.quantity * producttable.price AS Total
FROM ordertable , producttable
WHERE ordertable.productid = producttable.productid
ORDER BY ordertable.quantity * producttable.price BETWEEN 500 AND 1000; 

