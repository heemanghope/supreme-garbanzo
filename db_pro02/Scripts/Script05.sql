SELECT  ROWNUM
      , FIRST_NAME
      , LAST_NAME
      , SALARY
      , COMMISSION_PCT
  FROM EMPLOYEES
  WHERE COMMISSION_PCT IS NOT NULL
    AND ROWNUM <=15
  ORDER BY SALARY DESC;
 
 
 
 SELECT *
    FROM (SELECT FIRST_NAME
               , LAST_NAME
               , SALARY
               , COMMISSION_PCT
            FROM EMPLOYEES 
           WHERE COMMISSION_PCT IS NOT NULL
           ORDER BY SALARY DESC   --top-N 분석 --미리 정렬된 쿼리만들어줌
           )
 WHERE ROWNUM < = 15;
 
WITH EMP_COM
   AS (SELECT FIRST_NAME
            , LAST_NAME
            , SALARY
            , COMMISSION_PCT
         FROM EMPLOYEES 
        WHERE COMMISSION_PCT IS NOT NULL
        ORDER BY SALARY DESC)
     SELECT * FROM EMP_COM;
     
 SELECT FIRST_NAME
      , LAST_NAME
      , SALARY
      , DENSE_RANK() OVER(ORDER BY SALARY DESC) AS 순위
    FROM EMPLOYEES;
    
 SELECT *
    FROM (SELECT FIRST_NAME
               , LAST_NAME
               , SALARY
               , RANK() OVER(ORDER BY SALARY DESC) AS 순위
            FROM EMPLOYEES
          )
   WHERE 순위 <= 5;
  
  
  
  
 SELECT * 
   FROM EMPLOYEES E, DEPARTMENTS D
  WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID; -- 오라클 전용 구문 
 
 SELECT * 
   FROM EMPLOYEES E
   JOIN DEPARTMENTS D
     ON E.DEPARTMENT_ID = D.DEPARTMENT_ID; --안시 표준구문
 
 SELECT * 
  FROM EMPLOYEES E
  JOIN DEPARTMENTS D USING (DEPARTMENT_ID); -- 컬럼명이 동일하면 USING 컬럼명
   
 
 SELECT * 
 FROM EMPLOYEES E
LEFT JOIN DEPARTMENTS D  --실제로 나옴 왼쪽 나오게!
   ON E.DEPARTMENT_ID =D.DEPARTMENT_ID
  WHERE E.EMPLOYEE_ID= 178;
 
 SELECT * 
 FROM EMPLOYEES E
RIGHT JOIN DEPARTMENTS D --실제로 나옴 오른쪽 나오게!
   ON E.DEPARTMENT_ID =D.DEPARTMENT_ID;
   

  
  SELECT * 
  FROM EMPLOYEES E
  FULL JOIN DEPARTMENTS D 
   ON E.DEPARTMENT_ID =D.DEPARTMENT_ID;
  
  
   
  SELECT *
   FROM EMPLOYEES E, DEPARTMENTS D
  WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID(+);--LEFT OUTER
  
 SELECT *
  FROM EMPLOYEES E, DEPARTMENTS D
 WHERE E.DEPARTMENT_ID(+) = D.DEPARTMENT_ID;--RIGHT OUTER
 
 --카데시안 곱
 SELECT COUNT(*) 
  FROM EMPLOYEES
 CROSS JOIN DEPARTMENTS;
 
SELECT X * Y AS TOTAL
    FROM(SELECT(SELECT COUNT(*) FROM EMPLOYEES) AS X
               ,(SELECT COUNT(*) FROM DEPARTMENTS) AS Y
       FROM DUAL
    );
   
   SELECT * FROM EMPLOYEES;
   SELECT * FROM DEPARTMENTS;
  
  SELECT *
    FROM EMPLOYEES E
    JOIN JOBS J
      ON (E.SALARY BETWEEN J.MIN_SALARY AND J.MAX_SALARY);-- NON_EQU JOIN
   
  SELECT *
   FROM EMPLOYEES E1
   JOIN EMPLOYEES E2
     ON E1.EMPLOYEE_ID =E2.MANAGER_ID; --SELF JOIN