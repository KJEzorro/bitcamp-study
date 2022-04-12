package com.eomcs.mylist.domain;

import java.sql.Date;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Member {
  int no;
  String name;
  String email;
  String password;
  Date registDate;
}
