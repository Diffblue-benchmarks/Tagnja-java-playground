create database test default character set utf8mb4 collate utf8mb4_unicode_ci;
use test;
drop table if exists t_user;
create table t_user(
  id int(8) not null primary key auto_increment,
  name varchar(64) not null,
  gender int(8) null,
  birth_date varchar(64) null
);
/* data */
insert into t_user values (1, "tom", 1, "20190101"), (2, "Tony", 1, "20190201");