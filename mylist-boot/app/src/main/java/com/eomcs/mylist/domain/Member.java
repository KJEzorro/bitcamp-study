package com.eomcs.mylist.domain;

import java.sql.Date;
import lombok.Data;

@Data
public class Member {
  int no;
  String name;
  String email;
  String password;
  Date regisDate;

}
