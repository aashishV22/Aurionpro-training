use studentdb_college;

create Table courses (
	course_id INT PRIMARY KEY ,
    course_name VARCHAR(20),
    teacher_id int,
    foreign key ( teacher_id)references teacher(teacher_id),
    course_dos Date,
    course_doe date
);


INSERT INTO courses VALUES(101,'java',2,'2012-03-03' , '2015-03-31');
INSERT INTO courses VALUES(102,'python',1,'2012-03-03' , '2015-03-31');
INSERT INTO courses VALUES(103,'c#',3,'2012-03-03' , '2015-03-31');
INSERT INTO courses VALUES(104,'ML',4,'2012-03-03' , '2015-03-31');
INSERT INTO courses VALUES(105,'AI',2,'2012-03-03' , '2015-03-31');

select teacher.* , courses.* from studentdb_college.courses inner join teacher where teacher.teacher_id = courses.teacher_id;

alter table courses
add student_id int;

select * from courses