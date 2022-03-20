# src/main/resources/static

정적 웹 자원(HTML, CSS, JavaScript, Images 등)을 두는 폴더


```
drop table ml_contact;
drop table ml_tel_type;
-- 연락처
create table ml_contact(
  contact_no int not null,
  name varchar(50) not null,
  email varchar(20) not null,
  company varchar(50)
);

alter table ml_contact
  add constraint primary key (contact_no),
  modify column contact_no int not null auto_increment;

-- 전화번호 유형
create table ml_tel_type(
  tt_no int not null,
  title varchar(20) not null
);

alter table ml_tel_type
  add constraint primary key (tt_no),
  modify column tt_no int not null auto_increment;

-- 연락처 전화번호
create table ml_cont_tel(
  ct_no int not null, -- 전화번호 PK
  contact_no int not null, -- 연락처 PK
  tt_no int not null, -- 전화번호 유형 PK
  tel varchar(20) not null -- 전화번호
  );

alter table ml_cont_tel
  add constraint primary key (ct_no),
  modify column ct_no int not null auto_increment;

alter table ml_cont_tel
  add constraint ml_cont_tel_fk1
    foreign key (contact_no) references ml_contact(contact_no),
  add constraint ml_cont_tel_fk2
    foreign key (tt_no) references ml_tel_type(tt_no);

-- 전화번호 유형 입력
insert into ml_tel_type(tt_no, title)
  values(1, '전화');
insert into ml_tel_type(tt_no, title)
  values(2, '팩스');
insert into ml_tel_type(tt_no, title)
  values(3, '휴대전화');
insert into ml_tel_type(tt_no, title)
  values(4, '직장전화');
insert into ml_tel_type(tt_no, title)
  values(5, '직장팩스');



-- 연락처 기본 정보 등록
insert into ml_contact(contact_no,name,email,company)
  values(1,'사람1','user1@test.com','비트캠프');
insert into ml_contact(contact_no,name,email,company)
  values(2,'사람2','user2@test.com','비트캠프');
insert into ml_contact(contact_no,name,email,company)
  values(3,'사람3','user3@test.com','비트캠프');

-- 연락처에 전화번호 추가
insert into ml_cont_tel(ct_no, contact_no, tt_no, tel)
  values(1, 1, 1, '02-1111-1111');
insert into ml_cont_tel(ct_no, contact_no, tt_no, tel)
  values(2, 1, 2, '02-1111-1112');
insert into ml_cont_tel(ct_no, contact_no, tt_no, tel)
  values(3, 1, 3, '010-1111-1111');
insert into ml_cont_tel(ct_no, contact_no, tt_no, tel)
  values(4, 2, 3, '010-1111-2222');
insert into ml_cont_tel(ct_no, contact_no, tt_no, tel)
  values(5, 3, 3, '010-1111-3333');










```
