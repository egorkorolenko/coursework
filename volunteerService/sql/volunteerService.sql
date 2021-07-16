DROP DATABASE IF EXISTS volunteerService;
CREATE DATABASE volunteerService;
USE `volunteerService`;

create table vol(
id int not null auto_increment,
login varchar(255),
primary key (id)
)