CREATE TABLE accounts(
           userid         VARCHAR2(20)      PRIMARY KEY
        ,  userpw         VARCHAR2(20)
        ,  username       VARCHAR2(20)
        ,  gender         CHAR(1)
        ,  age            NUMBER
        ,  createdate     DATE
);

INSERT INTO accounts VALUES('user1', 'user1','user1','M',22,SYSDATE);

SELECT * FROM accounts;

DELETE FROM accounts;

DROP TABLE accounts;

--COMMIT;꼭 해야함