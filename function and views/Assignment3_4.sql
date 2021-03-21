#Consider a form where providing a Zip Code populates associated City and State. 
#Create appropriate tables and relationships for the same and write a SQL
#query for that returns a Resultset containing Zip Code, City Names and
#States ordered by State Name and City Name.

CREATE TABLE zipcodetable(
    city VARCHAR(20) NOT NULL,
    state VARCHAR(20) NOT NULL,
    zipcode VARCHAR(6) not null PRIMARY KEY,
    CONSTRAINT CK_Zip CHECK (zipcode LIKE REPLICATE('[0-9]', 6)) 
    
);


INSERT INTO zipcodetable(city , state , zipcode)
VALUES  ("city1" , "Raj" , "303503"),
        ("city2" , "Raj" , "303504"),
        ("city3" , "Raj" , "303505"),
        ("city4" , "MP" , "403503"),
        ("city5" , "MP" , "403507"),
        ("city6" , "UP" , "503503"),
        ("city7" , "UP" , "503505"),
        ("city8" , "UP" , "503508");

SELECT state , city , zipcode
FROM zipcodetable
ORDER BY state , city