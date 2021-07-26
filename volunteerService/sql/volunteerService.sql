DROP DATABASE IF EXISTS volunteerService;
CREATE DATABASE volunteerService;
USE `volunteerService`;

create table volunteer
(
    id        int          not null auto_increment,
    username  varchar(255) not null,
    birthdate varchar(255) not null,
    email     varchar(255) not null unique,
    login     varchar(255) not null unique,
    password  varchar(255) not null,
    primary key (id)
);

create table client
(
    id        int          not null auto_increment,
    username  varchar(255) not null,
    birthdate varchar(255) not null,
    email     varchar(255) not null unique,
    login     varchar(255) not null unique,
    password  varchar(255) not null,
    primary key (id)
);


create table request
(
    id               int          not null auto_increment,
    request_text     varchar(255) not null,
    address          varchar(255) not null,
    request_is_ready tinyint(1) default 0,
    id_client        int,
    id_volunteer     int,
    primary key (id),
    foreign key (id_volunteer) references volunteer (id),
    foreign key (id_client) references client (id)
);