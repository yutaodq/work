 drop table if EXISTS product;
 drop table if EXISTS kufang;

 create table product(
 id  bigint PRIMARY KEY ,
 identifier varchar(255),
 name varchar(200),
 gg varchar(200),
 xh varchar(255)
 );

 create table kufang(
 id  bigint PRIMARY KEY ,
 identifier varchar(255),
 name varchar(200),
 bz varchar(2000)
 );

