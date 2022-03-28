package com.eomcs.mylist.domain;

import java.sql.Date;
import lombok.Data;

@Data
public class Book {
  int no;
  String title;
  String author;
  String press;
  String feed;
  Date readDate;
  int page;
  int price;
  String photo;

}
