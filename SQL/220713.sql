-- 데이터베이스 만들기

CREATE DATABASE my_db;
SHOW DATABASES;

USE my_db;

SHOW TABLES;

-- 사람 테이블
-- 열1 이름 문자열
-- 열2 나이 정수

CREATE TABLE persons(
	name VARCHAR(10), -- 문자열을 나타내는 VARCHAR(길이)
    age INT
);


DESC persons;

SELECT * FROM persons;

INSERT INTO persons (name, age) VALUES ('홍길동', 22);

-- '브루스 리', 30 행 추가
-- '스티븐 킹', 40 행 추가
INSERT INTO persons VALUES ('브루스 리', 30);
INSERT INTO persons VALUES ('스티븐 킹', 40);

-- 여러 데이터를 한 번에 INSERT
INSERT INTO persons (name, age) VALUES ('철수', 20), ('철수', 30);

DELETE FROM persons; -- 테이블의 모든 행 삭제, 테이블은 살아있음.
DROP TABLE persons; -- persons 테이블 삭제

SHOW TABLES;

-- 책 테이블 생성, 제목 : 문자열, 가격 : 정수
CREATE TABLE books(
	title VARCHAR(25),
    price INT
);

INSERT INTO books(title, price) VALUES ('파워자바', 25000);
INSERT INTO books(title, price) VALUES ('하늘과 바람과 별과 시', 15000);
INSERT INTO books(title, price) VALUES ('꽃을 보듯 너를 본다', 12000);

SELECT * FROM books;

-- 문자열 
-- CHAR(5) -- 고정된 길이값을 갖는다.
-- VARCHAR(5) -- 가변길이를 갖는다

-- 'A'하나만 넣을려고 할 때
-- CHAR(5)는 'A    ' 어떻게든 5자리를 채운다.
-- VARCHAR(5)는 'A'  길이값 조절 가능함.
CREATE TABLE testChar(
	fisLength CHAR(5),
    varLength VARCHAR(5)
);

INSERT INTO testChar (fisLength, varLength) VALUES('A', 'A');

SELECT * FROM testChar;
-- SET sql_mode = 'PAD_CHAR_TO_FULL_LENGTH';
SELECT char_length(fisLength), char_length(varLength) FROM testChar;
SELECT CONCAT(fisLength, 'B') FROM testChar;

-- 빈칸 제거하기
SELECT RTRIM('A                 '); -- RTRIM()우측에 있는 공백 제거 <> LTRIM()

 -- 학생 
 -- 이름 : 가변길이문자열 (10자)
 -- 학점 : 실수
 
 CREATE TABLE students(
	name VARCHAR(10),
    age BIGINT,
    score DOUBLE
 );
 
DESC students;

INSERT INTO students (name, age, score) VALUES ('길동', 20, 3.3);
INSERT INTO students (name, age, score) VALUES ('길동', 21, 2.6);
INSERT INTO students (name, age, score) VALUES ('둘리', 20.5, 3);

SELECT * FROM students;

DELETE FROM students WHERE name = '둘리';















