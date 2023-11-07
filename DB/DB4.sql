--INLINE VIEW : FROM������ ����ϴ� SUBQUERY
--����� ���, �̸�, �޿��� ����Ͻÿ�. ���� �޿��� �޴� ������� ����Ѵ�
SELECT employee_id, first_name, salary
FROM employees
ORDER BY salary DESC;

--ROWNUM : ���ȣ
--����� ���ȣ, ���, �̸�, �޿��� ����Ͻÿ�.
SELECT ROWNUM, employee_id, first_name, salary
FROM employees;

--����� ���ȣ, ���, �̸�, �޿��� ����Ͻÿ�. ���� �޿��� �޴� ������� ����Ѵ�
SELECT ROWNUM, employee_id, first_name, salary
FROM employees
ORDER BY salary DESC;

SELECT ROWNUM, employee_id, first_name, salary
FROM (SELECT employee_id, first_name, salary
FROM employees
ORDER BY salary DESC
);

--TOP-N Query
--����� ���, �̸�, �޿��� ����Ͻÿ�. ���� �޿��� �޴� ��� 5�� ����Ѵ�
SELECT ROWNUM, employee_id, first_name, salary
FROM (SELECT employee_id, first_name, salary
FROM employees
ORDER BY salary DESC)
WHERE ROWNUM BETWEEN 1 AND 5;

--����� ���, �̸�, �޿��� ����Ͻÿ�. ���� �޿��� �޴� ������� �����Ͽ� 11~20��° ����� ����Ѵ�
SELECT ROWNUM, employee_id, first_name, salary
FROM (SELECT employee_id, first_name, salary
FROM employees
ORDER BY salary DESC)
WHERE ROWNUM BETWEEN 11 AND 20;  --0��

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
--Scalar SubQuery : SELECT������ ����ϴ� SubQuery
--����� ���, �μ���ȣ, �μ����� ����Ͻÿ�
SELECT employee_id, e.department_id, department_name
FROM employees e JOIN departments d ON (e.department_id = d.department_id);

SELECT employee_id, department_id
, (SELECT department_name
FROM departments
WHERE department_id = e.department_id)
FROM employees e;

--�μ����� 'IT'�� �μ��� �ٹ��ϴ� ������� ���, �̸��� ����Ͻÿ�
SELECT employee_id, first_name
FROM employees
WHERE department_id = (SELECT department_id FROM departments WHERE department_name = 'IT');

--�̸��� 'Bruce'�� ����� ���� �μ��� �ٹ��ϴ� ������� ���, �̸��� ����Ͻÿ�
SELECT employee_id, first_name
FROM employees
WHERE department_id = (SELECT department_id FROM employees WHERE first_name = 'Bruce')
AND first_name <> 'Bruce';

--�̸��� 'Bruce'�� ����� ���� �μ��� �ٹ��ϸ鼭
--�μ���ձ޿����� ���� �޿��� �޴� ����� ���, �̸�, �޿��� ����Ͻÿ�
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

