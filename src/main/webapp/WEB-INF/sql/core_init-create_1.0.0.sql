-- 创建库
create database cms character set utf8;

-- 参数类型
drop table if exists sys_option_type;
create table sys_option_type (
	id          char(32)		not null,
	name 		varchar(50) 	not null,		-- 名称
	orderid 	integer 		not null,		-- 排序号

	primary key (id)
)engine=innodb default charset=utf8;

-- 系统参数
drop table if exists sys_option;
create table sys_option(
	id          char(32)		not null,
	iniid 		varchar(50) 	not null,			-- 编号
	name 		varchar(50) 	not null,			-- 名称
	dvalue 		text		 	null,				-- 默认值
	nowvalue 	text		 	null,				-- 当前值
	description varchar(200) 	null,				-- 说明
	viewable 	integer not 	null,				-- 范围
	orderid 	integer not 	null,				-- 排序号
	validatejs 	varchar(100) 	null,				-- 验证规则
	type_id		char(32) 		not null,			-- 类型id

	primary key (id)
)engine=innodb default charset=utf8;