package com.eomcs.mylist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Todo;
import com.eomcs.mylist.service.TodoService;

@RestController
public class TodoController {

  @Autowired
  TodoService todoService;

  @RequestMapping("/todo/list")
  public Object list() {
    return todoService.list();
  }

  @RequestMapping("/todo/add")
  public Object add(Todo todo) throws Exception {
    return todoService.add(todo);
  }

  @RequestMapping("/todo/update")
  public Object update(Todo todo) throws Exception {
    return todoService.update(todo);
  }

  @RequestMapping("/todo/check")
  public Object check(int no, boolean done) throws Exception {
    return todoService.updateStatus(new Todo(no, done));
  }

  @RequestMapping("/todo/delete")
  public Object delete(int no) throws Exception {
    return todoService.delete(no);
  }

}
