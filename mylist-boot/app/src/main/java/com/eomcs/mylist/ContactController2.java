package com.eomcs.mylist;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 클라이언트 요청을 처리하는 역할
public class ContactController2 {
  //  String[] contacts = new String[5];

  @GetMapping("/contact/list2")
  public Object list2() {
    String contacts[] = {
        "홍길동,hong@test.com,010-1111-2222,비트캠프",
        "임꺽정,leem@test.com,010-3333-4444,비비트캠프",
        "장길산,jang@test.com,010-5555-6666,비비비트캠프"
    };
    return contacts;
  }

  @GetMapping("/contact/add2")
  public Object add2(String name, String email, String tel, String company) {
    String contact = name + "," + email + "," + tel + "," + company;
    return contact;
  }


}
