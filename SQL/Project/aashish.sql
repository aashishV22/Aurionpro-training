SELECT * FROM project.users;

INSERT INTO users (user_password, role_id, user_name) VALUES ('root@123', '1', 'aashish22');
INSERT INTO users (user_password, role_id, user_name) VALUES ('root@123', 2, 'nitesh@K');
INSERT INTO users (user_password, role_id, user_name) VALUES ('root@123', 1, 'vedang@B');
INSERT INTO users (user_password, role_id, user_name) VALUES ('root@123', 2, 'bignesh@P');
INSERT INTO users (user_password, role_id, user_name) VALUES ('root@123', 2, 'jignesh@A');


SELECT * FROM project.admin;

INSERT INTO admin (user_id, admin_fname, admin_lname) VALUES (1, 'Aashish', 'Verma');
INSERT INTO admin (user_id, admin_fname, admin_lname) VALUES (3, 'Vedang', 'Badawe');

SELECT * FROM project.role;

INSERT INTO role (role_id, role_name) VALUES (1, 'admin');
INSERT INTO role (role_id, role_name) VALUES (2, 'user');

SELECT * FROM project.customer;

INSERT INTO customer (customer_id, customer_email, customer_fname, customer_lname, user_id) VALUES (201, 'nitesh@gmail.com', 'Nitesh', 'K', 2);
INSERT INTO customer (customer_email, customer_fname, customer_lname, user_id) VALUES ('big@gmail.com', 'bignesh', 'Pa', 4);
INSERT INTO customer (customer_email, customer_fname, customer_lname, user_id) VALUES ('jig@gmail.com', 'gignesh', 'Agrawala', 5);

SELECT * FROM project.account;
INSERT INTO account(account_number, customer_id, type_id , account_balance, bank_id) VALUES (301, 201, 1001, 2000.00, 21231);
INSERT INTO account( customer_id, type_id , account_balance, bank_id) VALUES (201, 1002, 12345.00, 21231);

INSERT INTO account(customer_id, type_id , account_balance, bank_id) VALUES (203, 1002, 12040.00, 21232);

INSERT INTO account( customer_id, type_id , account_balance, bank_id) VALUES (202, 1002, 125.00, 21233);
INSERT INTO account( customer_id, type_id , account_balance, bank_id) VALUES (202, 1001, 12125.00, 21232);


create database bankdb;
