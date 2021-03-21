use storefront;
DROP FUNCTION IF EXISTS noOfOrderInMonth;

#Create a function to calculate number of orders in a month. 
#Month and year will be input parameter to function.

delimiter //

CREATE FUNCTION noOfOrderInMonth ( noOFMonth int , noOfYear int)
RETURNS int 
BEGIN
DECLARE orders INT;
SELECT count(*) INTO orders
FROM ordertable
WHERE MONTH(ordertable.orderdate) = noOFMonth AND YEAR(ordertable.orderdate) = noOfYear;
RETURN orders;
END//


delimiter ;

SELECT noOfOrderInMonth(3 , 2021);
SELECT noOfOrderInMonth(2 , 2021);

#Create a function to return month in a year having maximum orders. Year will be input parameter.
DROP FUNCTION IF EXISTS monthWithMaximumNoOfOrders;

delimiter //

CREATE FUNCTION monthWithMaximumNoOfOrders ( noOfYear int)
RETURNS int 
BEGIN
DECLARE maxMonth INT;
SELECT max(noOfOrderInMonth) INTO maxMonth
FROM 
(SELECT count(*) AS noOfOrderInMonth , MONTH(orderdate) AS ordermonth
FROM ordertable
WHERE YEAR(ordertable.orderdate) = noOfYear
GROUP BY ordermonth)orders;
RETURN maxMonth;
END//


delimiter ;

SELECT monthWithMaximumNoOfOrders(2021);
