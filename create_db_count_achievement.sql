/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  sinsnn
 * Created: 2017/5/20
 */
create database  IF NOT exists county_achievement char set utf8 collate utf8_unicode_ci ;
use county_achievement;

create table achievement (
    num int  NOT NULL ,
    work_unit varchar(20) not null default '',
    plan_year year not null ,
    plan_name tinytext not null,
    outlay bigint not null ,
    town varchar(10) not null ,
    village varchar(10) ,
    plan_status varchar(10) not null,
    memo text ,
    date_stamp date,
    fill_person varchar(10) not null,
    primary key (num,work_unit,plan_year)
) 
  char set  utf8
  collate  utf8_unicode_ci ;
  
create table  town (
    num int not null,
    town_name varchar(10) not null ,
    primary key (num)
) 
  char set utf8
  collate utf8_unicode_ci;
  
create table village (
    num int not null,
    village_name varchar(10) not null ,
    town_no int not null ,
    primary key (num),
    foreign key (town_no) references town (num)
) 
  char set utf8
  collate utf8_unicode_ci;
  
create table achievement_town (
    num int  NOT NULL ,
    work_unit varchar(20) not null default '',
    plan_year year not null ,
    town_no int not null ,
    primary key(num, work_unit, plan_year, town_no),
    foreign key (num, work_unit, plan_year) references achievement (num, work_unit, plan_uear),
    foreign key (town_no) references town(num)
    ) 
      char set utf8
      collate utf8_unicode_ci;
      
create table achievement_village (
    num int  NOT NULL ,
    work_unit varchar(20) not null default '',
    plan_year year not null ,
    village_no int not null ,
    primary key(num, work_unit, plan_year, village_no),
    foreign key (num, work_unit, plan_year) references achievement (num, work_unit, plan_name),
    foreign key(village_no) references village(num)
) 
	char set utf8
	collate utf8_unicode_ci;
    
create table town_village_list (
    num int Not null auto_increment,
    town_name varchar(20) ,
    village_name varchar(20),
    primary key (num)
)	
	char set utf8
	collate utf8_unicode_ci;

create table plan_status_list (
    num int Not null auto_increment,
    plan_status varchar(10),
    primary key (num)
)	
	char set utf8
	collate utf8_unicode_ci;
	
CREATE TABLE t_account (
  name VARCHAR(15) NOT NULL,
  password VARCHAR(32) NOT NULL,
  email VARCHAR(255) NOT NULL,
  PRIMARY KEY (name)
) CHARSET=UTF8;


    

