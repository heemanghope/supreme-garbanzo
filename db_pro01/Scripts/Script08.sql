
/* -모든 컬럼명은 한글로 부여하여 조회한다.
 * -'FIRST_NAME'과 'LAST_NAME'을 하나의 컬럼(이름)으로 만들어서 조회하도록 한다.
 * -PHONE_NUMBER에서 사용한 구분자 .은 -으로 변경하여 조회하도록 한다.
 * -EMAIL 주소는 @example.com 을 추가로 덧붙여서 조회되도록 한다.(소문자만 나오게 한다.)
 * -HIRE_DATE 는 YYYY년 MM월 DD일 형식으로 조회되도록 하며, 추가로 입사일부터 현재일까지의 근속일수가 계산되어
 * 조회되도록 한다.
 * -SALARY는 원화 단위로 변환시키며 조회하며, COMMISSION_PCT가 있는 경우 이를 계산한 SALARY 금액이 나오게 한다.
 * 추가로 100원 단위는 절사한다.
 * -입사일을 기준으로 오름차순 정렬하도록 한다.
 * 
 */


SELECT EMPLOYEE_ID AS 사번
      ,CONCAT(FIRST_NAME,CONCAT(' ', LAST_NAME)) AS 이름
      ,FIRST_NAME || '  '|| LAST_NAME AS 이름
      ,REPLACE(PHONE_NUMBER,'.', '-') AS 전화번호
      ,CONCAT(LOWER(EMAIL), '@email.com')AS 이메일
      ,TO_CHAR(HIRE_DATE, 'YYYY"년" MM"월" DD"일"')AS 입사일
      ,FLOOR(MONTHS_BETWEEN(SYSDATE, HIRE_DATE)) AS 근속일
      ,FLOOR(MONTHS_BETWEEN(SYSDATE, HIRE_DATE)/12) AS 근속월
      ,TRUNC(SALARY * 1260 *(1 + NVL(COMMISSION_PCT,0)),-3) AS 급여
      ,TRUNC(DECODE(COMMISSION_PCT,NULL, SALARY*1260, SALARY*1260 *(1+COMMISSION_PCT)),-3) AS 급여
    FROM EMPLOYEES
  ORDER BY HIRE_DATE;
 
 
 
 
 
 SELECT  NVL(SUBSTR(PHONE_NUMBER,1,3),'총계') AS 회선번호 --NULL이라면 총계인것이다.
        ,COUNT(*) AS 회선수
    FROM EMPLOYEES
   GROUP BY ROLLUP(SUBSTR(PHONE_NUMBER,1,3));
 

  
  SELECT MANAGER_ID AS 관리자ID
        ,COUNT(*) AS 인원수
     FROM EMPLOYEES
    WHERE MANAGER_ID IS NOT NULL
     GROUP BY MANAGER_ID;



