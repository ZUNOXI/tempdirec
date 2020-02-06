show databases;
create database javer;
use javer;
create table news(
	img varchar(1000),
    urltitle varchar(1000),
    title varchar(1000)
);
select*from news;

-- drop -- 
drop table member;
drop table board;
drop table comment;
drop table replycomment;
drop table replyboard;


create table member(
                uid varchar(100) primary key,
                upw varchar(100) not null,
                uname varchar(100) not null,
                unickname varchar(100) not null unique,
                uphonenum varchar(100) unique,
                uemail varchar(100) unique,
                uaddress varchar(100),
                ufavor_ctg varchar(100),
				uprofilephoto varchar(2000),
                ubirth_date date,
                ujoin_date date not null,
                rcmd_blst varchar(4000)
                );
select*from member;


create table board(
                bnum int auto_increment primary key,
                uid varchar(100) references member(uid) on delete cascade,
                btitle varchar(500),
                bcontent varchar(10000),
                bhit int,
                bcreation_date date,
                bctg varchar(100)
                );
select *from board;
                
create table comment(
				cnum int auto_increment primary key,
                bnum int references board(bnum) on delete cascade, 
                uid varchar(100) references member(uid) on delete cascade,
                ccontent varchar(1000),
                ccreation_date date
                );
create table replycomment(
                rnum int auto_increment primary key,                
                cnum int references comment(cnum) on delete cascade,
                uid varchar(100) references member(uid) on delete cascade,
                rcontent varchar(1000),
                rcreation_date date
                );
                
                
create table replyboard(
				rnum int auto_increment primary key,
				bnum int references comment(bnum) on delete cascade,				
				uid varchar(100) references member(uid) on delete cascade,
				rcontent varchar(1000),
				rcreation_date date
);
                
use javer;
select * from member;
select * from board;
select * from comment;
select * from replyboard;
select * from replycomment;
​
delete from member where uid="admin";
​
insert into member(uid,upw, uname, unickname, uphonenum, uemail, ujoin_date)
VALUES ('ssafy', ' 1111', 'asd', 'asdf' ,'sadf', 'asdf', now());
​
insert into board(uid, btitle, bcontent, bctg)
values ('ssafy', 'asdf', 'cvxb', 'fund');
​
​
####################### ZuNo ##########################
​
delete from stock;
drop table stock;
CREATE TABLE stock (
  num int(100) NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  now varchar(100),
  close varchar(100),
  high varchar(100),
  open varchar(100),
  low varchar(100),
  PRIMARY KEY (num)
);
select * from stock;
insert into stock(name,now,close,high,open,low) values("co_name","now_price","close","high","open","low");
