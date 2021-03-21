#Create a view displaying the order information (Id, Title, Price, Shopper’s name, Email,
#Orderdate, Status) with latest ordered items should be displayed first for last 60 days.

CREATE VIEW order_view
AS 
SELECT ordertable.orderid ,ordertable.quantity , producttable.title, producttable.price, shoppertable.name,  ordertable.orderdate, ordertable.shipped
FROM ((shoppertable 
LEFT JOIN ordertable ON shoppertable.shopperid = ordertable.shopperid) 
LEFT JOIN producttable ON ordertable.productid  = producttable.productid)
WHERE ordertable.orderdate >= (DATE_SUB( CURDATE(), INTERVAL 60 DAY))
ORDER BY ordertable.orderdate DESC;


#Use the above view to display the Products(Items) which are in ‘shipped’ state.
SELECT title as Product 
FROM order_view
WHERE shipped IS true;

#Use the above view to display the top 5 most selling products.
SELECT title AS Product , SUM(quantity) as Quantity
FROM order_view 
GROUP BY title
ORDER BY SUM(quantity) DESC
LIMIT 10;