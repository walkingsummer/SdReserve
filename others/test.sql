osql ?/
osql -S localhost -U sa;
use demoTest
GO

select * from T_GOODS
GO

drop table T_GOODS;

CREATE TABLE T_GOODS(
  GOODS_ID INT not null IDENTITY (1,1),
  GOODS_NAME VARCHAR(20),
  GOODS_NUMBER VARCHAR(20),
  INVENTORY_AMOUNT INT,
  COST_PRICE MONEY,
  CREATE_TIME DATETIME,

);

alter table T_GOODS add constraint pk1_goods_id primary key(goods_id);

-- drop index goods_id_index on t_goods;
-- create unique index goods_id_index on t_goods (goods_id asc);

drop sequence goods_id_seq;
create sequence goods_id_seq minvalue 1 maxvalue 99999999 start with 1 increment by 1 cache 20;
select next value for goods_id_seq;


insert into T_GOODS(

  GOODS_NAME ,
  GOODS_NUMBER ,
  INVENTORY_AMOUNT ,
  COST_PRICE ,
  CREATE_TIME
) values(

  '测试商品001',
  '商品编号001',
  1000,
  123.45,
  getdate()
);