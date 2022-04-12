package com.eomcs.mylist.domain;

import java.sql.Date;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
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
