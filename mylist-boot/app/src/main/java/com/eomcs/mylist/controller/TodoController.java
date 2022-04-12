package com.eomcs.mylist.controller;

import static com.eomcs.mylist.controller.ResultMap.FAIL;
import static com.eomcs.mylist.controller.ResultMap.SUCCESS;
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
    return new ResultMap().setStatus(SUCCESS).setData(todoService.list());
  }

  @RequestMapping("/todo/add")
  public Object add(Todo todo) throws Exception {
    todoService.add(todo);
    return new ResultMap().setStatus(SUCCESS);
  }

  @RequestMapping("/todo/update")
  public Object update(Todo todo) throws Exception {
    int count = todoService.update(todo);

    if (count == 1) {
      return new ResultMap().setStatus(SUCCESS);
    } else {
      return new ResultMap().setStatus(FAIL).setData("할 일 번호가 유효하지 않거나 할 일 등록자가 아닙니다.");
    }
  }

  @RequestMapping("/todo/check")
  public Object check(int no, boolean done) throws Exception {
    int count = todoService.updateStatus(new Todo(no, done));

    if (count == 1) {
      return new ResultMap().setStatus(SUCCESS);
    } else {
      return new ResultMap().setStatus(FAIL).setData("할 일 번호가 유효하지 않거나 할 일 등록자가 아닙니다.");
    }
  }

  @RequestMapping("/todo/delete")
  public Object delete(int no) throws Exception {
    int count = todoService.delete(no);

    if (count == 1) {
      return new ResultMap().setStatus(SUCCESS);
    } else {
      return new ResultMap().setStatus(FAIL).setData("할 일 번호가 유효하지 않거나 할 일 등록자가 아닙니다.");
    }
  }

}




