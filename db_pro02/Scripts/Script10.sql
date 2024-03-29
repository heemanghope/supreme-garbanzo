-- 사전 작업으로 PUSER,DEVADMIN 계정에 SYNONYM  를 생성할 권한을 부여.;
GRANT SELECT ON SYNONYM TO PUSER1;
GRANT SELECT ON SYNONYM TO DEVADMIN;



--비공개 동의어(PUSER1 에서 만듦)
CREATE SYNONYM EMP FOR EMPLOYEES;

--공개 동의어(관리자 계정에서만 사용가능)
CREATE OR REPLACE SYNONYM EMP FOR PUSER1.EMPLOYEES;
CREATE PUBLIC SYNONYM EMP FOR PUSER1.EMPLOYEES;

--비공개/공개 동의어를 다른 계정에서 사용하기 위해 SELECT 권한은 필요하다.
GRANT SELECT ON 테이블명 TO 계정명;

--PUSER1이 생성한 비공개 동의어를 DEVADMIN 이 접근하여 사용.
SELECT * FROM PUSER1.EMP1;

--관리자가 생성한 공개 동의어를 DEVADMIN 이 접근하여 사용.
SELECT * FROM EMP2;
