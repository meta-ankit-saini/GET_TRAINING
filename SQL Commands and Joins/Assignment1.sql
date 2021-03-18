drop database storefront;
create database storefront;
show databases;


use storefront;
show tables;


create table shoppertable(
    name varchar(100) not null,
    shopperid int not null auto_increment primary key,
    shippingaddress varchar(100) not null
);

create table producttable(
    productid int not null auto_increment primary key,
    title varchar(100) not null,
    price double not null
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
    FOREIGN KEY (productid) REFERENCES producttable(productid),
    FOREIGN KEY (shopperid) REFERENCES shoppertable(shopperid)
);


create table stocktable(
    stockid int not null auto_increment primary key,
    productid int not null,
    quantity int not null,
    FOREIGN KEY (productid) REFERENCES producttable(productid)
);


drop table stocktable;
drop table ordertable;
drop table imagetable;
drop table subcategorytable;
drop table categorytable;
drop table producttable;

show tables;


create table producttable(
    productid int not null auto_increment primary key,
    title varchar(100) not null,
    price double not null
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
    FOREIGN KEY (productid) REFERENCES producttable(productid),
    FOREIGN KEY (shopperid) REFERENCES shoppertable(shopperid)
);


create table stocktable(
    stockid int not null auto_increment primary key,
    productid int not null,
    quantity int not null,
    FOREIGN KEY (productid) REFERENCES producttable(productid)
);

show tables;