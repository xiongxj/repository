CREATE DATABASE USER_PHONE_LOG;

create table USER_PHONE_LOG.USERPHONELOG (
    id int primary key auto_increment,
    option_date datetime,
    platform varchar(300),
    phone_type varchar(300),
    factory varchar(500),
    hardware_version varchar(32),
    os_version varchar(500),
    application_version varchar(500),
    errorMsg varchar(2000)
);