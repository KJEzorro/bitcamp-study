package com.eomcs.mylist.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyContactController {

  String[] contacts = new String[5];
  int size = 0;

  @RequestMapping("/contact/mylist")
  public Object list() {
    String[] arr = new String[size];
    for (int i = 0; i < size; i++) {
      arr[i] = contacts[i];
    }
    return arr;
  }

}
