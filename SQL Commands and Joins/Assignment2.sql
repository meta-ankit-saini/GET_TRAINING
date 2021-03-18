INSERT INTO shoppertable(name, shippingaddress) 
VALUES  ("ankit",  "Jaipur"),
        ("amit",  "Jodhpur"),
        ("ajay", "Udaipur"),
        ("abhay", "dausa"),
        ("anuj", "sawai");
        
select * from shoppertable;



INSERT INTO producttable(price, title) 
VALUES  (500 , "Pen Drive"),
        (100 , "USB"),
        (400 , "SD card"),
        (600 , "Mobile Charger"),
        (1500 , "Cricket Bat"),
        (500 , "Football"),
        (100 , "Teniss Ball"),
        (400 , "Shirt"),
        (600 , "Jeans"),
        (1500 , "T-Shirt"),
        (1500 , "Watch"),
        (1500 , "Shoes");
        
select * from producttable;


INSERT INTO categorytable(title)
VALUES  ("Accessories"),
        ("Electronics"),
        ("Sports"),
        ("Fashion"),
        ("Food");
        
select * from categorytable;

INSERT INTO subcategorytable(title , categoryid , productid)
VALUES  ("Computer Accessories" , 1 , 1),
        ("Computer Accessories" , 1 , 2),
        ("Mobile Acessories" , 2 , 3),
        ("Mobile Acessories" , 2 , 4),
        ("Cricket" , 3 , 5),
        ("Football" , 3 , 6),
        ("Tennis" , 3 , 7),
        ("Men's Fashion" , 4 , 8),
        ("Men's Fashion" , 4 , 9),
        ("Women's Fashion" , 4 , 10),
        ("Wearable" , null , 11),
        (null , 4 , 12);
        
select * from subcategorytable;



INSERT INTO imagetable(title, productid)
VALUES  ("image1" , 1),
        ("image2" , 2),
        ("image3" , 3),
        ("image4" , 2),
        ("image5" , 3),
        ("image6" , 1),
        ("image7" , 1),
        ("image8" , 4),
        ("image9" , 6),
        ("image10" , 8),
        ("image11" , 9),
        ("image12" , 6);
        
SELECT * from imagetable;

INSERT INTO ordertable(quantity , productid ,shopperid , orderdate , shipped)
VALUES (2, 1 , 1 , '2021-02-22' , TRUE),
       (1, 2 , 2 , '2021-02-27' , TRUE),
       (6, 5 , 4 , '2021-02-25' , FALSE),
       (5, 8 , 4 , '2021-03-05' , TRUE),
       (4, 3 , 3 , '2021-03-10' , FALSE),
       (3, 6 , 4 , '2021-03-12' , TRUE),
       (1, 5 , 5 , '2021-03-13' , FALSE),
       (2, 3 , 2 , '2021-03-15' , TRUE);
       
SELECT * from ordertable;


INSERT INTO stocktable(productid , quantity)
VALUES  (1 , 110),
        (2 , 23),
        (3 , 121),
        (4 , 35),
        (5 , 116),
        (6 , 12),
        (7 , 78),
        (8 , 9),
        (9 , 77),
        (10 ,9 ),
        (11 , 7),
        (12 , 5);
       
 SELECT * from stocktable;      
       
       
#Display Id, Title, Category Title, Price of the products which are Active and recently added products should be at top.
     
SELECT  producttable.productid AS ProductID , producttable.title AS Name, subcategorytable.title AS Category, producttable.price AS Price     
FROM producttable , subcategorytable
WHERE  producttable.productid =  subcategorytable.productid
ORDER BY producttable.productid DESC;
  
  
#Display the list of products which don't have any images.
SELECT  producttable.productid AS ProductID , producttable.title AS Name 
FROM producttable , imagetable
WHERE producttable.productid NOT In  (SELECT DISTINCT productid FROM imagetable);


#Display all Id, Title and Parent Category Title for all the Categories listed, sorted by Parent Category Title and then Category Title. 
#If Category is top category then Parent Category Title column should display “Top Category” as value.
SELECT subcategorytable.subcategoryid  AS ID , subcategorytable.title AS TITLE , IFNULL(categorytable.title , "Top Category") AS Parent_Category      
FROM  subcategorytable LEFT JOIN categorytable 
ON (subcategorytable.categoryid = categorytable.categoryid)
ORDER BY categorytable.title , subcategorytable.title;


#Display Id, Title, Parent Category Title of all the leaf Categories (categories which are not parent of any other category)
SELECT  categorytable.categoryid  AS ID , categorytable.title AS Name 
FROM  categorytable LEFT JOIN  subcategorytable
ON (categorytable.categoryid = subcategorytable.categoryid)
WHERE subcategorytable.categoryid IS null;


#Display Product Title, Price & Description which falls into particular category Title 
SELECT  producttable.productid AS ProductID , producttable.title AS Name , producttable.price AS Price    
FROM producttable  , categorytable , subcategorytable
WHERE  producttable.productid = subcategorytable.productid 
AND subcategorytable.categoryid = categorytable.categoryid 
AND categorytable.title = "Sports";

#Display the list of Products whose Quantity on hand (Inventory) is under 50.
SELECT producttable.productid AS ProductID ,producttable.title AS Name , stocktable.quantity AS Quantity
FROM producttable , stocktable  
WHERE producttable.productid = stocktable.productid AND stocktable.quantity < 50;





