# FlightReservationSpringBoot
 
database(Mysql) scripts
Create database db_ors;
use db_ors

create table user_details(
userId varchar(20) primary key,
password varchar(20),
name varchar(30),
city varchar(30),
email varchar(30),
phone varchar(10));

select * from user_details;

select * from flight_details;

create table flight_details(
flight_Id varchar(20) primary key,
airlines varchar(30),
source varchar(20),
destination varchar(20),
fare double(10,2),
flight_Available_Date date,
departure_Time varchar(15),
arrival_Time varchar(15),
seat_Count int);

insert into flight_details values("F101","WingMeIn","Chennai","Noida",15000.00,
DATE_ADD(CURDATE(), INTERVAL 2 MONTH) ,"08:15","16:45",15);
insert into flight_details values("F102","WingMeIn","Chennai","Noida",15000.00,
DATE_ADD(CURDATE(), INTERVAL 2 MONTH),"11:15","18:30",25);
insert into flight_details values("F103","FlyWithMe","Chennai","Noida",20000.00,
DATE_ADD(CURDATE(), INTERVAL 2 MONTH),"17:45","23:55",10);
insert into flight_details values("F104","FlyWithMe","Pune","Delhi",14000.00,
DATE_ADD(CURDATE(), INTERVAL 2 MONTH),"17:45","12:45",20);
insert into flight_details values("F105","Aviate","Pune","Delhi",14000.00,
DATE_ADD(CURDATE(), INTERVAL 2 MONTH),"17:45","23:45",0);

insert into flight_details values("F106","Aviate","Delhi","Goa",5000.00,DATE_ADD(CURDATE(), INTERVAL 1 MONTH),
"17:45","19:15",10);
insert into flight_details values("F107","WingMeIn","Delhi","Goa",5000.00,
DATE_ADD(CURDATE(), INTERVAL 1 MONTH),"08:15","18:25",15);
insert into flight_details values("F108","FlyWithMe","Pune","Chennai",5000.00,
DATE_ADD(CURDATE(), INTERVAL 1 MONTH),"17:45","23:30",0);
insert into flight_details values("F109","Aviate","Chennai","Bangalore",5000.00,
DATE_ADD(CURDATE(), INTERVAL 1 MONTH),"17:45","23:30",20);
insert into flight_details values("F1010","Aviate","Chennai","Bangalore",5000.00,
DATE_ADD(CURDATE(), INTERVAL 1 MONTH),"17:45","00:45",20);
