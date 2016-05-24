CREATE DATABASE 'Shop';
USE 'Shop';

CREATE TABLE IF NOT EXISTS Product (
  prod_id INT AUTO_INCREMENT,
  prod_name VARCHAR(20) NOT NULL  ,
  price DOUBLE,
  PRIMARY KEY(prod_id));

CREATE TABLE IF NOT EXISTS Purchase (
  pur_id INT AUTO_INCREMENT NOT NULL,
  prod_id INT,
  quantity INT ,
  purchase_date DATE,
  PRIMARY KEY (pur_id),
  FOREIGN KEY (prod_id) REFERENCES Product(prod_id)
    ON UPDATE CASCADE
    ON DELETE RESTRICT);

INSERT INTO Product (prod_name, price) VALUES ('Bike','1000');
INSERT INTO Product (prod_name, price) VALUES ('NoteBook','5000');
INSERT INTO Product (prod_name, price) VALUES ('Phone','2000');
INSERT INTO Product (prod_name, price) VALUES ('Computer','10000');
INSERT INTO Product (prod_name, price) VALUES ('Car','1000000');

INSERT INTO Purchase (prod_id, quantity, purchase_date) VALUES (1,'12',now());
INSERT INTO Purchase (prod_id, quantity, purchase_date) VALUES (3,'30',now());
INSERT INTO Purchase (prod_id, quantity, purchase_date) VALUES (5,'4',now());
INSERT INTO Purchase (prod_id, quantity, purchase_date) VALUES (5,'4','2016-01-10');