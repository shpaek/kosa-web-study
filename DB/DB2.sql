SELECT ROUND(1234.567)
FROM employees;

SELECT ROUND(1234.567) --1235
        , ROUND(1234.567, 0) --1235
        , ROUND(1234.567, 1) --1234.6
        , ROUND(1234.567, -1) --1230
FROM dual; -- 더미모듈

SELECT TRUNC(1234.567) --1234
        , TRUNC(1234.567, 0) --1234
        , TRUNC(1234.567, 1) --1234.5
        , TRUNC(1234.567, -1) --1230
FROM dual;

SELECT CEIL(1234.1) --1235
        , FLOOR(1234.1) --1234
FROM dual;

SELECT employee_id, salary, commission_pct
          ,salary+(salary*NVL(commission_pct,0))
          ,ROUND((salary+(salary*NVL(commission_pct,0)))/12, 1)
FROM employees;

SELECT LENGTH('HELLOORACLE') --11
        , LENGTH('안녕하세요'), LENGTHB('안녕하세요') --5, 15바이트
        , INSTR('HELLOORACLE', 'H') --1
        , INSTR('HELLOORACLE', 'L') --3
        , INSTR('HELLOORACLE', 'L', 5) --10, 5번째 문자부터 시작해서 'L'문자 찾기
        , INSTR('HELLOORACLE', 'X') --0
FROM dual;

SELECT SUBSTR('HELLOORACLE', 2, 3) --ELL
        , LPAD('HELLO', 8, '*') --***HELLO
        , 'BEGIN'||LTRIM('   HELLO   ')||'END' -- BEGINHELLO   END
        , 'BEGIN'||RTRIM('   HELLO   ')||'END' -- BEGIN   HELLOEND
        , 'BEGIN'||TRIM('   HELLO   ')||'END' -- BEGINHELLOEND
FROM dual;

SELECT employee_id, first_name
FROM employees
WHERE INSTR(first_name, 'e') = 2;

SELECT SYSDATE
        , MONTHS_BETWEEN(SYSDATE, '23/01/01')
        , ADD_MONTHS(SYSDATE, 1) "한달후날짜"
        , ADD_MONTHS(SYSDATE, -6) "6개월전 날짜"
        , LAST_DAY('23/02/16') "2월의 마지막일자"
        , NEXT_DAY(SYSDATE, '일요일')
FROM dual;

SELECT SYSDATE
        , SYSDATE+1 "내일날짜"
        , SYSDATE-1 "어제날짜"
        , SYSDATE - TO_DATE('23/01/01') "일수"
        , TRUNC(SYSDATE - TO_DATE('23/01/01')) "일수"
FROM dual; 

SELECT * FROM employees WHERE department_id=30; --OK
SELECT * FROM employees WHERE department_id='30'; --문자형 '30'이 숫자형 30으로 자동형변환됨
SELECT * FROM employees WHERE department_id='030'; --문자형 '30'이 숫자형 30으로 자동형변환됨

SELECT * FROM employees WHERE hire_date='03/05/18'; --문자형 '03/05/18'이 날짜형으로 자동형변환됨

SELECT TO_DATE('23/12/22') --23/12/22
        , TO_DATE('23-12-22') --23/12/22
        , TO_DATE('12-22-23 09:10:35', 'mm-dd-yy HH24:mi:ss') --23/12/22 시분초는 보이지 않지만, 실제로는 있음
        , TO_CHAR(SYSDATE) --23/08/16
        , TO_CHAR(SYSDATE, 'yy/mm/dd hh24:mi:ss')
FROM dual;

SELECT employee_id, hire_date
        , TRUNC(SYSDATE - hire_date) "오늘까지의 근무일수"
        , TRUNC(TO_DATE('22/12/31') - hire_date) "22/12/31까지 근무일수"
FROM employees;

SELECT employee_id, hire_date, TO_CHAR(hire_date, 'day')
FROM employees
WHERE TO_CHAR(hire_date, 'mm')='08';

SELECT TO_NUMBER('1,234.5', '9,999.9') --1234.5
        , TO_NUMBER('1,234,567.8', '9,999,999,999.9')
        , TO_CHAR(1234.5, '9,999.9') --'1,234.5'
        , TO_CHAR(1234567.8, '9,999,999,999.9')
FROM dual;

SELECT TO_CHAR(1234.5, '9,999,999.9') --1234.5
        , TO_CHAR(1234.5, '0,000,000.0') --1234.5
FROM dual;

SELECT TO_CHAR(1234.5, 'L9,999,999.00') --'\1,234.50'
FROM dual;

SELECT NVL2(commission_pct, '수당있음', '수당없음')
FROM employees;

SELECT employee_id, commission_pct, NVL2(commission_pct, TO_CHAR(commission_pct), '수당없음')
FROM employees;

SELECT NULLIF(10, 10)
        , NULLIF('hello', 'hi') --hello
FROM dual;

SELECT employee_id, department_id
FROM employees
WHERE department_id = NULL; --0건

SELECT employee_id, department_id
FROM employees
WHERE department_id IS NULL; --1건

SELECT employee_id, department_id
FROM employees
WHERE department_id <> NULL; --0건

SELECT employee_id, department_id
FROM employees
WHERE department_id IS NOT NULL; --106건

SELECT NVL(commission_pct, 0)
        , DECODE(commission_pct, null, 0, commission_pct)
FROM employees;

SELECT NVL2(commission_pct, '수당있음', '수당없음')
        , DECODE(commission_pct, null, '수당없음', '수당있음')
FROM employees;

SELECT employee_id, commission_pct
        , DECODE(commission_pct, null, '수당없음', 0.1, 'B등급', 'A등급')
FROM employees;

SELECT employee_id, commission_pct
        , CASE commission_pct WHEN 0.1 THEN 'B등급'
                              ELSE          'A등급'
          END
FROM employees;

SELECT employee_id, commission_pct
        , CASE WHEN commission_pct >= 0.6 THEN ' A'
                 WHEN commission_pct >= 0.5 THEN ' B'
                 WHEN commission_pct >= 0.4 THEN ' C'
                 WHEN commission_pct >= 0.3 THEN ' D'
                 WHEN commission_pct >= 0.2 THEN ' E'
                 WHEN commission_pct >= 0.1 THEN ' F'
                 --ELSE '수당없음'
                 WHEN commission_pct IS NULL THEN '수당없음'
          END
FROM employees;

SELECT COUNT(*) "전체사원수" --107
        , COUNT(commission_pct) "수당받는사원수"
        , COUNT(department_id) "부서배치받은사원수"
FROM employees;

SELECT SUM(salary) "총급여"
        , AVG(salary) "평균급여"
FROM employees;


SELECT MAX(salary), MIN(salary)
FROM employees;

SELECT department_id
        , COUNT(*) "부서별사원수"
        , MAX(salary) "부서의 최대급여"
        , AVG(salary) "부서의 평균급여"
FROM employees
GROUP BY department_id;

SELECT department_id, job_id, COUNT(*)
FROM employees
GROUP BY department_id, job_id
ORDER BY department_id;

SELECT department_id, job_id, COUNT(*)
FROM employees
GROUP BY ROLLUP(department_id, job_id)
ORDER BY department_id, COUNT(*);

SELECT department_id, AVG(salary), MAX(salary)
FROM employees
WHERE department_id IN (30, 50)
GROUP BY department_id
ORDER BY department_id;

SELECT department_id, AVG(salary), MAX(salary)
FROM employees
WHERE department_id IS NOT NULL
GROUP BY department_id
ORDER BY department_id;

SELECT department_id, AVG(salary), MAX(salary), MIN(salary)
FROM employees
GROUP BY department_id
HAVING AVG(salary)>=10000
ORDER BY department_id;

SELECT employee_id, hire_date, salary
FROM employees
--ORDER BY hire_date;
ORDER BY hire_date ASC;

SELECT employee_id, hire_date, salary
FROM employees
ORDER BY salary DESC;

SELECT employee_id, hire_date, salary
FROM employees
ORDER BY hire_date ASC, salary DESC;