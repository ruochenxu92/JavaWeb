1.setup development environment
	1.1 import development jar
		jstl jar
		mysql driver
		beanutils jar
		log4j
	1.2 setup package
		domain
		dao.impl
		service.impl
		web.controller
		web.UI
		utils
		web-inf/jsp save website jsp
	1.3 create database and tables
	
		create database day14_customer;
		use day14_customer;
		create table customer
		(
			id varchar(40) primary key,
			name varchar(40) not null,
			gender varchar(40) not null,
			birthday date,
			cellphone varchar(20) not null,
			email varchar(40),
			preference varchar(200),
			type varchar(100),
			Description varchar(255)
		);
		
		create table customer
		(
			id mediumint auto_increment,
			name varchar(40) not null,
			gender varchar(40) not null,
			birthday varchar(40),
			cellphone varchar(20) not null,
			email varchar(40),
			preference varchar(200),
			type varchar(100),
			description varchar(255),
			primary key(id)
		);
		
		insert into customer(name,gender, birthday, cellphone, email, preference, type, description)
values('aaac','male','1990-01-01','4342037334','xxu46@gmail.com','singing','VIP','empty')
		
		
		
		
		
		