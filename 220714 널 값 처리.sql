SELECT * FROM employees;


SELECT CONCAT(FIRST_NAME , " " , LAST_NAME) AS "Full Name",
		CASE WHEN  SUBSTRING(PHONE_NUMBER, 1,3) = "011" THEN "개인전화"
				ELSE "내선 번호"
                END AS '분류'
    FROM employees;
    
    -- NULL 칸에 데이터 대체하기
    SELECT IFNULL(NULL, "대체값");
    
    -- 값이 3개, 1번째 값이 NULL이면 , 2번째 값, 2번째 값도 널이면 3번째 값.
    SELECT IFNULL(IFNULL("첫번째 값", "두번째 값"), "세번째 값");
    -- 첫번째가 NULL이면 두번째, 두번째도 널이면 세번째
    SELECT COALESCE('1', '2', '3');
    
    -- 2개가 같으면 NULL, 다르면 첫 번째 것.
    SELECT NULLIF('A', 'A');
    
    
    DESC books;

ALTER TABLE books CHANGE COLUMN title title VARCHAR(30) NOT NULL; -- 이름 타입은 그대로 두고 NOT NULL로 변경함.

INSERT INTO books(title) VALUES ('디폴트값 확인');

SELECT * FROM books;

CREATE TABLE myPractice(
	ColName1 VARCHAR(50) DEFAULT '39838o' -- 기본값을 NULL 대신 39838o로 변경
);


    
    
    
    
    
    