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


  public TodoController() {
    System.out.println("TodoController() 호출됨!");

  }

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
  public Object update(int index, Todo todo) throws Exception {
    Todo old = todoDao.findByNo(index);
    if (old == null) {
      return 0;
    }
    todo.setDone(old.isDone()); // 기존의 체크 정보를 그대로 가져가야 한다.
    return todoDao.update(index, todo);
  }

  @RequestMapping("/todo/check")
  public Object check(int index, boolean done) throws Exception {
    return todoDao.updateDone(index, done);
  }

  @RequestMapping("/todo/delete")
  public Object delete(int index) throws Exception {
    return todoDao.delete(index);

  }


}




