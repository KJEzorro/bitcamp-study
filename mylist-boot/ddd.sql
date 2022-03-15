```
create table ml_todo(
  todo_no int not null,
  title varchar(255) not null,
  done boolean default false
);


alter table ml_todo
  add constraint primary key(todo_no);
  modify column todo_no not null int auto_increment;


alter table ml_todo
  modify todo_no int not null auto_increment;
