drop table if EXISTS product;

create table product(
id  bigint PRIMARY KEY ,
identifier varchar(255),
name varchar(200),
model varchar(200),
size varchar(255)
);

