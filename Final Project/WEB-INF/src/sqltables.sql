drop table projects_done;
drop table query;
drop table bid;
drop table post_project;
drop table registration;
drop sequence pr_id;
create table registration1(username varchar2(20) primary key,password varchar2(20) not null,user_type varchar2(20),user_address varchar2(256),mobile_number number(10),email_id varchar2(30));


drop table profile;
create table profile(userid varchar2(20) primary key,tenth varchar2(20) not null,twelth varchar2(20),ug varchar2(30),pg varchar2(30),aoi varchar2(256),cn varchar2(30),contact varchar2(15),email varchar2(30));

create table company(name varchar2(20),sector varchar2(20),details varchar2(1000));

insert into company values('TCS','consultancy','Tata Consultancy Services Limited is an Indian multinational information technology services business solutions and consulting company headquartered in Mumbai Maharashtra TCS operates in 44 countries and has 199 branches across the world It is a subsidiary of the Tata Group and is listed on the Bombay Stock Exchange and the National Stock Exchange of India.' Its main function is to provide IT services. TCS is the largest Indian company by market capitalization[6][7] and is the largest India-based IT services company by 2013 revenues.);
