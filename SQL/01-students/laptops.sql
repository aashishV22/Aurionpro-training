use studentdb_college;

create table laptops
(
	laptop_id int,
    foreign key ( laptop_id) REFERENCES student(student_id),
    laptop_name varchar(15),
    laptop_price double,
    laptop_doPurchase date
);
alter table laptopslaptops
add primary  key ( laptop_id) ;
alter table laptops
drop foreign key  laptop_id;


INSERT INTO laptops VALUES(1,'accer',50000.32,'2019-2-23');
INSERT INTO laptops VALUES(2,'hp',60000.32, '2012-01-31' );

INSERT INTO laptops VALUES(3,'dell',70000.32 , '2015-03-31');
INSERT INTO laptops VALUES(4,'lenovo',40000.32 , '2017-05-04');


select * from laptops; 
