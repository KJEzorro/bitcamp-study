```
create table ml_contact(
  contact_no int not null,
  name varchar(50) not null,
  tel varchar(20) not null,
  email varchar(50) not null,
  company varchar(50)
);


alter table ml_contact
  add constraint primary key (contact_no)
  modify column contact_no int not null auto_increment;
