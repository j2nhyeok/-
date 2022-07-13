DROP DATABASE my_db;

CREATE DATABASE my_db;
USE my_db;
CREATE TABLE students(
	number INT PRIMARY KEY,   -- 학번을 고유 키로 선언
	name VARCHAR(10),
    age INT,
    score DOUBLE
);

-- 주요 키 (PRIMARY KEY) : NOT NULL, UNIQUE;
DESC STUDENTS;

-- PK는 NULL값 못집어넣음.
INSERT INTO students VALUES (NULL, '길동', 20, 3.3);


INSERT INTO students VALUES (1, '길동', 20, 3.3);
SELECT * FROM students;

-- PK는 중복 불가
INSERT INTO students VALUES (1, '둘리', 210, 1.3);



