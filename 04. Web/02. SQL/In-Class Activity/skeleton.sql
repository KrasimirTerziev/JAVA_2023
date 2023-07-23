-- 1. Write a SQL query to find the average salary of employees who have been hired before year 2000 incl. Round it down to the nearest integer.
SELECT floor(avg(salary)) FROM employees WHERE hire_date <= '2000-12-31';
-- 2. Write a SQL query to find all town names that end with a vowel (a,o,u,e,i).
-- Hint: MySQL right() function
SELECT * FROM towns WHERE RIGHT (name, 1) IN ('a', 'o', 'u', 'e', 'i');
-- 3. Write a SQL query to find all town names that start with a vowel (a,o,u,e,i).
SELECT * FROM towns(name, 1) IN ('a'', ''o'', ''u'', ''e'', ''i');
-- 4. Write a SQL query that outputs the name and the length of the town with the longest name.
SELECT name, length(name) as name_length FROM towns ORDER BY name_length DESC LIMIT 1;
-- 5. Write a SQL query that outputs the name and the length of the town with the shortest name.
SELECT name, LENGTH(name) AS name_length FROM towns ORDER BY name_length ASC LIMIT 1;
-- 6. Write a SQL query to find all employees with even IDs.
SELECT * FROM employees WHERE employee_id % 2 = 0;
-- 7. Write a SQL query to find the names and salaries of the employees that take the minimal salary in the company.
SELECT first_name, last_name, salary FROM employees WHERE salary = (select min(salary) from employees);
-- 8. Write a SQL query to find the names and salaries of the employees that have a salary that is up to 10% higher than the minimal salary for the company.
SELECT first_name, last_name, salary
FROM employees
WHERE salary <= 1.1 * (SELECT MIN(salary) FROM employees);
-- 9. Write a SQL query to find the full name, salary and department of the employees that take the minimal salary in their department.
SELECT e.first_name, e.last_name, e.salary, d.name AS department
FROM employees AS e JOIN departments AS d ON e.department_id = d.department_id
WHERE e.salary = (SELECT MIN(salary) FROM employees WHERE department_id = e.department_id);
-- 10. Write a SQL query to find the average salary in department #1.
SELECT AVG(salary) AS average_salary FROM employees WHERE department_id = 1;
-- 11. Write a SQL query to find the average salary in the "Sales" department.
SELECT AVG(salary) AS average_salary
FROM employees JOIN departments ON employees.department_id = departments.department_id
WHERE departments.name = 'Sales';
-- 12. Write a SQL query that outputs the number of employees in the "Sales" department.
SELECT COUNT(*) AS employee_count
FROM employees JOIN departments ON employees.department_id = departments.department_id
WHERE departments.name = 'Sales';
-- 13. Write a SQL query that outputs the number of employees that have manager.
SELECT COUNT(*) AS employee_count FROM employees WHERE manager_id IS NOT NULL;
-- 14. Write a SQL query that outputs the number of employees that don't have manager.
SELECT COUNT(*) AS employee_count FROM employees WHERE manager_id IS NULL;
-- 15. Write a SQL query to find all departments, along with the average salary for each of them.
SELECT departments.name AS department, AVG(employees.salary) AS average_salary
FROM departments LEFT JOIN employees ON departments.department_id = employees.department_id
GROUP BY departments.department_id;
-- 16. Write a SQL query to find all projects that took less than 1 year (365 days) to complete.
-- Hint: Datediff
SELECT * FROM projects WHERE DATEDIFF(end_date, start_date) < 365;
-- 17. Write a SQL query that outputs the number for employees from each town, grouped by department. For example how many people from Bellevue work in Sales. How many people from Calgary work in Marketing, and so on...
SELECT departments.name AS department, towns.name AS town, COUNT(*) AS employee_count
FROM employees
JOIN departments ON employees.department_id = departments.department_id
JOIN towns ON employees.address_id = towns.town_id
GROUP BY departments.department_id, towns.town_id;
-- 18. Write a SQL query that outputs the first and last name of all managers that have exactly 5 employees.
SELECT managers.first_name, managers.last_name
FROM employees AS managers
JOIN employees AS employees ON managers.employee_id = employees.manager_id
GROUP BY managers.employee_id
HAVING COUNT(*) = 5;
-- 19. Write a SQL query to find all employees along with their managers. For employees that do not have manager display the value "(no manager)".
SELECT e.first_name, e.last_name, IFNULL(m.first_name, '(no manager)') AS manager_name
FROM employees AS e
LEFT JOIN employees AS m ON e.manager_id = m.employee_id;
-- 20. Write a SQL query that outputs the names of all employees whose last name is exactly 5 characters long.
-- Hint: MySQL length
SELECT * FROM employees WHERE LENGTH(last_name) = 5;
-- 21. Write a SQL query that outputs the current date and time in the following format "`day.month.year hour:minutes:seconds:milliseconds`".
SELECT CONCAT(DATE_FORMAT(NOW(), '%d.%m.%Y %H:%i:%s'), ':', LPAD(MICROSECOND(NOW()), 6, '0')) AS current_datetime;
-- 22. Write a SQL query to display the average employee salary by department and job title. For example, the average salary in Engineering for Design Engineer is 32,700.
-- Hint: MySQL date functions
SELECT departments.name AS department, employees.job_title, AVG(employees.salary) AS average_salary
FROM employees JOIN departments ON employees.department_id = departments.department_id
GROUP BY departments.department_id, employees.job_title;
-- 23. Write a SQL query that outputs the town with most employees.
SELECT towns.name AS town, COUNT(*) AS employee_count
FROM employees
JOIN towns ON employees.address_id = towns.town_id
GROUP BY towns.town_id
ORDER BY employee_count DESC
LIMIT 1;
-- 24. Write a SQL query that outputs the number of managers from each town.
SELECT towns.name AS town, COUNT(*) AS manager_count
FROM employees
JOIN towns ON employees.address_id = towns.town_id
WHERE employees.employee_id IN (
SELECT manager_id
FROM employees)
GROUP BY towns.town_id;
-- 25. Write a SQL query to find the manager who is in charge of the most employees and his average salary.
SELECT m.first_name, m.last_name, COUNT(*) AS employee_count, AVG(e.salary) AS average_salary
FROM employees AS m JOIN employees AS e ON m.employee_id = e.manager_id
GROUP BY m.employee_id
ORDER BY employee_count DESC LIMIT 1;
-- 26. Write a SQL query that outputs the names of the employees who have worked on the most projects.
SELECT employees.first_name, employees.last_name
FROM employees JOIN projects ON employees.employee_id = projects.project_id
GROUP BY employees.employee_id
HAVING COUNT(*) = (SELECT COUNT(*) FROM projects GROUP BY employee_id ORDER BY COUNT(*) DESC LIMIT 1);