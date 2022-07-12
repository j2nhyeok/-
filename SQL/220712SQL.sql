SELECT * FROM country; -- country 테이블 안에 있는 모든 열 다 보기
SELECT * FROM city; 


SELECT Name, Population FROM country; -- country테이블 안에 Name, Population 열만 정보 보기


DESC country; -- 테이블의 구조를 볼 수 있는 명령어 DESC

-- country 테이블 Code열과 GNP열을 조회해보세요.
SELECT Code, GNP FROM country;

SELECT * FROM country WHERE Name = 'South Korea'; -- 한국 정보만 보기

-- Continent 값이 'Asia' 인 행 조회하기
SELECT * FROM country WHERE Continent = 'Asia';

-- OR 연산자,,
SELECT * FROM country WHERE Name = 'South Korea' OR Name = 'Japan' OR Name = 'China';

-- 인구 40000000이상
SELECT * FROM country WHERE Population >= 40000000;

-- 인구 40000000 이상 50000000이하
SELECT * FROM country WHERE Population between 40000000 AND 50000000;

-- Continent값이 'Asia'를 제외한 국가 목록 조회
SELECT * FROM country WHERE Continent <> 'Asia';

-- 3국가 제외하고 출력
SELECT * FROM country WHERE Name NOT IN ('South Korea', 'Japan', 'China');

-- Continent 값이 North America, Europe, Asia 를 제외한 국가들 중
-- GNP 값이 100 이상 1000이하인 국가 목록 조회하기
SELECT * FROM country WHERE Continent NOT IN ('North America', 'Europe', 'Asia') AND GNP BETWEEN 100 AND 1000;