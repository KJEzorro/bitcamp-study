package com.eomcs.mylist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.dao.TodoDao;
import com.eomcs.mylist.domain.Todo;

@RestController
public class TodoController {

  @Autowired
  TodoDao todoDao;

  @RequestMapping("/todo/list")
  public Object list() {
    return todoDao.findAll();
  }

  @RequestMapping("/todo/add")
  public Object add(Todo todo) throws Exception {
    todoDao.insert(todo);
    return todoDao.countAll();
  }

  @RequestMapping("/todo/update")
  public Object update(Todo todo) throws Exception {
    return todoDao.update(todo);
  }

  @RequestMapping("/todo/check")
  public Object check(int no, boolean done) throws Exception {
    return todoDao.updateDone(no, done);
  }

  @RequestMapping("/todo/delete")
  public Object delete(int no) throws Exception {
    return todoDao.delete(no);
  }

}
