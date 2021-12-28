package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
// 이 클래스가 클라이언트 요청 처리 담당자임을 표시한다.
// 이 표시(애노테이션)가 붙어 있어야만 스프링부트가 이 클래스를 인식한다.
public class ContactController {


  @RequestMapping("/contact/list")
  public Object list() {
    return ArrayList.toArray();
  }


  @RequestMapping("/contact/add")
  public Object add(Contact contact) {
    //    System.out.println(contact);
    ArrayList.add(contact);
    return ArrayList.size;
  }


  @RequestMapping("/contact/get")
  public Object get(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return "";
    }

    return ArrayList.list[index];
  }



  @RequestMapping("/contact/update")
  public Object update(Contact contact) {
    int index = indexOf(contact.email);
    if (index == -1) {
      return 0;
    }
    return ArrayList.set(index, contact) == null ? 0 : 1;
  }


  @RequestMapping("/contact/delete")
  public Object delete(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return 0;
    }
    ArrayList.remove(index);
    return 1;
  }

  //기능:
  // - 이메일로 연락처 정보를 찾는다.
  // - 찾은 연락처의 배열 인덱스를 리턴한다.
  //
  static int indexOf(String email) {
    for (int i = 0; i < ArrayList.size; i++) {
      Contact contact = (Contact)ArrayList.list[i];  // contact = 주소
      if (contact.email.equals(email)) { 
        return i;
      }
    }
    return -1;
  }

}




