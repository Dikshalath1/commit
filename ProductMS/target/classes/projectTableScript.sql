drop database if exists ProductDB;
create schema `ProductDB`;
use `ProductDB`;

create table product(
prod_id integer auto_increment primary key,
product_name varchar(100),
price float,
stock integer,
description varchar(200),
image varchar(100),
seller_id integer,
category varchar(100),
subcategory varchar(100),
product_rating integer
);

insert into product values(1,'Alisha Solid Womens Cycling shorts',500.00,50,'Key features of Alisha Solid womens Cycling Shorts Cotton lycra Navy,Red,Navy,Specifications of Alisha Solid womens Cycling shorts','http://img5a.flixcart.com/image/short/u/4/a/altht-3p-21-alisha-38-original-imaeh2d5vm5zbtgg.jpeg',7,'Clothing','Womens Clothing',null);
insert into product values(2,'levis solid fit jeans',800.00,100,'key features of levis solid fit jeans dark black,blue','http://img5a.flixcart.com/image/short/u/4/a/altht-3p-21-alisha-38-original-imaeh2d5vm5zbtgg.jpeg',8,'Clothing','Womens Clothing',null);

create table subscribedproduct(
buyer_id integer,
prod_id integer,
quantity integer,
primary key(buyer_id,prod_id)
);

insert into subscribedproduct values(1,10,5);
insert into subscribedproduct values(2,11,3);

select * from product;
