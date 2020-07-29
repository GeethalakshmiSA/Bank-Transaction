create database bank_transaction;
use bank_transaction;
create table transaction (transaction_id int auto_increment, transaction_type varchar(20), amount float, balance float, primary key(transaction_id));
describe transaction;
insert into transaction values (01, 'Credit', 1000.00 , 11000.00);
insert into transaction (transaction_type , amount , balance) values ('Credit', 500.00 , 11500.00);
insert into transaction (transaction_type , amount , balance) values ('Debit', 2500.00 , 9000.00);
insert into transaction (transaction_type , amount , balance) values ('Credit', 900.00 , 9900.00);
insert into transaction (transaction_type , amount , balance) values ('Debit', 1500.00 , 8400.00);
insert into transaction (transaction_type , amount , balance) values ('Credit', 4500.00 , 12900.00);
insert into transaction (transaction_type , amount , balance) values ('Credit', 500.00 , 13400.00);
insert into transaction (transaction_type , amount , balance) values ('Debit', 20.00 , 13380.00);
insert into transaction (transaction_type , amount , balance) values ('Debit', 2320.00 , 11060.00);

insert into transaction (transaction_type , amount , balance) values ('Credit', 300.00 , 10360.00);
insert into transaction (transaction_type , amount , balance) values ('Debit', 7500.00 , 2860.00);


select * from transaction;





