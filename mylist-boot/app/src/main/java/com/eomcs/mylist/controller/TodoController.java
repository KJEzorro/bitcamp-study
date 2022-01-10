package com.eomcs.mylist.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.io.FileWriter2;
import com.eomcs.mylist.domain.Todo;
import com.eomcs.util.ArrayList;

@RestController 
public class TodoController {

  // Todo 객체 목록을 저장할 메모리를 준비한다.
  ArrayList todoList = new ArrayList();

  public TodoController() throws Exception{

    System.out.println("TodoController() 호출됨");

    com.eomcs.io.FileReader2 in = new com.eomcs.io.FileReader2("todos.csv");

    String line;
    while ((line = in.readLine()).length() != 0) { // 빈 줄을 리턴받았으면 읽기를 종료한다.
      todoList.add(Todo.valueOf(line)); // 파일에서 읽은 CSV 데이터로 객체를 초기화시킨후 목록에 등록한다.
    }
    in.close();
  }

  @RequestMapping("/todo/list")
  public Object list() {
    return todoList.toArray(); 
  }

  @RequestMapping("/todo/add")
  public Object add(Todo todo) {
    todoList.add(todo);
    return todoList.size();
  }

  @RequestMapping("/todo/update")
  public Object update(int index, Todo todo) {
    if (index < 0 || index >= todoList.size()) {
      return 0;
    }

    Todo old = (Todo) todoList.get(index);
    todo.setDone(old.isDone()); // 기존의 체크 정보를 그대로 가져가야 한다.

    return todoList.set(index, todo) == null ? 0 : 1;
  }

  @RequestMapping("/todo/check")
  public Object check(int index, boolean done) {
    if (index < 0 || index >= todoList.size()) {
      return 0;  // 인덱스가 무효해서 설정하지 못했다.
    }

    ((Todo) todoList.get(index)).setDone(done);
    return 1; // 해당 항목의 상태를 변경했다.
  }

  @RequestMapping("/todo/delete")
  public Object delete(int index) {
    if (index < 0 || index >= todoList.size()) {
      return 0;
    }

    todoList.remove(index);
    return 1;
  }


  @RequestMapping("/todo/save")
  public Object save() throws Exception{
    // 따로 경로를 지정하지 않으면 파일은 프로젝트 폴더에 생성된다.
    FileWriter2 out = new FileWriter2("todos.csv");

    Object[] arr = todoList.toArray();
    for (Object obj : arr) {
      Todo todo = (Todo) obj;
      out.println(todo.toCsvString());
    }
    out.close();
    return arr.length;
  }

}




