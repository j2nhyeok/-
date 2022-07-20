SELECT CONCAT("asdf", "zzz");

SELECT hello("최진혁"); -- 만들어 놓은 함수 호출
CALL usp_countBookS;

CALL usp_findbytitle('책1', @count);

SELECT @count;


CALL usp_selectTable('persons');

CALL usp_loop(10);
