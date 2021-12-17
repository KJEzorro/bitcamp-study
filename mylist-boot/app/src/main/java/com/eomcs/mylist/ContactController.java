package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 이 클래스가 클라이언트 요청 처리 담당자임을 표시한다.
// 이 표시(애노테이션)가 붙어 있어야만 스프링부트가 인식한다.
@RestController 
public class contactController {

  String[] contacts = new String[5];
  int size = 0;

  @RequestMapping("/contact/list")
  public Object list() {
    String[] arr = new String[size];  // 배열에 저장된 값만 복사할 새 배열을 만든다.
    for (int i=0; i < size; i++) {    
      arr[i] = contacts[i];           // 전체 배열에서 값이 들어 있는 항목만 복사한다.
    }
    return arr;  // 복사한 항목들을 담고있는 새 배열을 리턴한다.
  }


  @RequestMapping("/contact/add")
  public Object add(String name, String email, String tel, String company) {
    if (size == contacts.length) { // 배열이 꽉찼다면,
      contacts = grow();  // 메서드 이름에서 해당 코드에 대한 설명을 짐작할 수 있다.
    }
    contacts[size++] = createCSV(name, email, tel, company);
    return size;
  }




  @RequestMapping("/contact/get")
  public Object get(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return "";
    } 
    return contacts[index];
  }



  @RequestMapping("/contact/update")
  public Object update(String name, String email, String tel, String company) {
    int index = indexOf(email);
    if (index == -1) { 
      return 0; 
    }
    contacts[index] = createCSV(name, email, tel, company);
    return 1;
  }


  @RequestMapping("/contact/delete")
  public Object delete(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return 0;
    }
    remove(index); // 메서드 이름으로 코드의 의미를 짐작할 수 있다. 이것이 메서드로 분리하는 이유이다.
    return 1;
  }




  // 기능: 입력 받은 파라미터 값을 가지고 CSV형식으로 문자열을 만들어 준다.
  String createCSV(String name, String email, String tel, String company) {
    return name + "," + email + "," + tel + "," + company;
  }


  // 기능: 이메일로 연락처 정보를 찾는다.
  //       찾은 연락처의 배열 인덱스를 리턴한다.
  int indexOf(String email) {
    for (int i=0; i < size; i++) {
      if (contacts[i].split(",")[1].equals(email)) {
        return i;
      }
    }
    return -1;
  }

  // 기능: 배열에서 지정한 항목을 삭제한다.
  String remove(int index) {
    String old = contacts[index];
    for (int i= index+1; i < size; ++i) {
      contacts[i-1] = contacts[i];
    }
    size--;
    return old;
  }

  // 기능: 배열의 크기를 늘린다.
  //       기존 배열의 값을 복사해온다.
  String[] grow() {
    String[] arr = new String[newLength()];

    // 기존 배열의 값을 새 배열로 복사한다.
    for (int i = 0; i < contacts.length; i++) {
      arr[i] = contacts[i]; 
    }
    return arr;
  }

  // 기능: 주어진 배열에 대해 50% 증가시킨 새 배열의 길이를 알려준다.
  int newLength() {
    return contacts.length + (contacts.length >> 1);
  }
}











