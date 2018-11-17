drop table if EXISTS product;
drop table if EXISTS kuKang;

create table kuFang(
id  bigint PRIMARY KEY ,
identifier varchar(255),
name varchar(200)
);

create table product(
id  bigint PRIMARY KEY ,
identifier varchar(255),
name varchar(200),
gg varchar(200),
xh varchar(255)
);

