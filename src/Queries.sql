create database employeemanagementsystem;

show databases;

use employeemanagementsystem;

create table login(username varchar(20),password varchar(20));

insert into login values('admin','12345');

select * from login;

create table employee(name varchar(20),fname varchar(20),d varchar(30),salary varchar(30),address varchar(100),phone varchar(20),email varchar(40),education varchar(20),designation varchar(30), aadhar varchar(25),employeeid varchar(15));

select * from employee;