
use studentdb_college;

create table teacher (
	teacher_id int primary key ,
    teacher_name varchar(20),
    teacher_email varchar(30),
    teacher_doj date
);
	
insert into teacher values(1,'Aashish',"aashish@gmail.com" , '2015-03-31');
insert into teacher values(2,'ved',"ved@gmail.com" , '2015-03-31');
insert into teacher values(3,'nitesh',"nitya@gmail.com" , '2015-03-31');
insert into teacher values(4,'tan',"tanya@gmail.com" , '2015-03-31');

update teacher
set teacher_doj='2023-01-22'
where teacher_id=1;

alter table teacher drop column student_id;

select * from teacher;