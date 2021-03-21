drop database storefront;
create database storefront;

use storefront;

create table shoppertable(
    name varchar(100) not null,
    shopperid int not null auto_increment primary key,
    shippingaddress varchar(100) not null
);

create table producttable(
    productid int not null auto_increment primary key,
    title varchar(100) not null,
    price double not null,
    status VARCHAR(10) DEFAULT "ACTIVE" 
);

create table categorytable(
    title varchar(100) not null,
    categoryid int not null auto_increment primary key
    
);

create table subcategorytable(
    subcategoryid int not null auto_increment primary key,
    title varchar(100) ,
    categoryid int ,
    productid int not null,
    FOREIGN KEY (categoryid) REFERENCES categorytable(categoryid),
    FOREIGN KEY (productid) REFERENCES producttable(productid)
);

create table imagetable(
    imageid int not null auto_increment primary key,
    title varchar(100) not null,
    productid int not null,
    FOREIGN KEY (productid) REFERENCES producttable(productid)
);



create table ordertable(
    orderid int not null auto_increment primary key,
    quantity int not null,
    productid int not null,
    shopperid int not null,
    orderdate DATE not null,
    shipped bool not null,
    returned bool DEFAULT false , 
    FOREIGN KEY (productid) REFERENCES producttable(productid),
    FOREIGN KEY (shopperid) REFERENCES shoppertable(shopperid)
);


create table stocktable(
    stockid int not null auto_increment primary key,
    productid int not null,
    quantity int not null,
    FOREIGN KEY (productid) REFERENCES producttable(productid)
);

INSERT INTO shoppertable(name, shippingaddress) 
VALUES  ("ankit",  "Jaipur"),
        ("amit",  "Jodhpur"),
        ("ajay", "Udaipur"),
        ("abhay", "dausa"),
        ("anuj", "sawai"),
        ("abhishek" , "Ajamer");

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

INSERT INTO categorytable(title)
VALUES  ("Accessories"),
        ("Electronics"),
        ("Sports"),
        ("Fashion"),
        ("Food");
        
INSERT INTO subcategorytable(title , categoryid , productid)
VALUES  ("Computer Accessories" , 1 , 1),
        ("Computer Accessories" , 1 , 2),
        ("Mobile Accessories" , 1 , 2),
        ("Mobile Accessories" , 2 , 3),
        ("Mobile Accessories" , 2 , 4),
        ("Cricket" , 3 , 5),
        ("Football" , 3 , 6),
        ("Tennis" , 3 , 7),
        ("Men's Fashion" , 4 , 8),
        ("Women's Fashion" , 4 , 8),
        ("Men's Fashion" , 4 , 9),
        ("Women's Fashion" , 4 , 9),
        ("Women's Fashion" , 4 , 10),
        ("Men's Fashion" , 4 , 10),
        ("Wearable" , null , 11),
        (null , 4 , 12);
        
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
        
INSERT INTO ordertable(quantity , productid ,shopperid , orderdate , shipped)
VALUES (1, 11 , 1 , '2021-01-22' , TRUE),
       (2, 1 , 1 , '2021-02-22' , TRUE),
       (1, 2 , 2 , '2021-02-27' , TRUE),
       (6, 5 , 4 , '2021-02-25' , FALSE),
       (5, 8 , 4 , '2021-03-05' , TRUE),
       (4, 3 , 3 , '2021-03-10' , FALSE),
       (3, 6 , 4 , '2021-03-12' , TRUE),
       (1, 5 , 5 , '2021-03-13' , FALSE),
       (2, 3 , 2 , '2021-03-15' , TRUE);
       
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