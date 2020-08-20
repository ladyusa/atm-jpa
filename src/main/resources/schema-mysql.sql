CREATE DATABASE atm;
USE atm;

CREATE TABLE customer (
  id INT NOT NULL,
  name VARCHAR(45) NOT NULL,
  pin TEXT NOT NULL,
PRIMARY KEY (id)
);


-- INSERT INTO customer (id,name,pin) VALUES (1,"Peter","$2a$12$accfSX/pvdNRbGBz5iNw.OUlKpAFTr9nE9tL8JjZgg4YHPX.5b9vi");
