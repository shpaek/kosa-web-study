SELECT employee_id, first_name, department_id
FROM employees; --107명

SELECT department_id, department_name
FROM departments; --27건

--카티션프로덕트
--사원의 사번, 이름, 부서번호, 부서명을 출력하시오(107명*27건)
SELECT employee_id, first_name, e.department_id,
         d.department_id, department_name
FROM employees e, departments d;

--사원의 사번, 이름, 부서번호, 부서명을 출력하시오(106명)
SELECT employee_id, first_name, e.department_id,
         d.department_id, department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id;

--INNER JOIN
--표준화된 ANSI JOIN법
--1) JOIN ON
SELECT employee_id, first_name, e.department_id,
         d.department_id, department_name
FROM employees e JOIN departments d
ON (e.department_id = d.department_id);

--사원의 사번, 이름, 부서번호, 부서명, 부서가 속한 도시명을 출력하시오
SELECT employee_id, first_name, e.department_id,
         d.department_id, department_name,
         city
FROM employees e JOIN departments d ON (e.department_id = d.department_id)
		 JOIN locations l ON (d.location_id = l.location_id);


--2) NATURAL JOIN - 같은 컬럼끼리 JOIN이 자동으로 만들어짐
--사원의 사번, 이름, 직무번호, 직무명을 출력하시오(107명)
SELECT employee_id, first_name,
          j.job_id, job_title
FROM employees e JOIN jobs j ON (e.job_id=j.job_id);

SELECT employee_id, first_name,
          job_id, job_title
FROM employees NATURAL JOIN jobs;

--3)JOIN USING
--사원의 사번, 이름, 부서번호, 부서명을 출력하시오
SELECT employee_id, first_name,
         department_id, department_name
FROM employees NATURAL JOIN departments;

SELECT employee_id, first_name,
          department_id, department_name
FROM employees JOIN departments USING(department_id);


--4)OUTER JOIN
--사원의 사번, 이름, 부서번호, 부서명을 출력하시오. 단, 부서없는 사원도 출력하시오(107명)
SELECT employee_id, first_name,
          d.department_id, department_name
FROM employees e LEFT OUTER JOIN departments d ON (e.department_id = d.department_id);

--(오라클전용 OUTER JOIN)
SELECT employee_id, first_name,
          d.department_id, department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id(+);

--사원의 사번, 이름, 부서번호, 부서명을 출력하시오. 단, 사원없는 부서도 출력하시오(122건)
SELECT employee_id, first_name,
          d.department_id, department_name
FROM employees e RIGHT JOIN departments d ON (e.department_id = d.department_id);

--사원의 사번, 이름, 부서번호, 부서명을 출력하시오. 단, 부서없는 사원도, 사원없는 부서도 출력하시오(123건)
SELECT employee_id, first_name,
          d.department_id, department_name
FROM employees e FULL JOIN departments d ON (e.department_id = d.department_id);
--(오라클전용 full outer join은 제공 안 함)

--5)SELF JOIN
--사원의 사번, 이름, 관리자번호, 관리자이름을 출력하시오
SELECT e.employee_id "사번", e.first_name "이름"
    , e.manager_id "관리자번호", m.first_name "관리자이름"
FROM employees e JOIN employees m ON(e.manager_id = m.employee_id);

--사원의 사번, 이름, 관리자번호, 관리자이름을 출력하시오, 관리자가 없는 사원도 출력하시오(107명)
SELECT e.employee_id "사번", e.first_name "이름"
    , e.manager_id "관리자번호", m.first_name "관리자이름"
FROM employees e LEFT JOIN employees m ON(e.manager_id = m.employee_id);

--실습
--1.부서의 부서번호, 부서가 속한 지역의 도시명(city), 국가명(country_name)을 출력하시오
SELECT department_id, city, country_name
FROM departments d JOIN locations l ON (d.location_id = l.location_id)
JOIN countries c ON (l.country_id = c.country_id);

--2. 사원의 사번, 부서번호, 부서명, 직무번호, 직무명을 출력하시오
SELECT employee_id, e.department_id
, department_name, e.job_id, job_title
FROM employees e JOIN departments d ON (e. department_id = d.department_id)
JOIN jobs j ON (e.job_id = j.job_id)
WHERE INSTR(job_title, 'Manager')>=1
ORDER BY job_id ASC, department_name ASC;

--3. 부서별 부서번호, 부서명, 사원수, 평균급여를 출력하시오
SELECT d.department_id "부서번호", department_name "부서명"
, COUNT(employee_id) "사원수", AVG(salary) "평균급여"
FROM departments d JOIN employees e ON (d.department_id = e.department_id)
GROUP BY d.department_id, department_name;

--4. 부서별 사원수가 10명이상인 부서들의 부서별 부서번호, 부서명, 사원수, 평균급여를 출력하시오
SELECT d.department_id "부서번호", department_name "부서명"
, COUNT(employee_id) "사원수", AVG(salary) "평균급여"
FROM departments d JOIN employees e ON (d.department_id = e.department_id)
GROUP BY d.department_id, department_name
HAVING COUNT(employee_id) >= 10;

--5.사원의 부서번호와 관리자의 부서번호가 일치하지않는 사원들 사번, 부서번호를 출력하시오 
--사번순으로 오름차순 정렬하시오
SELECT employee_id "사번", e.department_id "부서번호"
FROM employees e JOIN departments d ON(e.manager_id = d.manager_id)
WHERE e.department_id <> d.department_id
ORDER BY employee_id ASC;

--6. 각 도시에 있는 부서수를 출력하시오
SELECT city "도시", COUNT(department_id) "부서수"
FROM locations l JOIN departments d ON (l.location_id = d.location_id)
GROUP BY city;

--7.각 도시에 있는 부서수를 출력하시오.  단, 부서가 없는 도시도 모두 출력하시오
SELECT city "도시", COUNT(department_id) "부서수"
FROM locations l LEFT JOIN departments d ON (l.location_id = d.location_id)
GROUP BY city;
--

SELECT *
FROM job_history;

SELECT *
FROM employees
WHERE employee_id=176;

--사원의 사번, 이전직무번호를 출력하시오
--사원의 사번, 직무번호를 출력하시오
SELECT employee_id, job_id
FROM job_history
UNION
SELECT employee_id, job_id
FROM employees;

SELECT employee_id, job_id
FROM job_history
UNION ALL
SELECT employee_id, job_id
FROM employees
ORDER BY employee_id;

SELECT employee_id, job_id
FROM employees
MINUS
SELECT employee_id, job_id
FROM job_history;

SELECT employee_id, job_id
FROM employees
INTERSECT
SELECT employee_id, job_id
FROM job_history;

--최대급여자의 사번, 이름, 급여를 출력하시오
--1)최대급여를 계산한다
SELECT MAX(salary)
FROM employees;
--2) 1)과 같은 급여를 받는 사원의 사번, 이름, 급여를 출력하시오
SELECT employee_id, first_name, salary
FROM employees
WHERE salary = (SELECT MAX(salary)
FROM employees
);

--사원들의 평균급여보다 많은 급여를 받는 급여자의 사번, 이름, 급여를 출력하시오
--1)사원들의 평균 급여를 계산한다
SELECT AVG(salary)
FROM employees;
--2) 1)보다 많은 급여를 받는 급여자의 사번, 이름, 급여를 출력하시오
SELECT employee_id, first_name, salary
FROM employees
WHERE salary > (SELECT AVG(salary)
FROM employees
);

--부서별 최대급여를 받는 사원의 부서번호, 사번, 이름, 급여를 출력하시오
--1)부서별 최대급여를 계산한다
SELECT department_id, MAX(salary)
FROM employees
GROUP BY department_id;
--2) 1)과 같은 급여를 받는 사원의 부서번호, 사번, 이름, 급여를 출력하시오
SELECT department_id, employee_id, first_name, salary
FROM employees
WHERE (department_id, salary) IN (SELECT department_id, MAX(salary)
FROM employees
GROUP BY department_id
);

SELECT employee_id, first_name
FROM employees
WHERE employee_id IN (SELECT manager_id FROM employees);

SELECT employee_id, first_name
FROM employees
WHERE employee_id NOT IN (SELECT manager_id FROM employees);

