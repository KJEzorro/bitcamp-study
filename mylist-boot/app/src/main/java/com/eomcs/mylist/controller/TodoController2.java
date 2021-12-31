package com.eomcs.mylist.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Todo;
import com.eomcs.util.ArrayList2;


@RestController 
public class TodoController2 {

  ArrayList2 todoList2 = new ArrayList2(); 

  @RequestMapping("/todo2/list")
  public Object list() {
    return todoList2.toArray(); 
  }

  @RequestMapping("/todo2/add")
  public Object add(Todo todo) {
    todoList2.add(todo);
    return todoList2.size();
  }

  @RequestMapping("/todo2/update")
  public Object update(int index, Todo todo) {
    if (index < 0 || index >= todoList2.size()) {
      return 0;
    }
    Todo old = (Todo)todoList2.get(index);
    todo.setDone(old.isDone());

    return todoList2.set(index, todo) == null ? 0 : 1;
  }

  @RequestMapping("/todo2/check")
  public Object check(int index, boolean done) {
    if (index < 0 || index >= todoList2.size()) {
      return 0;  // 인덱스가 무효해서 설정하지 못했다.
    }

    ((Todo) todoList2.get(index)).setDone(done);
    return 1; // 해당 항목의 상태를 변경했다.
  }

  @RequestMapping("/todo2/delete")
  public Object delete(int index) {
    if (index < 0 || index >= todoList2.size()) {
      return 0;
    }

    todoList2.remove(index);
    return 1;
  }
}




