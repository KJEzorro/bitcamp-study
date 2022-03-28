package com.eomcs.mylist.domain;

import lombok.Data;

@Data
public class ContactTel {
  int no;
  int contactNo;
  int telTypeNo;
  String tel;

  public ContactTel() {}

  public ContactTel(int telTypeNo, String tel) {
    this.telTypeNo = telTypeNo;
    this.tel = tel;
  }

  public ContactTel(int contactNo, int telTypeNo, String tel) {
    this(telTypeNo, tel);
    this.contactNo = contactNo;
  }

}
