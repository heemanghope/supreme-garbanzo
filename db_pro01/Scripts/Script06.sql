SELECT NVL(NULL,'Default')
  FROM DUAL;--미리지정된값으로 출력될수있게 만들어줌
  
SELECT NVL(COMMISSION_PCT,0)
  FROM EMPLOYEES;--null만 0으로 출력
  
 SELECT DECODE(식,값1, 반환값1, 값2,반환값2, 값3 ,반환값3, ...,기본값)
 
 
 SELECT DECODE(DEPARTMENT_ID, 90,'A부서',60,'B부서',100,'C부서', '그 외')
   FROM EMPLOYEES;
   
 SELECT DECODE(EXTRACT(YEAR FROM HIRE_DATE),2000,'신규사원','기존사원')
  FROM EMPLOYEES;
  
 SELECT SALARY
        ,CASE WHEN SALARY >=2000 AND SALARY <5000 THEN '하위소득'
             WHEN SALARY >=5000 AND SALARY <10000  THEN '중위소득'
             WHEN SALARY >=10000  THEN '고소득'
             ELSE '미분류'
        END AS 급여분류
    FROM EMPLOYEES;
    
  
   -- 그룹함수--
   SELECT SUM(SALARY) AS 총합
         ,AVG(SALARY) AS 평균
         ,MAX(SALARY) AS 최대급여액
         ,MIN(SALARY) AS 최소급여액
         ,COUNT(SALARY) AS 인원수   --행수 ,수량
     FROM EMPLOYEES
   WHERE DEPARTMENT_ID =100;
   
  
  SELECT *
  FROM EMPLOYEES
   WHERE DEPARTMENT_ID =100;
   
  
  SELECT MAX(FIRST_NAME) --문자열에서 가장뒤에있는것
        ,MIN(LAST_NAME) --문자열에서 가장 앞에 있는것
        FROM EMPLOYEES;    --사전순..숫자가아닌 문자열에서 가능
        
  SELECT COUNT(*) -- 숫자,행수를 세어줌..
   FROM EMPLOYEES; --딱히 컬럼을 지정 해 줄 필요 없음