SELECT LOWER('ABCDE');
SELECT UPPER('abcde');

SELECT REVERSE('QWERTY');
SELECT CONCAT('문자열'," ", '결합'," ", '함수');
SELECT CONCAT('결합', NULL, '값이 있으면?'); -- 하나라도 NULL값을 포함하고 있으면 NULL을 반환한다.
SELECT CHAR_LENGTH('문자열 길이');

SELECT REPLACE('원본 문자열에서 변환합니다', '변환', 'REPLACE');
SELECT REPLACE(1234, 1, 5);

SELECT SUBSTRING('employees', 5); -- 문자열, 자를 시작 위치, 자바와 다르게 인덱스가 1부터 시작한다.
SELECT SUBSTRING('employees', 5,7); -- 문자열, 자를 시작 위치, 개수
SELECT SUBSTRING('employees', -3); -- 음수일 때 우측에서부터 위치를 세어 나감
SELECT SUBSTRING('employees', -3, 2); 


SELECT LPAD("123", 5, '0');
SELECT RPAD("456", 5, "*");

SELECT REPEAT("반복", 3);

SELECT LOCATE('D','ABCDEFG'); -- 인덱스 시작위치 확인
SELECT LOCATE('위치', '문자열의 위치를 찾는데 SQL의 문자 순서는 1부터임');

-- "515.123.4567"
-- .을 기준으로 각각 잘라보셈.

SELECT LOCATE('.', "515.123.4567");

SELECT SUBSTRING_INDEX("515.123.4567", '.',3);

SELECT * FROM employees;

-- 직원 테이블 전화번호 앞자리 3자리로 그룹지어 개수
SELECT SUBSTRING(PHONE_NUMBER, 1,3), COUNT(*) FROM employees 
	GROUP BY SUBSTRING(PHONE_NUMBER , 1,3);
    

SELECT RAND(); -- 랜덤 수 생성기 
SELECT ROUND(123.123, 2); -- 소수점 자릿수(반올림)
SELECT FLOOR(1.555); -- 내림
SELECT CEIL(1.222); -- 올림

SELECT ABS(-55); -- 절댓값 구하기
SELECT POW(2, 3) -- 제곱수 구하기

