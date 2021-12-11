package com.eomcs.mylist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 클라이언트 요청을 처리하는 역할
public class ContactController2 {
  String[] contacts = new String[5];
  int size = 0;

  @GetMapping("/contact/list2")
  public Object list2() {
    String[] records = new String[size];
    for (int i=0; i < size; i++) {
      records[i] = contacts[i]; 
    }
    return records;
  }

  @GetMapping("/contact/add2")
  public Object add2(String name, String email, String tel, String company) {
    contacts[size++] = name + "," + email + "," + tel + "," + company;
    return size;
  }

  @GetMapping("/contact/get2")
  public Object get2(String email) {
    for (int i=0; i < size; i++) {
      if (email.equals(contacts[i].split(",")[1])) {
        return contacts[i];
      }
    }
    return "";
  }


}
