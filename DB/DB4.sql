--INLINE VIEW : FROM절에서 사용하는 SUBQUERY
--사원의 사번, 이름, 급여를 출력하시오. 많은 급여를 받는 사원부터 출력한다
SELECT employee_id, first_name, salary
FROM employees
ORDER BY salary DESC;

--ROWNUM : 행번호
--사원의 행번호, 사번, 이름, 급여를 출력하시오.
SELECT ROWNUM, employee_id, first_name, salary
FROM employees;

--사원의 행번호, 사번, 이름, 급여를 출력하시오. 많은 급여를 받는 사원부터 출력한다
SELECT ROWNUM, employee_id, first_name, salary
FROM employees
ORDER BY salary DESC;

SELECT ROWNUM, employee_id, first_name, salary
FROM (SELECT employee_id, first_name, salary
FROM employees
ORDER BY salary DESC
);

--TOP-N Query
--사원의 사번, 이름, 급여를 출력하시오. 많은 급여를 받는 사원 5명만 출력한다
SELECT ROWNUM, employee_id, first_name, salary
FROM (SELECT employee_id, first_name, salary
FROM employees
ORDER BY salary DESC)
WHERE ROWNUM BETWEEN 1 AND 5;

--사원의 사번, 이름, 급여를 출력하시오. 많은 급여를 받는 사원부터 정렬하여 11~20번째 사원만 출력한다
SELECT ROWNUM, employee_id, first_name, salary
FROM (SELECT employee_id, first_name, salary
FROM employees
ORDER BY salary DESC)
WHERE ROWNUM BETWEEN 11 AND 20;  --0건

SELECT *
FROM (SELECT ROWNUM rn, employee_id, first_name, salary
      FROM (SELECT employee_id, first_name, salary
            FROM employees
            ORDER BY salary DESC)
      )
WHERE rn BETWEEN 11 AND 20;

SELECT *
FROM (SELECT ROWNUM rn, a.*
         FROM (SELECT *
                   FROM employees
                   ORDER BY salary DESC) a
          )
WHERE rn BETWEEN 11 AND 20;

---------------------------------------------
--Scalar SubQuery : SELECT절에서 사용하는 SubQuery
--사원의 사번, 부서번호, 부서명을 출력하시오
SELECT employee_id, e.department_id, department_name
FROM employees e JOIN departments d ON (e.department_id = d.department_id);

SELECT employee_id, department_id
, (SELECT department_name
FROM departments
WHERE department_id = e.department_id)
FROM employees e;

--부서명이 'IT'인 부서에 근무하는 사원들의 사번, 이름을 출력하시오
SELECT employee_id, first_name
FROM employees
WHERE department_id = (SELECT department_id FROM departments WHERE department_name = 'IT');

--이름이 'Bruce'인 사원과 같은 부서에 근무하는 사원들의 사번, 이름을 출력하시오
SELECT employee_id, first_name
FROM employees
WHERE department_id = (SELECT department_id FROM employees WHERE first_name = 'Bruce')
AND first_name <> 'Bruce';

--이름이 'Bruce'인 사원과 같은 부서에 근무하면서
--부서평균급여보다 많은 급여를 받는 사원의 사번, 이름, 급여를 출력하시오
SELECT employee_id, first_name, salary
FROM employees e
WHERE department_id = (SELECT department_id FROM employees WHERE first_name = 'Bruce')
AND salary > (SELECT AVG(salary) FROM employees GROUP BY department_id HAVING department_id = e.department_id);


SELECT employee_id, first_name, salary
FROM employees
WHERE salary > (  SELECT AVG(salary)
                          FROM employees
                          WHERE  department_id = (SELECT department_id FROM employees WHERE first_name = 'Bruce') --5760
                        )
AND department_id = (SELECT department_id FROM employees WHERE first_name = 'Bruce');

SELECT employee_id, first_name, salary
FROM employees e
WHERE department_id = (SELECT department_id FROM employees WHERE first_name = 'Bruce')
AND salary > (SELECT AVG(salary) FROM employees WHERE department_id = e.department_id);

