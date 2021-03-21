#Create a Stored procedure to retrieve average sales of each product 
#in a month. Month and year will be input parameter to function.
DROP PROCEDURE IF EXISTS avgSaleOfEachProduct;
delimiter //

CREATE PROCEDURE avgSaleOfEachProduct ( noOFMonth int , noOfYear int)
BEGIN
SELECT producttable.title AS Product , SUM(ordertable.quantity) / DAY(LAST_DAY(ordertable.orderdate)) as AverageSale 
FROM ordertable INNER JOIN 
producttable
ON ordertable.productid = producttable.productid 
WHERE MONTH(ordertable.orderdate) = noOFMonth AND YEAR(ordertable.orderdate) = noOfYear
GROUP BY producttable.title;
END//

delimiter ;

CALL avgSaleOfEachProduct(03,2021);

#Create a stored procedure to retrieve table having order detail 
#with status for a given period. Start date and end date will be 
#input parameter. Put validation on input dates like start date 
#is less than end date. If start date is greater than end date take 
#first date of month as start date.
DROP PROCEDURE IF EXISTS orderDeatail;
delimiter //

CREATE PROCEDURE orderDeatail(startDate DATE , endDate DATE)
BEGIN
IF startDate > endDate THEN
    SET startDate = DATE_SUB(DATE_ADD(LAST_DAY(endDate), INTERVAL 1 DAY), INTERVAL  1 MONTH);
    END IF;
SELECT *
FROM ordertable
WHERE orderdate >= startDate AND orderdate <= endDate;
END//

delimiter ;
CALL orderDeatail("2021-02-01","2021-03-25");