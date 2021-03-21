#Identify the columns require indexing in order, product, category tables and create indexes.


CREATE INDEX producttable_title_idx
ON producttable (title);


CREATE INDEX producttable_price_idx
ON producttable (price);


CREATE INDEX categorytable_title_idx
ON categorytable (title);


CREATE INDEX subcategorytable_title_idx
ON subcategorytable (title);


CREATE INDEX ordertable_orderdate_idx
ON ordertable (orderdate);


CREATE INDEX ordertable_quantity_idx
ON ordertable (quantity);