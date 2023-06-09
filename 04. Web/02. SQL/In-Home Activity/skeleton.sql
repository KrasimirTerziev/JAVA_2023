-- 1. Write a SQL query that outputs all information about all departments.
SELECT * FROM departments;
-- 2. Write a SQL query that outputs all department names.
SELECT name FROM departments;
-- 3. Write a SQL query that outputs first and last name of each employee, along with their salary.
SELECT first_name, last_name, salary FROM employees;
-- 4. Write a SQL query that outputs the full name of each employee.
SELECT CONCAT(first_name, ' ', last_name) AS FullName FROM employees;
-- 5. Write a SQL query to generate an email addresses for each employee. Consider that the email domain is company.com. For example, John Doe's email would be "John.Doe@company.com". The produced column should be named "Full Email Addresses".
SELECT CONCAT(first_name, ' ', last_name, 'company.com') AS "Full Email Adresses" FROM employees;
-- 6. Write a SQL query to find all the different employee salaries.
SELECT DISTINCT salary FROM employees;
-- 7. Write a SQL query that outputs all information about the employees whose job title is "Sales Representative".
SELECT * FROM employees WHERE job_title = 'Sales Representative';
-- 8. Write an SQL query to find all employees who have a salary that is bigger than their manager's.
SELECT * FROM employees w, employees m WHERE w.manager_id = m.employee_id AND w.salary > m.salary;
-- 9. Write a SQL query to find the names of all employees whose first name starts with "SA".
SELECT * FROM employees WHERE first_name LIKE 'SA%';
-- 10. Write a SQL query to find the names of all employees whose last name contains "ei".
SELECT * FROM employees WHERE last_name LIKE '%ei%';
-- 11. Write a SQL query to find all employees whose salary is in the range [20000…30000].
SELECT * FROM employees WHERE salary BETWEEN 20000 AND 30000;
-- 12. Write a SQL query to find the names of all employees whose salary is 25000, 14000, 12500 or 23600.
SELECT * FROM employees WHERE salary IN (25000, 14000, 12500, 23600);
-- 13. Write a SQL query to find all employees that do not have manager.
SELECT * FROM employees WHERE manager_id IS NULL;
-- 14. Write a SQL query to find the names of all employees who were hired before their managers.
SELECT e.first_name, e.last_name,e.hire_date FROM employees e JOIN employees m ON e.manager_id = m.employee_id WHERE e.hire_date < m.hire_date;
-- 15. Write a SQL query to find all employees whose salary is more than 50000. Order them in decreasing order, based on their salary.
SELECT * FROM employees WHERE salary > 50000 ORDER BY salary DESC;
-- 16. Write a SQL query to find the top 5 best paid employees.
SELECT * FROM employees ORDER BY salary DESC LIMIT 5;
-- 17. Write a SQL query that outputs all employees along their address.
SELECT e.*, a.* FROM employees AS e JOIN addresses AS a ON e.address_id = a.address_id;
-- 18. Write a SQL query to find all employees whose middle name is the same as the first letter of their town.
SELECT * FROM employees AS e JOIN towns AS t ON SUBSTRING(e.middle_name, 1, 1) = LEFT(t.town_id, 1);
-- 19. Write a SQL query that outputs all employees (first and last name) that have a manager, along with their manager (first and last name).
SELECT
    e.first_name AS employee_first_name,
    e.last_name AS employee_last_name,
    m.first_name AS manager_first_name,
    m.last_name AS manager_last_name
FROM employees e
JOIN employees m ON e.manager_id = m.employee_id;
-- 20. Write a SQL query that outputs all employees that have a manager (first and last name), along with their manager (first and last name) and the employee's address.
SELECT
    e.first_name AS employee_first_name,
    e.last_name AS employee_last_name,
    m.first_name AS manager_first_name,
    m.last_name AS manager_last_name
FROM employees e
JOIN employees m ON e.manager_id = m.employee_id
JOIN addresses a on e.address_id = a.address_id;
-- 21. Write a SQL query to find all departments and all town names in a single column.
SELECT name FROM departments UNION SELECT name FROM towns;
-- 22. Write a SQL query to find all employees and their manager, along with the employees that do not have manager. If they do not have a manager, output "n/a".
SELECT e.first_name, e.last_name, IFNULL(m.first_name, 'n/a') AS ManagerFirstName, IFNULL(m.last_name, 'n/a') AS ManagerLastName
FROM Employees AS e LEFT JOIN Employees AS m ON e.manager_id = m.employee_id;
-- 23. Write a SQL query to find the names of all employees from the departments "Sales" AND "Finance" whose hire year is between 1995 and 2005.
SELECT e.first_name, e.last_name FROM employees AS e
JOIN departments AS d ON e.department_id = d.department_id
WHERE d.department_id IN('Sales', 'Finance')
and YEAR(e.hire_date) BETWEEN 1995 AND 2005;