-- hr부서 (departments)테이블 모든 행과 열 조회
SELECT * FROM departments;

-- 부서명이 IT로 시작하는 부서들 조회
SELECT * FROM departments WHERE DEPARTMENT_NAME LIKE("IT%");

-- 60, 210, 230
-- 직원 테이블 
SELECT * FROM employees WHERE DEPARTMENT_ID IN 
(   -- 서브 쿼리
	SELECT DEPARTMENT_ID FROM departments WHERE DEPARTMENT_NAME LIKE "IT%"
);

-- 연봉 내림차순 정렬
-- 연봉 탑 10..
-- 연봉을 오름차순으로 조회
SELECT * FROM (
	SELECT * FROM employees ORDER BY SALARY DESC LIMIT 10
)AS A ORDER BY SALARY; -- 서브 쿼리를 테이블로 사용할 경우 별명 무조건 해줘야함.


SELECT (SELECT 1 + 1),2,3,4;

-- David Austin의 연봉과 같은 연봉을 받는 직원들 조회
-- SELECT * FROM employees WHERE FIRST_NAME = 'David' AND LAST_NAME = 'Austin';
SELECT * FROM employees WHERE SALARY = (
		SELECT SALARY FROM employees WHERE FIRST_NAME = 'David' AND LAST_NAME = 'Austin'
);

