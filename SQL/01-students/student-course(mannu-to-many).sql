CREATE TABLE StudentNew (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(25) ,
    last_name varchar(20),
    email varchar(100)
);
CREATE TABLE CourseNew (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);
CREATE TABLE Student_Course (
    student_id INT NOT NULL,
    course_id INT ,
    PRIMARY KEY (student_id, course_id),
    FOREIGN KEY (student_id) REFERENCES StudentNew(id),
    FOREIGN KEY (course_id) REFERENCES CourseNew(id)
);


INSERT INTO StudentNew (name) VALUES ('Mike');
INSERT INTO StudentNew (name) VALUES ('Jack');
INSERT INTO StudentNew (name) VALUES ('Henry');

INSERT INTO CourseNew (name) VALUES ('Math');
INSERT INTO CourseNew (name) VALUES ('Science');
INSERT INTO CourseNew (name) VALUES ('History');

INSERT INTO Student_Course (student_id, course_id) VALUES (1, 1);
INSERT INTO Student_Course (student_id, course_id) VALUES (1, 2);
INSERT INTO Student_Course (student_id, course_id) VALUES (2, 2);
INSERT INTO Student_Course (student_id, course_id) VALUES (2, 3);
INSERT INTO Student_Course (student_id, course_id) VALUES (3, 1);
INSERT INTO Student_Course (student_id, course_id) VALUES (3, 2);
INSERT INTO Student_Course (student_id, course_id) VALUES (3, 3);



select teacher.* , courses.* from studentdb_college.courses inner join teacher where teacher.teacher_id = courses.teacher_id;


select * 
from studentnew as s right  join student_course 
on s.id=student_course.student_id
right  join coursenew on student_course.course_id=coursenew.id; 
-- where s.id=4;

-- select * from studentdb_college.coursenew right join student_course on  coursenew.id=student_course.course_id; 


