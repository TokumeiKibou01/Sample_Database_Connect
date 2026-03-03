create database test;
use test;
create table test_table(
    id int primary key auto_increment,
    name varchar(255),
    class varchar(10)
);

insert into test.test_table(name, class) values('あああさん', '1-1');

create user 'test_user'@'%' identified by 'testpass';
grant all privileges on test.* to 'test_user'@'%';
flush privileges;