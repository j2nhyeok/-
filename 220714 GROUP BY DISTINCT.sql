-- 부서 id가 90인 직원들의 인원 수
SELECT COUNT(*) FROM employees WHERE DEPARTMENT_ID = 90;
SELECT COUNT(*) FROM employees WHERE DEPARTMENT_ID = 60;
SELECT COUNT(*) FROM employees WHERE DEPARTMENT_ID = 30;

SELECT  COUNT(*) FROM employees GROUP BY DEPARTMENT_ID;

-- 부서별 최고 연봉, 최저 연봉, 평균 연봉, 연봉 합
SELECT  DEPARTMENT_ID, (SALARY), MIN(SALARY), AVG(SALARY), SUM(SALARY) FROM employees GROUP BY DEPARTMENT_ID;

-- 중복 제거 키워드 (주어진 열의 데이터가 모두 동일해야 삭제해줌)
SELECT DISTINCT JOB_ID, LAST_NAME FROM employees;

-- 직원 테이블 LAST_NAME을 중복 제거하고 조회
SELECT DISTINCT LAST_NAME FROM employees;
-- 직원 테이블 LAST_NAME 그룹 별로 인원 수 조회
SELECT LAST_NAME, COUNT(*) FROM employees GROUP BY LAST_NAME;

-- LAST_NAME 그룹의 카운트가 2이상 인 행들만 조회
SELECT LAST_NAME FROM employees GROUP BY LAST_NAME HAVING COUNT(*) >1;

-- 위의 
성을 가지는 직원 목록 조회
 SELECT * FROM employees WHERE LAST_NAME IN (SELECT LAST_NAME FROM employees GROUP BY LAST_NAME HAVING COUNT(*) >1);
 
 SELECT * FROM employees WHERE SALARY = (
	SELECT distinct SALARY FROM employees ORDER BY SALARY LIMIT 4, 1
 );
 
 
 -- 상위 연봉 50명에 대해서  부서멸로 몇 명씩 있는지.
 SELECT DEPARTMENT_ID, COUNT(*) FROM employees GROUP BY (SELECT DEPARTMENT_ID FROM employees ORDER BY SALARY DESC LIMIT 50);