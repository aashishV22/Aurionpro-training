create database practice;

create table employee 
(
  emp_id int primary key,
  first_name varchar(40),
  last_name varchar(40),
  birth_day date,
  sex varchar(1),
  salary int,
  super_id int,
  branch_id int
);

create table branch (
  branch_id int primary key,
  branch_name varchar(40),
  mgr_id int,
  mgr_start_date date,
  foreign key(mgr_id) references employee(emp_id) on delete set null
);

ALTER TABLE employee
ADD FOREIGN KEY(branch_id)
REFERENCES branch(branch_id)
ON DELETE SET NULL;
 
ALTER TABLE employee
ADD FOREIGN KEY(super_id)
REFERENCES employee(emp_id)
ON DELETE SET NULL;