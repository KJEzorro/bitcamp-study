package com.eomcs.mylist.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Todo;
import com.eomcs.util.ArrayList;

@RestController 
public class TodoController {

  ArrayList todoList = new ArrayList();

  public TodoController() throws Exception {
    System.out.println("TodoController() 호출됨!");
    //    FileInputStream in = new FileInputStream("todos.data");
    //    BufferedInputStream in2 = new BufferedInputStream(in);
    //    DataInputStream in3 = new DataInputStream(in2);
    try {
      ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("todos.ser2")));

      //    while (true) { 
      //      try {
      //        Todo todo = (Todo) in.readObject();
      //        todoList.add(todo);
      //
      //      } catch (Exception e) {
      //        break;
      //      }
      //    }

      todoList = (ArrayList)in.readObject(); 

      in.close();
    } catch (Exception e) {
      System.out.println("Todo 데이터 로딩하는 중 오류 발생");
    }
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
  public Object save() throws Exception {
    ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("todos.ser2")));

    //    Object[] arr = todoList.toArray();
    //    for (Object obj : arr) {
    //      out.writeObject(obj);
    //    }

    out.writeObject(todoList);

    out.close();
    return todoList.size();
  }
}




