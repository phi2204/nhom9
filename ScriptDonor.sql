
CREATE DATABASE donation;
USE donation;

Create table user
(
	id Integer Auto_increment NOT NULL,
	id_role Integer NOT NULL,
	ho_ten Varchar(50) NULL,
	email Varchar(50) NULL,
	password Varchar(50) NULL,
	dia_chi Varchar(100) NULL,
Primary Key (id)
) ;

Create table to_chuc
(
	id Integer Auto_increment NOT NULL,
	ten_tc Varchar(100) NULL,
	website Varchar(200) NULL,
	mo_ta Varchar(200) NULL,
Primary Key (id)
);


Create table topic
(
	id Integer Auto_increment NOT NULL,
	id_org Integer NOT NULL,
	ten_topic Varchar(100) NULL,
	mo_ta Varchar(200) NULL,
    noi_dung Varchar(500) NULL,
	so_tien Integer NULL,
    money_donor Integer NULL,
    img Varchar(100) NULL,
Primary Key (id)
) ;


Create table donations
(
	id Integer Auto_increment NOT NULL,
	id_user Integer NOT NULL,
	id_topic Integer NOT NULL,
	so_tien Integer NULL,
	ngay_tao date NULL,
	tin_nhan Varchar(100) NULL,
	credit_number Integer NULL,
	expiration_date date NULL,
	security_code Char(10) NULL,
	name_card Varchar(50) NULL,
Primary Key (id)
) ;
Create table role
(
	id Integer Auto_increment NOT NULL,
	ten_role Varchar(50) NULL,
Primary Key (id)
) ;

Alter table donations add  foreign key(id_user) references user (id)  on update no action on delete no action ;

Alter table topic add  foreign key(id_org) references to_chuc (id)  on update no action on delete no action ;

Alter table donations add  foreign key(id_topic) references topic (id)  on update no action on delete no action ;

Alter table user add  foreign key(id_role) references role (id)  on update no action on delete no action ;
INSERT INTO role(ten_role) VALUES ('USER'),('ADMIN');
INSERT INTO user(id_role,ho_ten,email,password,dia_chi) VALUES (2,'Đào Nguyễn Ngọc Đức','daoduc132@gmail.com','MTIzNDU2','tam điệp ninh bình'),(1,'Đào Hồng Hạnh','dhh1204@gmail.com','MTIzNDU2','Ninh Bình'),(2,'Trịnh Thanh Vân','ttv@gmail.com','MTIzNDU2','Tam Điệp Ninh Bình');

Insert into to_chuc(ten_tc,website,mo_ta) Values("3m","https://www.3m.com/","3m");
Insert into to_chuc(ten_tc,website,mo_ta) Values("Airbnb","https://www.airbnb.com/","Airbnb");
Insert into to_chuc(ten_tc,website,mo_ta) Values("ball","https://www.ball.com/","ball");
Insert into to_chuc(ten_tc,website,mo_ta) Values("Arconic foundation","https://www.arconic.com/foundation/en/home.asp","Arconic foundation");

Insert into topic(id_org,ten_topic,mo_ta,noi_dung,so_tien,money_donor,img) Values("1","Circle of Change","A love of cloth diapers first fueled our mission to help vulnerable babies 
in need. Over the years, we've seen firsthand the impact diapers",
"A love of cloth diapers first fueled our mission to help vulnerable babies in need. Over the years, we've seen firsthand the impact diapers and other hygiene products 
can have on an entire families' quality of life. Join our passionate community of individuals who are dedicated to improving the lives of babies, 
children and adults by helping to restore human dignity and hope. Every person is just one circumstance away from a devastating life challenge. ","43200","0","circleofchange.jpg");

Insert into topic(id_org,ten_topic,mo_ta,noi_dung,so_tien,money_donor,img) Values("1","Emergency Veterinary Care for Pets of the Homeless","Your donation will help a pet that belongs to a homeless person in the U.S., and Canada.",
"Your donation will help a pet that belongs to a homeless person in the U.S., and Canada. 
We provide emergency veterinary care and pet food to the hundreds of thousands of pets that are companions to the homeless.
Your donation will help a pet that belongs to a homeless person in the U.S., and Canada. 
We provide emergency veterinary care and pet food to the hundreds of thousands of pets that are companions to the homeless.","600000","200000","pethomeless.jpg");

Insert into topic(id_org,ten_topic,mo_ta,noi_dung,so_tien,money_donor,img) Values("2","Save the Lives of Domestic Pigeons & Doves","Every year Palomacy Pigeon & Dove Adoptions saves hundreds of domestic, 
unreleasable birds.",
"Every year Palomacy Pigeon & Dove Adoptions saves hundreds of domestic, unreleasable birds from death by providing rescue, coaching, referrals, veterinary care, 
foster & forever homes. Palomacy is closing a deadly gap in the animal rescue community. Smart, gentle, innocent domestic pigeons & doves, bred for business & hobbies, 
lost & injured, can't live free & need our help to be rescued & adopted. They deserve compassion. They are not disposable. Euthanasia is not the alternative to adoption.","420000","0","pigeon.jpg");

Insert into topic(id_org,ten_topic,mo_ta,noi_dung,so_tien,money_donor,img) Values("3","Healthy School Food: Recipe for the Future","School food professionals are facing difficulties like never before. Challenges with supply.",
"School food professionals are facing difficulties like never before. Challenges with supply chain interruptions and labor shortages have made it extremely 
difficult to serve students fresh and nutritious meals. However, we cannot lose sight of the many years of healthy school food momentum - and how healthy food can create 
tangible and long-term change.","100000","50000","foodschool.jpg");

Insert into topic(id_org,ten_topic,mo_ta,noi_dung,so_tien,money_donor,img) Values("3","Help Wisconsin babies stay clean, dry, and healthy","All babies deserve to be clean, dry and healthy. 
Yet 1 in 7 kids in the state live in families who struggle to meet the basic needs. ",
"All babies deserve to be clean, dry and healthy. Yet 1 in 7 kids in the state live in families. 
With no federal safety net programs (WIC, food stamps) covering the cost of diapers, this is a problem. Our Eastern Wisconsin Diaper Bank program exists 
to solve this problem for more than 5,000 children struggling to have their diaper needs met.","25000","16564","baby.jpg");

INSERT INTO donations(id_user,id_topic,so_tien,ngay_tao,tin_nhan,credit_number,expiration_date,security_code,name_card) VALUES (1,1,1000,'2023-03-26','Đóng góp',1233455,'2023-09-01','12344','Đào Ngọc Đức')