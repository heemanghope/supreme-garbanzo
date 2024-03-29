SELECT EMPLOYEE_ID AS 사번
      ,CONCAT(FIRST_NAME,CONCAT(' ',LAST_NAME)) AS 이름
      ,FIRST_NAME || '  '|| LAST_NAME AS 이름   
      ,REPLACE(PHONE_NUMBER,'.','-') AS 전화번호
      ,CONCAT(LOWER(EMAIL),'@example.com ') AS 이메일
      ,TO_CHAR(HIRE_DATE, 'YYYY"년" MM"월" DD"일"') AS 입사일
      ,FLOOR(SYSDATE - HIRE_DATE) AS 입사일
      ,FLOOR(MONTHS_BETWEEN(SYSDATE,HIRE_DATE)/12) AS 근속월
      ,TRUNC(SALARY * 1260 *(1 + NVL(COMMISSION_PCT,0))-3) AS  급여 
      ,TRUNC(DECODE(COMMISSION_PCT,NULL, SALARY*1260,SALARY*1260 *(1+COMMISSION_PCT)),-3) AS 급여
   FROM EMPLOYEES
 ORDER BY HIRE_DATE;

SELECT NVL(SUBSTR(PHONE_NUMBER,1,3),'총계') AS 회선번호
      ,COUNT(*) AS 회선수 
   FROM EMPLOYEES
  GROUP BY ROLLUP(SUBSTR(PHONE_NUMBER,1,3));
 
SELECT MANAGER_ID AS 관리자ID
      ,COUNT(*) AS 회원수 
   FROM EMPLOYEES
  WHERE MANAGER_ID IS NOT NULL
  GROUP BY MANAGER_ID;