
/*  다음의 요구사항에 맞추어 데이터 베이스 작업하기
* 1.관리자계정 devAdmin
* 2.devAdmin 접속하고
* 회원관리를 위한 테이블(user_account) 생성
* 테이블에는 id,회원계정명, 회원팻워드, 회원이름 정보관리 컬럼 생성
* 3. 데이터베이스와 외래키로 관계를 맺는 회원정보 user info 생성
* 테이블에는 id, 성별 ,나이 ,이메일 ,주소, 전화번호
* id 컬럼은 user_account와 외래키 관계를 가지는 컬럼
* 4. 2,3 생성한 테이블에 데이터 3개 추가하기
*  데이터를 추가할때 id 컬럼에 대해서는 sequence 객체 사용, 값이 자동생성되게하기
* 5. VIEW 를 만들어서 두 개의 테이블 정보가 모두 조회될 수 있도록 한다.
*     성별에 대해서는 남성, 여성으로 변환되게 하며, 패스워드는 * 문자로 마스킹 한다.
*/






CREATE USER devAdmin IDENTIFIED BY rPqkfwk12345678;

GRANT CONNECT, RESOURCE, CREATE SESSION
     ,CREATE VIEW, INSERT ANY TABLE
     ,UPDATE ANY TABLE, DELETE ANY TABLE
    TO devAdmin;
ALTER USER devAdmin quota 10M ON DATA;

 SELECT * FROM ALL_USERS WHERE USERNAME = 'DEVADMIN';
 SELECT * FROM DBA_ROLE_PRIVS WHERE GRANTEE = 'DEVADIN';
 SELECT * FROM DBA_SYS_PRIVS WHERE GRANTEE = 'DEVADMIN';
 
COMMIT;

CREATE TABLE USER_ACCOUNT (
           ID            NUMBER            CONSTRAINT PK_USER_ACCOUNT_ID PRIMARY KEY
        ,  USERNAME      VARCHAR(50)       CONSTRAINT NN_USER_ACCOUNT_USERNAME  NOT NULL
        ,  PASSWORD      VARCHAR(50)       CONSTRAINT NN_USER_ACCOUNT_PASSWORD  NOT NULL
        ,  NAME          VARCHAR(50)       CONSTRAINT NN_USER_ACCOUNT_NAME      NOT NULL
);



CREATE TABLE USER_INFO(
             ID        NUMBER             CONSTRAINT PK_USER_INFO_ID     PRIMARY KEY
           , GENDER    CHAR(1)            CONSTRAINT CK_USER_INFO_GENDER CHECK(GENDER IN('F','M'))
           , AGE       NUMBER(3)          CONSTRAINT CK_USER_INFO_AGE    CHECK(AGE BETWEEN 0 AND 199)
           , EMAIL     VARCHAR(100)       
           , PHONE     VARCHAR(13)
           , CONSTRAINT FK_USER_INFO_ID  FORIEGN KEY(ID) REFERENCES USER_ACCOUNT(ID)
);

CREATE SEQUENCE USER_ACCOUNT_SEQ NOCACHE;

DROP TABLE USER_INFO;

SELECT * FROM USER_ACCOUNT;
SELECT * FROM USER_INFO;
SELECT * FROM ALL_ALL_TABLES WHERE OWNER =  'DEVADMIN' AND TABLE_NAME LIKE = 'USER\_%' ESCAPE '\';
SELECT * FROM ALL_TAB_COLUMNS WHERE OWNER = 'DEVADMIN' AND TABLE_NAME LIKE = 'USER\_%' ESCAPE '\';
SELECT * FROM USER_CONSTRAINTSWHERE OWNER = 'DEVADMIN' AND TABLE_NAME LIKE = 'USER\_%' ESCAPE '\';
SELECT * FROM USER_SEQUENCES;

COMMIT;

SELECT * FROM USER_ACCOUNT;
SELECT * FROM USER_INFO;


INSERT INTO USER_ACCOUNT VALUES(USER_ACCOUNT_SEQ.NEXTVAL, 'user1', 'user1', '사용자1');
INSERT INTO USER_INFO    VALUES(USER_ACCOUNT_SEQ.CURRVAL, 'F',20 ,NULL,NULL);

INSERT INTO USER_ACCOUNT VALUES(USER_ACCOUNT_SEQ.NEXTVAL, 'user2', 'user2', '사용자2');
INSERT INTO USER_INFO    VALUES(USER_ACCOUNT_SEQ.CURRVAL, 'F',22 ,NULL,NULL);

INSERT INTO USER_ACCOUNT VALUES(USER_ACCOUNT_SEQ.NEXTVAL, 'user3', 'user3', '사용자3');
INSERT INTO USER_INFO    VALUES(USER_ACCOUNT_SEQ.CURRVAL, 'F',23 ,NULL,NULL);




CREATE OR REPLACE VIEW V_USER_INFO(
  AS SELECT A.ID
          , A.USERNAME
          , REPLACE(A.PASSWORD, A.PASSWORD, RPAD('*', (SELECT DATA_LENGTH
                                                         FROM USER_TAB_COLUMNS
          
                                                                         )
          , A.NAME
          , DECODE(B.GENDER,'F','여성','M','남성') AS GENDER
          , B.AGE
          , B.EMAIL 
          , B.PHONE
     FROM USER_ACCOUNT A 
     JOIN USER_INFO B
       ON A.ID = B.ID
       
SELECT * FROM V_USER_INFO;

SELECT * FROM USER_TABLE_COLUMNS WHERE TABLE_NAME = 'USER_ACCOUNT' AND COLUMN_NAME = 'PASSWORD';


