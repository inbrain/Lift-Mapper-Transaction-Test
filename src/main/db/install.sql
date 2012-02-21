drop database test_transaction;
create database test_transaction;
use test_transaction;

create table  user (
  id bigint(20) unsigned not null auto_increment,
  name varchar(20) not null,
  primary key (id)
) engine=innodb default charset=utf8;

create table contact (
  id bigint(20) unsigned not null auto_increment,
  name varchar(20) not null,
  primary key (id)
) engine=innodb default charset=utf8;
