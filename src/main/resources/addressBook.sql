CREATE DATABASE mybatis_demo;

use  mybatis_demo;

DROP TABLE IF EXISTS ADDRESS_BOOK;


create table ADDRESS_BOOK (
	id INT NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(50) ,
	last_name VARCHAR(50),
	work_phone VARCHAR(50) ,
	cell_phone VARCHAR(50),
	email_id VARCHAR(50) NOT NULL,
	date_of_birth DATE NOT NULL,
	street VARCHAR(50) NOT NULL,
	city VARCHAR(50) NOT NULL,
	state VARCHAR(50) NOT NULL,
	zip_code VARCHAR(50) NOT NULL,
	PRIMARY KEY (id)
) ENGINE=InnoDB;

insert into ADDRESS_BOOK (id, first_name, last_name, work_phone, cell_phone, email_id, date_of_birth, street, city, state, zip_code) values (1, 'Ossie', 'Dixie', '818-901-8127', '307-291-9618', 'odixie0@weather.com', '2008-04-13', '35 Redwing Lane', 'Burbank', 'California', '91520');
insert into ADDRESS_BOOK (id, first_name, last_name, work_phone, cell_phone, email_id, date_of_birth, street, city, state, zip_code) values (2, 'Gloriana', 'Nardoni', '513-266-6664', '505-985-1663', 'gnardoni1@boston.com', '1979-04-30', '5463 Glendale Trail', 'Cincinnati', 'Ohio', '45271');
insert into ADDRESS_BOOK (id, first_name, last_name, work_phone, cell_phone, email_id, date_of_birth, street, city, state, zip_code) values (3, 'Michell', 'Neachell', '432-135-0495', '202-575-5930', 'mneachell2@dyndns.org', '2018-05-11', '53 Esker Trail', 'Midland', 'Texas', '79710');
insert into ADDRESS_BOOK (id, first_name, last_name, work_phone, cell_phone, email_id, date_of_birth, street, city, state, zip_code) values (4, 'Kurtis', 'Garrioch', '608-678-3920', '614-269-6541', 'kgarrioch3@marriott.com', '2010-01-23', '72787 Hagan Trail', 'Madison', 'Wisconsin', '53705');
insert into ADDRESS_BOOK (id, first_name, last_name, work_phone, cell_phone, email_id, date_of_birth, street, city, state, zip_code) values (5, 'Letti', 'Masters', '720-229-4978', '717-171-3287', 'lmasters4@addtoany.com', '2008-05-01', '01046 Marcy Court', 'Aurora', 'Colorado', '80015');
insert into ADDRESS_BOOK (id, first_name, last_name, work_phone, cell_phone, email_id, date_of_birth, street, city, state, zip_code) values (6, 'Munmro', 'Nibley', '607-222-1562', '713-991-1292', 'mnibley5@bravesites.com', '2012-05-23', '18 Texas Hill', 'Elmira', 'New York', '14905');
insert into ADDRESS_BOOK (id, first_name, last_name, work_phone, cell_phone, email_id, date_of_birth, street, city, state, zip_code) values (7, 'Lutero', 'McIlroy', '513-271-1708', '240-793-1494', 'lmcilroy6@mozilla.com', '2012-09-23', '77 Fuller Pass', 'Cincinnati', 'Ohio', '45249');
insert into ADDRESS_BOOK (id, first_name, last_name, work_phone, cell_phone, email_id, date_of_birth, street, city, state, zip_code) values (8, 'Mick', 'Wooding', '713-641-7434', '803-678-7952', 'mwooding7@telegraph.co.uk', '1981-02-23', '4217 Larry Park', 'Pasadena', 'Texas', '77505');
insert into ADDRESS_BOOK (id, first_name, last_name, work_phone, cell_phone, email_id, date_of_birth, street, city, state, zip_code) values (9, 'Aleksandr', 'Halcro', '918-821-2908', '773-188-9826', 'ahalcro8@qq.com', '1991-02-23', '42911 Briar Crest Crossing', 'Tulsa', 'Oklahoma', '74103');
insert into ADDRESS_BOOK (id, first_name, last_name, work_phone, cell_phone, email_id, date_of_birth, street, city, state, zip_code) values (10, 'Lettie', 'Golston', '801-344-2479', '408-799-6624', 'lgolston9@dailymotion.com', '2001-02-23', '9843 Corben Avenue', 'Salt Lake City', 'Utah', '84110');


commit;







commit;