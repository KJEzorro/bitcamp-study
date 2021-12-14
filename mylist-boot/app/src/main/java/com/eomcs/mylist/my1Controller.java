package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class my1Controller {

  String[] resInfo = new String[5];
  int size = 0;

  @RequestMapping("/my1/list")
  public Object list() {
    String[] arr = new String[size];
    for(int i=0; i < size; i++) {
      arr[i] = resInfo[i]; 
    }

    return arr;
  }

  @RequestMapping("/my1/add")
  public Object add(String category, String name, String menu, String tel) {
    String rest = category + "," + name + "," + menu + "," + tel;
    resInfo[size++] = rest; 
    return size;

  }

  @RequestMapping("/my1/get")
  public Object get(String tel) {
    for (int i=0; i < size; i++) {
      if (resInfo[i].split(",")[3].equals(tel)) {
        return resInfo[i];
      }
    }
    return "";
  }

  @RequestMapping("/my1/update")
  public Object update(String category, String name, String menu, String tel) {
    String rest = category + "," + name + "," + menu + "," + tel;
    for (int i=0; i < size; i++) {
      if (resInfo[i].split(",")[3].equals(tel)) {
        resInfo[i] = rest;
        return 1;
      } // if end
    } // for end
    return 0;
  }

  @RequestMapping("/my1/delete")
  public Object delete(String tel) {
    for (int i=0; i < size; i++) {
      if (resInfo[i].split(",")[3].equals(tel)) {
        for (int j=i+1; j < size; j++) {
          resInfo[j-1] = resInfo[j];
        } // j for end
        size--;
        return 1;
      } // if end
    } // i for end
    return 0;
  }
}
