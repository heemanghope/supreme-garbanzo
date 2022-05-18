CREATE TABLE information(
           id          VARCHAR2(20)      PRIMARY KEY
        ,  pwd         VARCHAR2(20)
        ,  name        VARCHAR2(20)
        ,  lnumber         NUMBER
        ,  phonenumber     NUMBER
       
);

SELECT * FROM INFORMATION;

       

CREATE TABLE   ORDERS(
      num          VARCHAR2(10)   PRIMARY KEY
    , id           VARCHAR2(20)
    , carname      VARCHAR2(20)   NOT NULL 
    , dates         DATE 
    , time         NUMBER

);



SELECT * FROM ORDERS;
DROP TABLE ORDERS;


