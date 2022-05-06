SELECT EMPLOYEE_ID AS 사번
      ,FIRST_NAME AS 이름 
      ,LAST_NAME AS 성
      ,DEPARTMENT_ID AS 부서
  FROM EMPLOYEES
 ORDER BY 4 DESC NULLS LAST, 이름 DESC;



SELECT DEPARTMENT_ID --4
      ,JOB_ID
      ,COUNT(*)
      ,SUM(SALARY)
      ,AVG(SALARY)
      ,MIN(SALARY)
      ,MAX(SALARY)       
  FROM EMPLOYEES --1
  WHERE DEPARTMENT_ID IS NOT NULL --2
 GROUP BY DEPARTMENT_ID, JOB_ID --3
 ORDER BY DEPARTMENT_ID; --5

 SELECT COUNT(*)
        ,DECODE(COMMISSION_PCT,NULL,'NO','YES')
    FROM EMPLOYEES
   GROUP BY DECODE(COMMISSION_PCT,NULL,'NO','YES');
  
  
  
  /*
   * 1980,1990 년대,2000 년대 별로 그룹을 묶어서 평균급여와 총인원 수를 구한다.
   */
  SELECT TRUNC(EXTRACT(YEAR FROM HIRE_DATE),-1) AS 년도 --고용일자 해당그룹의 날짜
        ,AVG(SALARY) AS 평균급여
        ,COUNT(*) AS 인원
   FROM EMPLOYEES
  GROUP BY TRUNC(EXTRACT(YEAR FROM HIRE_DATE),-1);
 
            
     
  
  
  /*
   * 커미션을 받는 직원 중 가장 높은 급여액과 가장 낮은 급여액을 구한다.
   */
  SELECT MAX(COMMISSION_PCT)
        ,MIN(COMMISSION_PCT)
   FROM EMPLOYEES
  WHERE COMMISSION_PCT IS NOT NULL;
  
 
   /*DEPARTMENTS 테이블에서 MANAGER_ID가 NULL인 부서의 수와 아닌 부서의 수를 구한다.
    * 
    */
 
 
  SELECT COUNT(*)
        ,DECODE(MANAGER_ID, NULL, 'N0','YES')AS 관리자유무
    FROM DEPARTMENTS
   GROUP BY DECODE(MANAGER_ID, NULL, 'N0','YES');
  
  /*
   * EMPLOYEES 테이블에서 급여 통계를 위해 급여 구역별 인원 수를 구한다.
   * 급여 구역은 2000 부터 1000 단위로 분류하도록 한다.
   *       2000~3000 미만, 3000~4000 미만, 4000~5000 미만, ...
   */
 
SELECT TRUNC(SALARY,-3)
      ,COUNT(*) --인원수 구하기
   FROM EMPLOYEES
   GROUP BY TRUNC(SALARY,-3)
   ORDER BY 1;

 /*WHERE           HAVING 
  조건절         그룹 조건절
 */
  
  SELECT TRUNC(SALARY,-3)
      ,COUNT(*)
   FROM EMPLOYEES
   GROUP BY TRUNC(SALARY,-3)
   HAVING COUNT(*) >=10
   ORDER BY 1; --첫번쨰줄 기준오름차순
   
   SELECT TRUNC(SALARY,-3)
         ,COUNT(*)
     FROM EMPLOYEES
    GROUP BY TRUNC(SALARY,-3)
   HAVING COUNT(*) >=10
    ORDER BY 1;
   
   
   /*
    * 부서(DEPARTMENT_ID)별 전화번호 사용 실태를 확인하기 위한 조회 쿼리를 작성한다.
    *       전화번호 앞자리 3자리에 따라 다음의 요금이 측정되어 있다.
    *            515 : 월 500원
    *            590 : 월 450원
    *            650 : 월 400원
    *            011 : 월 300원
    *            603 : 월 600원
    * 
    * 위의 요금을 참고하여 부서, 번호별 월 통신비를 산출하도록 한다. 
    * 위에 표시한 요금은 1인당 요금이다.
    */
   
  SELECT DEPARTMENT_ID AS 부서
        ,SUBSTR(PHONE_NUMBER,1,3) AS 회선번호
        ,COUNT(*) AS 회선수
        ,DECODE(SUBSTR(PHONE_NUMBER,1,3),'515', 500 * COUNT(*)
                                        ,'590', 450 * COUNT(*)
                                        ,'650', 400 * COUNT(*)
                                        ,'011', 300 * COUNT(*)
                                        ,'603', 600 * COUNT(*)) AS 총사용요금
  FROM EMPLOYEES
  GROUP BY DEPARTMENT_ID, SUBSTR(PHONE_NUMBER, 1,3)
  ORDER BY DEPARTMENT_ID;
 
 
 --ROLLUP,CUBE 
  --그룹별 산출한 결과에 대해서 추가 집계를 수행하는 함수
  SELECT DEPARTMENT_ID
        ,COUNT(*)
       FROM EMPLOYEES 
      GROUP BY (DEPARTMENT_ID)
     ORDER BY 1;
    
  SELECT DEPARTMENT_ID
        ,COUNT(*)
       FROM EMPLOYEES 
      GROUP BY ROLLUP (DEPARTMENT_ID) --총카운트
     ORDER BY 1;
     
     
  SELECT DEPARTMENT_ID
        ,JOB_ID
        ,COUNT(*)
        ,CASE WHEN GROUPING(DEPARTMENT_ID) = 0 AND GROUPING(JOB_ID)= 0 THEN '부서/직급별집계'
              WHEN GROUPING(DEPARTMENT_ID) = 0 AND GROUPING(JOB_ID)= 1 THEN '부서별집계'
              WHEN GROUPING(DEPARTMENT_ID) = 1 AND GROUPING(JOB_ID)= 0 THEN '집급별집계'
              WHEN GROUPING(DEPARTMENT_ID) = 1 AND GROUPING(JOB_ID)= 1 THEN '총집계'
             END AS 집계구분
       FROM EMPLOYEES 
       WHERE DEPARTMENT_ID IS NOT NULL
       GROUP BY CUBE(DEPARTMENT_ID, JOB_ID)--그룹별로 집계한 마지막 집계--총카운트
       ORDER BY 1;
      
      
      SELECT *
        FROM EMPLOYEES
       WHERE DEPARTMENT_ID =100
      UNION ALL --합집합(중복포함모두)
      SELECT *
       FROM EMPLOYEES
      WHERE MANAGER_ID =101;
      
      SELECT *
        FROM EMPLOYEES
       WHERE DEPARTMENT_ID =100
      UNION --합집합,중복없음
      SELECT *
       FROM EMPLOYEES
      WHERE MANAGER_ID =101;
     
      SELECT *
        FROM EMPLOYEES
       WHERE DEPARTMENT_ID =100
      INTERSECT --교차만 보여줌
      SELECT *
       FROM EMPLOYEES
      WHERE MANAGER_ID =101;
     
      SELECT *
        FROM EMPLOYEES
       WHERE DEPARTMENT_ID =100
      MINUS --차집합
      SELECT *
       FROM EMPLOYEES
      WHERE MANAGER_ID =101;
    
    SELECT DEPARTMENT_ID
          ,NULL AS JOB_ID
          ,COUNT(*)
       FROM EMPLOYEES
      WHERE DEPARTMENT_ID IS NOT NULL
      GROUP BY DEPARTMENT_ID
      UNION ALL
      SELECT NULL AS DEPARTMENT_ID
            ,JOB_ID
            ,COUNT(*)
        FROM EMPLOYEES 
       WHERE DEPARTMENT_ID IS NOT NULL
       GROUP BY JOB_ID;
       
     SELECT DEPARTMENT_ID
           ,JOB_ID
           ,COUNT(*)
        FROM EMPLOYEES 
        WHERE DEPARTMENT_ID IS NOT NULL
        GROUP BY GROUPING SETS(DEPARTMENT_ID,JOB_ID)
        ORDER BY 1;
 

      