package com.eomcs.mylist.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Contact;
import com.eomcs.util.ArrayList2;

@RestController  
public class ContactController2 {

  // Contact 객체 목록을 저장할 메모리 준비
  // => Object[] list = new Object[5];
  // => int size = 0;
  ArrayList2 contactList2 = new ArrayList2();

  @RequestMapping("/contact2/list")
  public Object list() {
    return contactList2.toArray(); 
  }

  @RequestMapping("/contact2/add")
  public Object add(Contact contact) {
    //    System.out.println(contact);
    contactList2.add(contact);
    return contactList2.size();
  }


  @RequestMapping("/contact2/get")
  public Object get(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return "";
    }
    return contactList2.get(index);
  }

  @RequestMapping("/contact2/update")
  public Object update(Contact contact) {
    int index = indexOf(contact.getEmail());
    if (index == -1) {
      return 0;
    }

    return contactList2.set(index, contact) == null ? 0 : 1;
  }

  @RequestMapping("/contact2/delete")
  public Object delete(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return 0;
    }

    contactList2.remove(index);
    return 1;
  }

  int indexOf(String email) {
    for (int i = 0; i < contactList2.size(); i++) {
      Contact contact =  (Contact) contactList2.get(i);
      if (contact.getEmail().equals(email)) { 
        return i;
      }
    }
    return -1;
  }
}




