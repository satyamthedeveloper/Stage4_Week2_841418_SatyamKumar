CREATE database IF NOT EXISTS  user_database;
use user_database;

create table if not exists  book (id int, title varchar(30), author varchar(30), price float);

insert into book values(1, 'JavaScript', 'Nick', 220.56);
insert into book values(2, 'Java', 'Mickel', 450.00);
