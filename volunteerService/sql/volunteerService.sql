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
    id           int          not null auto_increment,
    requestText  varchar(255) not null,
    address      varchar(255) not null,
    isReady      bool default false,
    id_volunteer int,
    id_client    int          not null,
    primary key (id),
    foreign key (id_volunteer) references volunteer (id),
    foreign key (id_client) references client (id)
);