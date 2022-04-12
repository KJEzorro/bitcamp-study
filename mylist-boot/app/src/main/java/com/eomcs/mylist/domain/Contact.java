package com.eomcs.mylist.domain;

import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Contact {
  int no;
  String name;
  String email;
  String company;
  List<ContactTel> tels;
}
