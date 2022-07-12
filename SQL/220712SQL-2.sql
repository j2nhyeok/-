-- hr 데이터 베이스 사용하기 명령어 작성
USE hr;

-- employees(직원) 테이블의 구조(어떤 컬럼이 있는지) 조회
DESC employees;

-- employees(직원) 테이블의 모든 행의 모든 열을 조회
SELECT * FROM employees;

-- employees(직원) 테이블의 First_Name(이름) 열의 값인 'John'인 직원 조회
SELECT * FROM employees WHERE First_Name = 'John';

-- employees(직원) 테이블의 Last_Name(성) 열의 값인 'John'을 포함하는 직원 조회
SELECT * FROM employees WHERE Last_Name = '%John%';

-- employees(직원) 테이블의 이름의 값이 6글자인 직원 조회
SELECT * FROM employees WHERE First_Name = '______';

-- employees(직원) 테이블의 Salary(연봉) 열의 값이 10000 ~15000인 직원 조회
SELECT * FROM employees WHERE Salary BETWEEN 10000 AND 15000;

-- employees(직원) 테이블의 이름, 성, 연봉 컬럼과 연봉의 6%를 연산하여 'tax'라는 별명의 컬럼으로 조회.
SELECT First_Name, Last_Name, Salary, (Salary * 0.06) AS 'tax' FROM employees