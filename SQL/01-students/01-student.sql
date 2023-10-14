create database studentdb_college;

use studentdb_college;

create Table student (
	student_id INT PRIMARY KEY ,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    percentage DOUBLE
);

INSERT INTO student VALUES(1,'AASHISH','VERMA',80.0);
INSERT INTO student VALUES(2,'VED','BADAWE',70.0);
INSERT INTO student VALUES(3,'TAN','bHATAM',60.0);
INSERT INTO student VALUES(4,'AASHISH','KUMAWAT',60.0);

UPDATE 	student set first_name = "Nitesh" where student_id=4;

alter table student add city varchar(30);
UPDATE 	student set city = "Mumbai" where student_id=1;

alter table student add dob date;
update student set dob="2002-01-22" where student_id=1;
update student set dob="2000-03-12" where student_id=2;
update student set dob="2000-09-23" where student_id=3;
update student set dob="2002-12-04" where student_id=4;

select * from student 
where year(dob)<='2000';

alter table student add laptop_id int;
alter table student
add foreign key ( laptop_id) REFERENCES laptops(laptop_id);

update student  set laptop_id=1 where student_id=2;

select student.* , laptops.* from studentdb_college.student inner join laptops where student.laptop_id = laptops.laptop_id;

alter table student add  course_id int;
alter table student
add foreign key(course_id) references courses(course_id);

UPDATE student SET course_id = '101' WHERE student_id = 1;







SELECT * FROM studentdb_college.student;