#0. show details of all employee
select * from organization.emp;

#1. Display all employee names in ascending order
select * from organization.emp 
order by EMPNO asc;

#2. Display all employees(all columns) in department 20 and 30
select * from emp where DEPTNO in (20,30); 

#3. Display all the employees who are managers
select * from emp where JOB='MANAGER';

#4. Display all the employees whose salary is between 2000 and 5000
select * from emp where SAL > 2000 and SAL<5000;

#5. Display all the employees whose commission is null
select * from emp where COMM is null ;

#6. Display emp_name,salary,comission,ctc(calculated column)
select emp.ENAME,emp.SAL,emp.COMM, (SAL + ifnull(comm , 0)) as ctc from emp;

#7. Display hire_date, current_date, tenure(calculated col) of the empl
select EMPNO,ENAME,HIREDATE ,   year(current_date) - year(HIREDATE) as tenure  from emp; 

#8. Display all the employees whose name starts with s
select * from emp where ENAME  like 'S%';

#9. Display unique department numbers from the employee table
select distinct DEPTNO from emp;

 #10. Display emp_name and job in lower case
select lower(ename),  lower(job) from emp;

#11. Select top 3 salary earning employee
select * from emp order by sal desc limit 3;

#12. Select clerks and Managers in department 10
select * from emp where JOB in ('CLERK', 'MANAGER');

#13. Display all clerks in asscending order of the department number 
select * from emp where job='CLERK' order by job asc;

#16. Display All employees in the same dept of 'SCOTT' 
select * from emp where DEPTNO=(select DEPTNO from emp where ENAME='SCOTT');

#17. Employees having same designation of SMITH
select * from emp where JOB=(select JOB from emp where ENAME='SMITH');


#19. Employees who have same salary of BLAKE
select * from emp where sal=(select sal from emp where ENAME='BLAKE');

#20. Display departmentwise number of employees
select DEPTNO,count(distinct EMPNO) as Number_employees from emp group by DEPTNO; 

#28. display deptname wise employee count greater than 3, display in descending order of deptname
 select dept.DNAME,dept.DEPTNO ,count(emp.EMPNO) as Employee_count from emp inner join
 dept on emp.DEPTNO=dept.DEPTNO group by emp.DEPTNO having count(emp.EMPNO) > 3 order by dept.DNAME desc;

--   	Created views of those queries		--  

#26. display all deptnames and corresponding employees if ANY
create or replace view department_DeptEmployees as
select emp.ename as employee_Name, emp.deptno,dept.DNAME from emp 
inner join dept on dept.deptno=emp.deptno order by deptno asc;

#18. Employee who are reproting under KING
create view reporting_king as
select * from emp where MGR=(select empno from emp where ENAME='KING');

#27. dipslay all deptnames where there are no employees
create view department_NoEmployees as
select dept.DNAME as Depart_name ,dept.DEPTNO from dept where dept.DEPTNO not in (select emp.DEPTNO from emp);

#29. Display all the empname and their manager names
create or replace view Emp_and_managers as
SELECT e1.empno ,e1.Ename AS EmployeeName, e2.Ename AS ManagerName
FROM EMP e1, EMP e2
WHERE e1.Mgr = e2.Empno;

alter table emp add column empAddress varchar(200);
-- alter table emp drop column empAddress ;
SELECT * FROM organization.reporting_king;
insert into organization.emp values(6033,'AASHISH','ANALYST',7839,'1983-01-12 00:00:00',2850.00,null,10,null);



CREATE role 'admin_read'@'localhost';
-- password 'root123';
grant select on emp_and_managers to 'admin_read'@'localhost';
grant select on reporting_king to 'admin_read'@'localhost';


CREATE USER admin_read1@localhost IDENTIFIED BY 'root123';
GRANT admin_read@localhost
to admin_read1@localhost;
SHOW GRANTS FOR admin_read1@localhost
using admin_read@localhost;

