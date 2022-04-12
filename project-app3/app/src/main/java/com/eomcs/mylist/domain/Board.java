package com.eomcs.mylist.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Board {
  int no;
  String title;
  String content;
  int viewCount;
  java.sql.Date createdDate;
  Member writer;
}
