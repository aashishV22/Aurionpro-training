use practice;
insert into products value('P1','iPhone 15',70000,5,180);
insert into products value('P2'	,'SamSong'	,60000,7,118);
insert into products value( 'P3','Moto',45000,42,124);
alter table products 
add primary key(product_code);

create table sales
(
	order_id int,
    order_date date,
    product_code varchar(5),
    quantity_ordered int,
    sale_price float
);
alter table sales add primary key(order_id);

--   Read  --  
select * from sales;
select * from products;

drop procedure if exists buy_products;
delimiter $$
create procedure buy_products()
begin 
	declare b_product_code varchar(3);
    declare b_product_price float;
select product_code,product_price into b_product_code,b_product_price from products where product_code='P1';
insert into sales(order_date,product_code,quantity_ordered,sale_price)
	values(current_date,b_product_code,2,( b_product_price*2)   );
	
update products 
set quantity_remaining=(quantity_remaining-2), quantity_sold=(quantity_sold+2) where product_code='P1';
select 'Product sold';
end;
$$
delimiter ;


delimiter $$
create procedure buy_productsParameters (pr_product_code varchar(4),pr_quantity int)
begin 
	declare b_product_code varchar(3);
    declare b_product_price float;
    declare pr_count int;
    select count(1)
    into pr_count from products
    where product_code=pr_product_code 
    and quantity_remaining >= pr_quantity;
    
    if pr_count>0 then
		select product_code,product_price into b_product_code,b_product_price from products where product_code=pr_product_code;
		insert into sales(order_date,product_code,quantity_ordered,sale_price)
			values(current_date, b_product_code,pr_quantity, ( b_product_price*pr_quantity)   );
	
		update products 
		set quantity_remaining=(quantity_remaining- pr_quantity), quantity_sold=(quantity_sold+pr_quantity) where product_code= pr_product_code;
		select 'Product sold';
	else
		select 'Insufficient Quantity';
	end if;
end;
$$
delimiter ;

drop procedure if exists buy_productsParameters;

call buy_productsParameters  ('P3',1);








