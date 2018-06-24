drop table if EXISTS tb_license;

drop table if EXISTS tb_organization;

create table tb_license(
license_id varchar(255) PRIMARY KEY ,
product_name varchar(200),
license_name varchar(200),
origanization_id varchar(255)
);

create table tb_organization(
organization_id varchar(255) PRIMARY KEY ,
organization_name varchar(200),
contact_name varchar(200),
contact_email varchar(200)
);

create table product_entry(
identifier varchar(255) PRIMARY KEY ,
name varchar(200),
model varchar(200),
size varchar(255)
);
