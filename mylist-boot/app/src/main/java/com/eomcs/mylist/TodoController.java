package com.eomcs.mylist;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
// 이 클래스가 클라이언트 요청 처리 담당자임을 표시한다.
// 이 표시(애노테이션)가 붙어 있어야만 스프링부트가 이 클래스를 인식한다.
public class TodoController {


  @RequestMapping("/todo/list")
  public Object list() {
    return ArrayList2.toArray();
  }


  @RequestMapping("/todo/add")
  public Object add(Todo todo) {
    ArrayList2.add(todo);
    return ArrayList2.size;
  }



  @RequestMapping("/todo/update")
  public Object update(int index, Todo todo) {
    if (index < 0 || index>= ArrayList2.size) {
      return 0;
    }
    return ArrayList2.set(index, todo) == null ? 0 : 1;
  }

  @RequestMapping("/todo/check")
  public Object check(int index, boolean done) {
    if (index < 0 || index>= ArrayList2.size) {
      return 0;  // 인덱스가 무효해서 설정하지 못했다.
    }
    ArrayList2.list[index].done = done;
    return 1;  // 해당 항목의 상태를 변경했다.
  }


  @RequestMapping("/todo/delete")
  public Object delete(int index) {
    if (index < 0 || index>= ArrayList2.size) {
      return 0;
    }
    ArrayList2.remove(index);
    return 1;
  }

}




