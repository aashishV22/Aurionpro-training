create database accountManagement;

CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    user_Fname VARCHAR(255),
    user_Lname VARCHAR(255),
    user_Username VARCHAR(255),
    user_password VARCHAR(255)
);
INSERT INTO users (user_Fname, user_Lname, user_Username, user_password) VALUES ('Aashish', 'Verma'   , 'aash02@gmail.com', 'root@123');
INSERT INTO users (user_Fname, user_Lname, user_Username, user_password) VALUES ('Bignesh', 'Patel'   , 'big08@gmail.com' , 'root@123');
INSERT INTO users (user_Fname, user_Lname, user_Username, user_password) VALUES ('Jignesh', 'Agrawal' , 'jig12@gmail.com' , 'root@123');
INSERT INTO users (user_Fname, user_Lname, user_Username, user_password) VALUES ('Nitesh' , 'Agrawala', 'nitu04@gmail.com', 'root@123');



SELECT * FROM users;



CREATE TABLE account (
    account_number INT PRIMARY KEY,
    account_type VARCHAR(255),
    account_name VARCHAR(255),
    account_balance INT,
    user_id INT,    
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

ALTER TABLE account DROP COLUMN account_name;
-- ALTER TABLE account MODIFY account_number BIGINT ;
-- ALTER TABLE account MODIFY account_balance BIGINT ;

INSERT INTO account (account_number, account_type, account_balance, user_id)
VALUES (100, 'saving', 1000, 1);

INSERT INTO account (account_type, account_balance, user_id)
VALUES (?, ?, ?);

INSERT INTO account ( account_type, account_balance, user_id)
VALUES ( 'current', 100, 2);

INSERT INTO account ( account_type, account_balance, user_id)
VALUES ('current', 122660, 3);
INSERT INTO account ( account_type, account_balance, user_id)
VALUES ('saving', 1340606, 4);

SELECT account.*, users.user_Fname,users.user_Lname,users.user_Username
FROM account inner JOIN users
on account.user_id = users.user_id where users.user_Username='aash02@gmail.com';

SELECT account.* FROM account inner JOIN users on account.user_id = users.user_id where users.user_Username= 'aash02@gmail.com';

SELECT account.*, users.user_id FROM account inner JOIN users on account.user_id = users.user_id where users.user_Username= (?) ;

CREATE TABLE transaction (
    transaction_id INT PRIMARY KEY auto_increment,
    account_no_sender INT,
    account_no_receiver INT,
    transaction_typeid 	INT,
    transaction_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_no_sender) REFERENCES account(account_number),
    FOREIGN KEY (account_no_receiver) REFERENCES account(account_number),
    FOREIGN KEY (transaction_typeid) REFERENCES transaction_type(transactiontype_id)
);



ALTER TABLE `accountmanagement`.`transaction` 
ADD COLUMN `transaction_amount` INT NOT NULL AFTER `transaction_time`;

INSERT INTO `accountmanagement`.`transaction` (`account_no_sender`, `account_no_receiver`, `transaction_typeid`, `transaction_amount`) VALUES ('100', '100', '300', '11');


create table transaction_type(
	transactiontype_id int primary key,
    transactiontype_name varchar(25)
);
INSERT INTO transaction_type (transactiontype_id , transactiontype_name)
VALUES (300,'deposit');
INSERT INTO transaction_type (transactiontype_id , transactiontype_name)
VALUES (301,'withdrawl');
INSERT INTO transaction_type (transactiontype_id , transactiontype_name)
VALUES (302,'transfer');


SELECT * FROM transaction where account_no_sender = 100;

SELECT * FROM transaction where account_no_sender = 100;


CREATE TABLE admin (
    id INT auto_increment PRIMARY KEY ,
    user_name VARCHAR(255),
    password VARCHAR(255)
);

INSERT INTO admin (user_name,password)
VALUES ('Raj', 'raj@123');

INSERT INTO admin (user_name,password)
VALUES ('Smita', 'smita@123');

