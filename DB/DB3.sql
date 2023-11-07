SELECT employee_id, first_name, department_id
FROM employees; --107��

SELECT department_id, department_name
FROM departments; --27��

--īƼ�����δ�Ʈ
--����� ���, �̸�, �μ���ȣ, �μ����� ����Ͻÿ�(107��*27��)
SELECT employee_id, first_name, e.department_id,
         d.department_id, department_name
FROM employees e, departments d;

--����� ���, �̸�, �μ���ȣ, �μ����� ����Ͻÿ�(106��)
SELECT employee_id, first_name, e.department_id,
         d.department_id, department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id;

--INNER JOIN
--ǥ��ȭ�� ANSI JOIN��
--1) JOIN ON
SELECT employee_id, first_name, e.department_id,
         d.department_id, department_name
FROM employees e JOIN departments d
ON (e.department_id = d.department_id);

--����� ���, �̸�, �μ���ȣ, �μ���, �μ��� ���� ���ø��� ����Ͻÿ�
SELECT employee_id, first_name, e.department_id,
         d.department_id, department_name,
         city
FROM employees e JOIN departments d ON (e.department_id = d.department_id)
		 JOIN locations l ON (d.location_id = l.location_id);


--2) NATURAL JOIN - ���� �÷����� JOIN�� �ڵ����� �������
--����� ���, �̸�, ������ȣ, �������� ����Ͻÿ�(107��)
SELECT employee_id, first_name,
          j.job_id, job_title
FROM employees e JOIN jobs j ON (e.job_id=j.job_id);

SELECT employee_id, first_name,
          job_id, job_title
FROM employees NATURAL JOIN jobs;

--3)JOIN USING
--����� ���, �̸�, �μ���ȣ, �μ����� ����Ͻÿ�
SELECT employee_id, first_name,
         department_id, department_name
FROM employees NATURAL JOIN departments;

SELECT employee_id, first_name,
          department_id, department_name
FROM employees JOIN departments USING(department_id);


--4)OUTER JOIN
--����� ���, �̸�, �μ���ȣ, �μ����� ����Ͻÿ�. ��, �μ����� ����� ����Ͻÿ�(107��)
SELECT employee_id, first_name,
          d.department_id, department_name
FROM employees e LEFT OUTER JOIN departments d ON (e.department_id = d.department_id);

--(����Ŭ���� OUTER JOIN)
SELECT employee_id, first_name,
          d.department_id, department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id(+);

--����� ���, �̸�, �μ���ȣ, �μ����� ����Ͻÿ�. ��, ������� �μ��� ����Ͻÿ�(122��)
SELECT employee_id, first_name,
          d.department_id, department_name
FROM employees e RIGHT JOIN departments d ON (e.department_id = d.department_id);

--����� ���, �̸�, �μ���ȣ, �μ����� ����Ͻÿ�. ��, �μ����� �����, ������� �μ��� ����Ͻÿ�(123��)
SELECT employee_id, first_name,
          d.department_id, department_name
FROM employees e FULL JOIN departments d ON (e.department_id = d.department_id);
--(����Ŭ���� full outer join�� ���� �� ��)

--5)SELF JOIN
--����� ���, �̸�, �����ڹ�ȣ, �������̸��� ����Ͻÿ�
SELECT e.employee_id "���", e.first_name "�̸�"
    , e.manager_id "�����ڹ�ȣ", m.first_name "�������̸�"
FROM employees e JOIN employees m ON(e.manager_id = m.employee_id);

--����� ���, �̸�, �����ڹ�ȣ, �������̸��� ����Ͻÿ�, �����ڰ� ���� ����� ����Ͻÿ�(107��)
SELECT e.employee_id "���", e.first_name "�̸�"
    , e.manager_id "�����ڹ�ȣ", m.first_name "�������̸�"
FROM employees e LEFT JOIN employees m ON(e.manager_id = m.employee_id);

--�ǽ�
--1.�μ��� �μ���ȣ, �μ��� ���� ������ ���ø�(city), ������(country_name)�� ����Ͻÿ�
SELECT department_id, city, country_name
FROM departments d JOIN locations l ON (d.location_id = l.location_id)
JOIN countries c ON (l.country_id = c.country_id);

--2. ����� ���, �μ���ȣ, �μ���, ������ȣ, �������� ����Ͻÿ�
SELECT employee_id, e.department_id
, department_name, e.job_id, job_title
FROM employees e JOIN departments d ON (e. department_id = d.department_id)
JOIN jobs j ON (e.job_id = j.job_id)
WHERE INSTR(job_title, 'Manager')>=1
ORDER BY job_id ASC, department_name ASC;

--3. �μ��� �μ���ȣ, �μ���, �����, ��ձ޿��� ����Ͻÿ�
SELECT d.department_id "�μ���ȣ", department_name "�μ���"
, COUNT(employee_id) "�����", AVG(salary) "��ձ޿�"
FROM departments d JOIN employees e ON (d.department_id = e.department_id)
GROUP BY d.department_id, department_name;

--4. �μ��� ������� 10���̻��� �μ����� �μ��� �μ���ȣ, �μ���, �����, ��ձ޿��� ����Ͻÿ�
SELECT d.department_id "�μ���ȣ", department_name "�μ���"
, COUNT(employee_id) "�����", AVG(salary) "��ձ޿�"
FROM departments d JOIN employees e ON (d.department_id = e.department_id)
GROUP BY d.department_id, department_name
HAVING COUNT(employee_id) >= 10;

--5.����� �μ���ȣ�� �������� �μ���ȣ�� ��ġ�����ʴ� ����� ���, �μ���ȣ�� ����Ͻÿ� 
--��������� �������� �����Ͻÿ�
SELECT employee_id "���", e.department_id "�μ���ȣ"
FROM employees e JOIN departments d ON(e.manager_id = d.manager_id)
WHERE e.department_id <> d.department_id
ORDER BY employee_id ASC;

--6. �� ���ÿ� �ִ� �μ����� ����Ͻÿ�
SELECT city "����", COUNT(department_id) "�μ���"
FROM locations l JOIN departments d ON (l.location_id = d.location_id)
GROUP BY city;

--7.�� ���ÿ� �ִ� �μ����� ����Ͻÿ�.  ��, �μ��� ���� ���õ� ��� ����Ͻÿ�
SELECT city "����", COUNT(department_id) "�μ���"
FROM locations l LEFT JOIN departments d ON (l.location_id = d.location_id)
GROUP BY city;
--

SELECT *
FROM job_history;

SELECT *
FROM employees
WHERE employee_id=176;

--����� ���, ����������ȣ�� ����Ͻÿ�
--����� ���, ������ȣ�� ����Ͻÿ�
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

--�ִ�޿����� ���, �̸�, �޿��� ����Ͻÿ�
--1)�ִ�޿��� ����Ѵ�
SELECT MAX(salary)
FROM employees;
--2) 1)�� ���� �޿��� �޴� ����� ���, �̸�, �޿��� ����Ͻÿ�
SELECT employee_id, first_name, salary
FROM employees
WHERE salary = (SELECT MAX(salary)
FROM employees
);

--������� ��ձ޿����� ���� �޿��� �޴� �޿����� ���, �̸�, �޿��� ����Ͻÿ�
--1)������� ��� �޿��� ����Ѵ�
SELECT AVG(salary)
FROM employees;
--2) 1)���� ���� �޿��� �޴� �޿����� ���, �̸�, �޿��� ����Ͻÿ�
SELECT employee_id, first_name, salary
FROM employees
WHERE salary > (SELECT AVG(salary)
FROM employees
);

--�μ��� �ִ�޿��� �޴� ����� �μ���ȣ, ���, �̸�, �޿��� ����Ͻÿ�
--1)�μ��� �ִ�޿��� ����Ѵ�
SELECT department_id, MAX(salary)
FROM employees
GROUP BY department_id;
--2) 1)�� ���� �޿��� �޴� ����� �μ���ȣ, ���, �̸�, �޿��� ����Ͻÿ�
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

